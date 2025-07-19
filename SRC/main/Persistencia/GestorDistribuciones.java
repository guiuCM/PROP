package Persistencia;

import util.Par;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GestorDistribuciones extends Gestor {

    @Override
    public void inicializarBaseDeDatos() {
        String sqlCrearTablaDistribuciones = """
            CREATE TABLE IF NOT EXISTS distribuciones (
                id_distribucion INTEGER,
                id_usuario TEXT,
                tipo_algoritmo TEXT NOT NULL,
                puntuacion INTEGER,
                steps INTEGER,
                PRIMARY KEY (id_distribucion, id_usuario),
                FOREIGN KEY (id_usuario) REFERENCES tablaUsuarios(name) ON DELETE CASCADE
            );
        """;

        String sqlCrearTablaDetalleDistribuciones = """
            CREATE TABLE IF NOT EXISTS detalle_distribuciones (
                id_distribucion INTEGER,
                id_usuario TEXT,
                fila INTEGER,
                columna INTEGER,
                id_producto INTEGER,
                PRIMARY KEY (id_distribucion, id_usuario, fila, columna),
                FOREIGN KEY (id_distribucion, id_usuario) REFERENCES distribuciones(id_distribucion, id_usuario) ON DELETE CASCADE,
                FOREIGN KEY (id_producto) REFERENCES productos(id) ON DELETE CASCADE
            );
        """;

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCrearTablaDistribuciones);
            stmt.execute(sqlCrearTablaDetalleDistribuciones);
            System.out.println("Tablas de distribuciones inicializadas correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void borrarBaseDeDatos() {
        String sqlBorrarDetalleDistribuciones = "DROP TABLE IF EXISTS detalle_distribuciones";
        String sqlBorrarDistribuciones = "DROP TABLE IF EXISTS distribuciones";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlBorrarDetalleDistribuciones);
            stmt.execute(sqlBorrarDistribuciones);
            System.out.println("Tablas de distribuciones eliminadas correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar las tablas de distribuciones: " + e.getMessage());
        }
    }

    /**
     * Inserta una distribución y su detalle.
     *
     * @param idDistribucion    Identificador de la distribución
     * @param idUsuario         Identificador del usuario
     * @param tipoAlgoritmo     Tipo de algoritmo
     * @param puntuacion        Puntuación de la distribución
     * @param steps             Número de pasos
     * @param matrizDistribucion Matriz que describe la distribución (id de productos)
     */
    public void insertarDistribucion(int idDistribucion, String idUsuario, String tipoAlgoritmo, int puntuacion, long steps, int[][] matrizDistribucion) {
        String sqlInsertarDistribucion = "INSERT INTO distribuciones (id_distribucion, id_usuario, tipo_algoritmo, puntuacion, steps) VALUES (?, ?, ?, ?, ?)";
        String sqlInsertarDetalleDistribucion = "INSERT INTO detalle_distribuciones (id_distribucion, id_usuario, fila, columna, id_producto) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmtDistribucion = conn.prepareStatement(sqlInsertarDistribucion);
             PreparedStatement pstmtDetalle = conn.prepareStatement(sqlInsertarDetalleDistribucion)) {

            // Insertar la distribución principal
            pstmtDistribucion.setInt(1, idDistribucion);
            pstmtDistribucion.setString(2, idUsuario);
            pstmtDistribucion.setString(3, tipoAlgoritmo);
            pstmtDistribucion.setInt(4, puntuacion);
            pstmtDistribucion.setLong(5, steps);
            pstmtDistribucion.executeUpdate();

            // Insertar los detalles de la distribución
            for (int i = 0; i < matrizDistribucion.length; i++) {
                for (int j = 0; j < matrizDistribucion[i].length; j++) {
                    pstmtDetalle.setInt(1, idDistribucion);
                    pstmtDetalle.setString(2, idUsuario);
                    pstmtDetalle.setInt(3, i);
                    pstmtDetalle.setInt(4, j);
                    pstmtDetalle.setInt(5, matrizDistribucion[i][j]);
                    pstmtDetalle.addBatch();
                }
            }
            pstmtDetalle.executeBatch();
            System.out.println("Distribución insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar la distribución: " + e.getMessage());
        }
    }

    /**
     * Borra una distribución y su detalle.
     *
     * Dado que la clave primaria es compuesta por (id_distribucion, id_usuario),
     * se requiere ambos parámetros.
     */
    public void borrarDistribucion(int idDistribucion, String idUsuario) {
        String sqlBorrarDetalleDistribucion = "DELETE FROM detalle_distribuciones WHERE id_distribucion = ? AND id_usuario = ?";
        String sqlBorrarDistribucion = "DELETE FROM distribuciones WHERE id_distribucion = ? AND id_usuario = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmtDetalle = conn.prepareStatement(sqlBorrarDetalleDistribucion);
             PreparedStatement pstmtDistribucion = conn.prepareStatement(sqlBorrarDistribucion)) {

            pstmtDetalle.setInt(1, idDistribucion);
            pstmtDetalle.setString(2, idUsuario);
            pstmtDetalle.executeUpdate();

            pstmtDistribucion.setInt(1, idDistribucion);
            pstmtDistribucion.setString(2, idUsuario);
            pstmtDistribucion.executeUpdate();

            System.out.println("Distribución borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar la distribución: " + e.getMessage());
        }
    }


    public Par<int[][], String> selectDistribucion(int idDistribucion, String idUsuario) {
        String sqlDistribucion = "SELECT tipo_algoritmo FROM distribuciones WHERE id_distribucion = ? AND id_usuario = ?";
        String sqlDetalle = "SELECT fila, columna, id_producto FROM detalle_distribuciones WHERE id_distribucion = ? AND id_usuario = ? ORDER BY fila, columna";

        try (Connection conn = conectar();
             PreparedStatement pstmtDistribucion = conn.prepareStatement(sqlDistribucion);
             PreparedStatement pstmtDetalle = conn.prepareStatement(sqlDetalle)) {

            // Obtener el tipo de algoritmo de la distribución
            pstmtDistribucion.setInt(1, idDistribucion);
            pstmtDistribucion.setString(2, idUsuario);
            ResultSet rsDist = pstmtDistribucion.executeQuery();

            if (!rsDist.next()) {
                // No se encontró la distribución
                return null;
            }

            String tipoAlgoritmo = rsDist.getString("tipo_algoritmo");

            // Obtener el detalle de la distribución
            pstmtDetalle.setInt(1, idDistribucion);
            pstmtDetalle.setString(2, idUsuario);
            ResultSet rsDet = pstmtDetalle.executeQuery();

            Map<Integer, Map<Integer, Integer>> matrizTemp = new HashMap<>();

            // Armar la matriz temporal
            while (rsDet.next()) {
                int fila = rsDet.getInt("fila");
                int columna = rsDet.getInt("columna");
                int idProducto = rsDet.getInt("id_producto");
                matrizTemp.putIfAbsent(fila, new HashMap<>());
                matrizTemp.get(fila).put(columna, idProducto);
            }

            // Obtener el tamaño de la matriz
            int maxFila = matrizTemp.size();
            int maxColumna = 0;
            if (maxFila > 0) {
                // Suponemos que todas las filas tienen el mismo número de columnas
                maxColumna = matrizTemp.get(matrizTemp.keySet().iterator().next()).size();
            }

            // Construir la matriz final
            int[][] matrizDistribucion = new int[maxFila][maxColumna];
            for (Map.Entry<Integer, Map<Integer, Integer>> entryFila : matrizTemp.entrySet()) {
                int fila = entryFila.getKey();
                for (Map.Entry<Integer, Integer> entryColumna : entryFila.getValue().entrySet()) {
                    int columna = entryColumna.getKey();
                    matrizDistribucion[fila][columna] = entryColumna.getValue();
                }
            }

            // Retornar la distribución como Par<int[][], String>
            return new Par<>(matrizDistribucion, tipoAlgoritmo);

        } catch (SQLException e) {
            System.err.println("Error al seleccionar la distribución: " + e.getMessage());
            return null;
        }
    }

    public int obtenerPuntuacionDistribucion(int idDistribucion, String idUsuario) {
        String sql = "SELECT puntuacion FROM distribuciones WHERE id_distribucion = ? AND id_usuario = ?";
        int puntuacion = -1; // Valor por defecto en caso de no encontrar la distribución

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idDistribucion);
            pstmt.setString(2, idUsuario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                puntuacion = rs.getInt("puntuacion");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la puntuación de la distribución: " + e.getMessage());
        }

        return puntuacion;
    }

    /**
     * Nuevo método: obtiene el valor de steps de una distribución específica.
     */
    public int obtenerStepsDistribucion(int idDistribucion, String idUsuario) {
        String sql = "SELECT steps FROM distribuciones WHERE id_distribucion = ? AND id_usuario = ?";
        int steps = -1; // Valor por defecto en caso de no encontrar la distribución

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idDistribucion);
            pstmt.setString(2, idUsuario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                steps = rs.getInt("steps");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los steps de la distribución: " + e.getMessage());
        }

        return steps;
    }

    /**
     * Selecciona todas las distribuciones asociadas a un usuario.
     * Retorna un mapa donde la llave es el id_distribucion y el valor es un Par<int[][], String>
     * que contiene la matriz de productos y el tipo de algoritmo.
     */
    public Map<Integer, Par<int[][], String>> selectDistrosUser(String idUser) {
        String sqlDistribuciones = "SELECT id_distribucion, tipo_algoritmo FROM distribuciones WHERE id_usuario = ?";
        String sqlDetalleDistribuciones = "SELECT fila, columna, id_producto FROM detalle_distribuciones WHERE id_distribucion = ? AND id_usuario = ?";

        Map<Integer, Par<int[][], String>> resultados = new HashMap<>();

        try (Connection conn = conectar();
             PreparedStatement pstmtDistribuciones = conn.prepareStatement(sqlDistribuciones);
             PreparedStatement pstmtDetalle = conn.prepareStatement(sqlDetalleDistribuciones)) {

            pstmtDistribuciones.setString(1, idUser);
            ResultSet rsDistribuciones = pstmtDistribuciones.executeQuery();

            while (rsDistribuciones.next()) {
                int idDistribucion = rsDistribuciones.getInt("id_distribucion");
                String tipoAlgoritmo = rsDistribuciones.getString("tipo_algoritmo");

                pstmtDetalle.setInt(1, idDistribucion);
                pstmtDetalle.setString(2, idUser);
                ResultSet rsDetalle = pstmtDetalle.executeQuery();

                Map<Integer, Map<Integer, Integer>> matrizTemp = new HashMap<>();

                while (rsDetalle.next()) {
                    int fila = rsDetalle.getInt("fila");
                    int columna = rsDetalle.getInt("columna");
                    int idProducto = rsDetalle.getInt("id_producto");

                    matrizTemp.putIfAbsent(fila, new HashMap<>());
                    matrizTemp.get(fila).put(columna, idProducto);
                }

                int maxFila = matrizTemp.size();
                int maxColumna = 0;
                if (maxFila > 0) {
                    // Suponemos que todas las filas tienen el mismo número de columnas
                    maxColumna = matrizTemp.get(matrizTemp.keySet().iterator().next()).size();
                }
                int[][] matrizDistribucion = new int[maxFila][maxColumna];

                for (Map.Entry<Integer, Map<Integer, Integer>> entryFila : matrizTemp.entrySet()) {
                    int fila = entryFila.getKey();
                    for (Map.Entry<Integer, Integer> entryColumna : entryFila.getValue().entrySet()) {
                        int columna = entryColumna.getKey();
                        matrizDistribucion[fila][columna] = entryColumna.getValue();
                    }
                }

                resultados.put(idDistribucion, new Par<>(matrizDistribucion, tipoAlgoritmo));
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar distribuciones del usuario: " + e.getMessage());
        }

        return resultados;
    }

    public Map<Integer, Par<Integer, Long>> selectDistrosUser2(String idUser) {
        String sqlDistribuciones = "SELECT id_distribucion, puntuacion, steps FROM distribuciones WHERE id_usuario = ?";

        Map<Integer, Par<Integer, Long>> resultados = new HashMap<>();

        try (Connection conn = conectar();
             PreparedStatement pstmtDistribuciones = conn.prepareStatement(sqlDistribuciones)) {

            pstmtDistribuciones.setString(1, idUser);
            ResultSet rsDistribuciones = pstmtDistribuciones.executeQuery();

            while (rsDistribuciones.next()) {
                int idDistribucion = rsDistribuciones.getInt("id_distribucion");
                Integer puntuacion = rsDistribuciones.getInt("puntuacion");
                Long steps = rsDistribuciones.getLong("steps");

                // Agregar resultados al mapa
                resultados.put(idDistribucion, new Par<>(puntuacion, steps));
            }

        } catch (SQLException e) {
            System.err.println("Error al seleccionar distribuciones del usuario: " + e.getMessage());
        }

        return resultados;
    }


}
