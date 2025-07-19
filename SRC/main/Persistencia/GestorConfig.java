package Persistencia;

import java.sql.*;

public class GestorConfig extends Gestor{

    @Override
    public void inicializarBaseDeDatos() {
        String sqlCrearTablaConfig = """
            CREATE TABLE IF NOT EXISTS tablaConfig (
                name TEXT,
                value INT,
                PRIMARY KEY (name)
            );
        """;

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCrearTablaConfig);

            System.out.println("Tabla Config inicializada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void borrarBaseDeDatos() {
        String sqlBorrarTablaConfig = "DROP TABLE IF EXISTS tablaConfig";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlBorrarTablaConfig);

            System.out.println("Base de datos borrada correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al borrar la base de datos: " + e.getMessage());
        }
    }


    public void insertTablaConfig(String name, int value) {
        String sqlInsertarConfig = "INSERT OR IGNORE INTO tablaConfig (name, value) VALUES (?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmtConfig = conn.prepareStatement(sqlInsertarConfig)) {

            pstmtConfig.setString(1, name);
            pstmtConfig.setInt(2, value);

            pstmtConfig.executeUpdate();

            System.out.println("Config agregada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar Config: " + e.getMessage());
        }
    }

    public void modificarConfigValue(String name, int value) {
        String sqlInsertarConfig = "UPDATE tablaConfig SET value = ? WHERE name = ?";

        try (Connection conn = conectar();
            PreparedStatement pstmtConfig = conn.prepareStatement(sqlInsertarConfig)) {
            pstmtConfig.setInt(1, value);
            pstmtConfig.setString(2, name);

            pstmtConfig.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Error al agregar Config: " + e.getMessage());
        }
    }

    public int selectConfig(String name) {
        String sqlInsertarConfig = "SELECT value FROM tablaConfig WHERE name = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmtConfig = conn.prepareStatement(sqlInsertarConfig)) {

            pstmtConfig.setString(1, name);

            try (ResultSet rs = pstmtConfig.executeQuery()) {
                System.out.println("Config seleccionada correctamente.");
                return rs.getInt("value");
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar Config: " + e.getMessage());
            return 0;
        }
    }
}
