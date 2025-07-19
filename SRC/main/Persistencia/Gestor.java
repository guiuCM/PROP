package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Gestor {

    /**
     * The database URL for the SQLite database.
     */
    private static final String DB_URL = "jdbc:sqlite:db/DataBase.db"; // MIRAR SI ES PRIVATE OR PROTECTED

    /**
     * Establishes a connection to the SQLite database.
     *
     * @return a {@link Connection} object to the database
     * @throws SQLException if a database access error occurs
     */
    protected Connection conectar() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public abstract void inicializarBaseDeDatos();

    public abstract void borrarBaseDeDatos();


}
