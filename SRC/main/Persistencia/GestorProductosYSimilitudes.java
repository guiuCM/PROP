package Persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorProductosYSimilitudes extends Gestor {

    @Override
    public void inicializarBaseDeDatos() {
        String sqlCrearTablaProductos = """
                    CREATE TABLE IF NOT EXISTS productos (
                        id INTEGER PRIMARY KEY,
                        nombre TEXT NOT NULL,
                        precio REAL NOT NULL,
                        descripcion TEXT NOT NULL,
                        peso REAL NOT NULL,
                        marca TEXT NOT NULL
                    );
                """;

        String sqlCrearTablaSimilitudes = """
                    CREATE TABLE IF NOT EXISTS similitudes (
                        id_producto1 INTEGER,
                        id_producto2 INTEGER,
                        similitud INTEGER,
                        PRIMARY KEY (id_producto1, id_producto2),
                        FOREIGN KEY (id_producto1) REFERENCES productos(id) ON DELETE CASCADE,
                        FOREIGN KEY (id_producto2) REFERENCES productos(id) ON DELETE CASCADE
                    );
                """;

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCrearTablaProductos);
            stmt.execute(sqlCrearTablaSimilitudes);
            System.out.println("Tablas Productos y Similitudes inicializadas correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void borrarBaseDeDatos() {
        String sqlBorrarSimilitudes = "DROP TABLE IF EXISTS similitudes";
        String sqlBorrarProductos = "DROP TABLE IF EXISTS productos";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlBorrarSimilitudes);
            stmt.execute(sqlBorrarProductos);
            System.out.println("Tablas Productos y Similitudes borradas correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar las tablas: " + e.getMessage());
        }
    }

    public void borrarTablaSimilitudes() {
        String sqlBorrarSimilitudes = "DROP TABLE IF EXISTS similitudes";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlBorrarSimilitudes);
            System.out.println("Tablas Similitudes borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar las tablas: " + e.getMessage());
        }
    }


    public void insertarProducto(int id, String nombre, double precio, String descripcion, double peso, String marca) {
        String sql = "INSERT INTO productos (id, nombre, precio, descripcion, peso, marca) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setDouble(3, precio);
            pstmt.setString(4, descripcion);
            pstmt.setDouble(5, peso);
            pstmt.setString(6, marca);
            pstmt.executeUpdate();
            System.out.println("Producto insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar producto: " + e.getMessage());
        }
    }

    public void insertarSimilitud(int idProducto1, int idProducto2, int similitud) {
        String sql = "INSERT INTO similitudes (id_producto1, id_producto2, similitud) VALUES (?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto1);
            pstmt.setInt(2, idProducto2);
            pstmt.setInt(3, similitud);
            pstmt.executeUpdate();
            System.out.println("Similitud insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar similitud: " + e.getMessage());
        }
    }

    public void borrarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Producto borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar producto: " + e.getMessage());
        }
    }


    public void selectProducto(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Producto seleccionado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al seleccionar producto: " + e.getMessage());
        }
    }

    public void selectSimilitud(int idProducto1, int idProducto2) {
        String sql = "SELECT * FROM similitudes WHERE id_producto1 = ? AND id_producto2 = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto1);
            pstmt.setInt(2, idProducto2);
            pstmt.executeUpdate();
            System.out.println("Similitud seleccionada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al seleccionar similitud: " + e.getMessage());
        }
    }

    public void modificarSimilitud(int idProducto1, int idProducto2, int Similitud) {
        String sql = "UPDATE similitudes SET similitud = ? WHERE id_producto1 = ? AND id_producto2 = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Similitud);
            pstmt.setInt(2, idProducto1);
            pstmt.setInt(3, idProducto2);
            pstmt.executeUpdate();
            System.out.println("Similitud actualizada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar similitud: " + e.getMessage());
        }
    }

    public Object[][] seleccionarTodosLosProductos() {
        String sql = "SELECT * FROM productos";
        List<Object[]> listaProductos = new ArrayList<>();

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int numeroColumnas = metaData.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[numeroColumnas];
                for (int i = 1; i <= numeroColumnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                listaProductos.add(fila);
            }

        } catch (SQLException e) {
            System.err.println("Error al seleccionar todos los productos: " + e.getMessage());
        }
        return listaProductos.toArray(new Object[0][0]);
    }

    public Object[][] seleccionarTodasLasSimilitudes() {
        String sql = "SELECT * FROM similitudes";
        List<Object[]> listaSimilitudes = new ArrayList<>();

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int numeroColumnas = metaData.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[numeroColumnas];
                for (int i = 1; i <= numeroColumnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                listaSimilitudes.add(fila);
            }

        } catch (SQLException e) {
            System.err.println("Error al seleccionar todos los productos: " + e.getMessage());
        }
        return listaSimilitudes.toArray(new Object[0][0]);
    }

}
