package Persistencia;

import domain.RolUsuario;
import java.sql.*;

public class GestorUsuarios extends Gestor {

    @Override
    public void inicializarBaseDeDatos() {
        String sqlCrearTablaUsuarios = """
            CREATE TABLE IF NOT EXISTS tablaUsuarios (
                name TEXT,
                password TEXT,
                mail TEXT,
                rol TEXT,
                PRIMARY KEY (name)
            );
        """;

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCrearTablaUsuarios);
            System.out.println("Tabla Usuarios inicializada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void borrarBaseDeDatos() {
        String sqlBorrarTablaUsuarios = "DROP TABLE IF EXISTS tablaUsuarios";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlBorrarTablaUsuarios);
            System.out.println("Tabla Usuarios eliminada correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al borrar la tabla Usuarios: " + e.getMessage());
        }
    }


    public void insertTablaUsuarios(String name, String password, String correo, String rol) {
        if (rol == null) rol = "ESTANDAR"; // Por defecto, si no se da rol

        String sqlInsertarUsuario = "INSERT INTO tablaUsuarios (name, password, mail, rol) VALUES (?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmtUsuarios = conn.prepareStatement(sqlInsertarUsuario)) {

            pstmtUsuarios.setString(1, name);
            pstmtUsuarios.setString(2, password);
            pstmtUsuarios.setString(3, correo);
            pstmtUsuarios.setString(4, rol);
            pstmtUsuarios.executeUpdate();

            System.out.println("Usuario agregado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar el Usuario: " + e.getMessage());
        }
    }

    public void deleteTablaUsuarios(String name) {
        String sqleliminarUsuario = "DELETE FROM tablaUsuarios WHERE name = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmtUsuarios = conn.prepareStatement(sqleliminarUsuario)) {

            pstmtUsuarios.setString(1, name);
            int filas = pstmtUsuarios.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario a eliminar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el Usuario: " + e.getMessage());
        }
    }

    public boolean selectTablaUsuarios(String name, String password) {
        String sql = "SELECT * FROM tablaUsuarios WHERE name = ? AND password = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmtUsuarios = conn.prepareStatement(sql)) {

            pstmtUsuarios.setString(1, name);
            pstmtUsuarios.setString(2, password);

            try (ResultSet rs = pstmtUsuarios.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Usuario encontrado: " + rs.getString("name"));
                    return true;
                } else {
                    System.out.println("Usuario o contraseña incorrectos.");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la tabla de usuarios: " + e.getMessage());
            return false;
        }
    }

    public boolean modificarContraseña(String name, String oldpass, String newpass, String newpass2) {
        String sqlSelect = "SELECT * FROM tablaUsuarios WHERE name = ? AND password = ?";
        String sqlUpdate = "UPDATE tablaUsuarios SET password = ? WHERE name = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect)) {

            pstmtSelect.setString(1, name);
            pstmtSelect.setString(2, oldpass);

            try (ResultSet rs = pstmtSelect.executeQuery()) {
                if (rs.next()) {
                    try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
                        pstmtUpdate.setString(1, newpass);
                        pstmtUpdate.setString(2, name);
                        int filas = pstmtUpdate.executeUpdate();
                        if (filas > 0) {
                            System.out.println("Contraseña modificada correctamente.");
                            return true;
                        } else {
                            System.out.println("No se pudo modificar la contraseña.");
                            return false;
                        }
                    }
                } else {
                    System.out.println("Usuario o contraseña incorrectos.");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar la contraseña: " + e.getMessage());
            return false;
        }
    }


    public void modificarRol(String name, String newrol) {
        String sqlUpdateRol = "UPDATE tablaUsuarios SET rol = ? WHERE name = ?";
        try (Connection conn = conectar();
             PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdateRol)) {

            pstmtUpdate.setString(1, newrol);
            pstmtUpdate.setString(2, name);
            int filas = pstmtUpdate.executeUpdate();
            if (filas > 0) {
                System.out.println("Rol actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el rol (usuario no encontrado).");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el rol: " + e.getMessage());
        }
    }

    public boolean existeUsuario(String name) {
        String sql = "SELECT * FROM tablaUsuarios WHERE name = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmtUsuarios = conn.prepareStatement(sql)) {

            pstmtUsuarios.setString(1, name);

            try (ResultSet rs = pstmtUsuarios.executeQuery()) {
                return rs.next(); // Si hay al menos un resultado, existe
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la existencia del usuario: " + e.getMessage());
            return false;
        }
    }

    public RolUsuario selectRolUser(String name) {
        String sql = "SELECT rol FROM tablaUsuarios WHERE name = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmtUsuarios = conn.prepareStatement(sql)) {

            pstmtUsuarios.setString(1, name);

            try (ResultSet rs = pstmtUsuarios.executeQuery()) {
                if (rs.next()) {
                    return RolUsuario.valueOf(rs.getString("rol"));
                } else {
                    System.out.println("El usuario no existe o no tiene rol.");
                    return null;
                }
            } catch (Exception e) {
                System.err.println("Error al consultar el rol: " + e.getMessage());
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la tabla de usuarios: " + e.getMessage());
            return null;
        }
    }

    public String selectContra(String name, String email) {
        String sql = "SELECT password,mail FROM tablaUsuarios WHERE name = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmtUsuarios = conn.prepareStatement(sql)) {

            pstmtUsuarios.setString(1, name);

            try (ResultSet rs = pstmtUsuarios.executeQuery()) {
                if (rs.next()) {
                    if (String.valueOf(rs.getString("mail")).equals(email))
                        return String.valueOf(rs.getString("password"));
                    else{
                        System.out.println("El correo es erroneo.");
                        return null;
                    }
                } else {
                    System.out.println("El usuario no existe.");
                    return null;
                }
            } catch (Exception e) {
                System.err.println("Error al consultar el password: " + e.getMessage());
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la tabla de usuarios: " + e.getMessage());
            return null;
        }
    }
}
