package ma.youcode.sbahia.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private Connection connection = null;
    private final String DB_DRIVER = "org.postgresql.Driver";
    private final String DB_USER = "postgres";
    private final String DB_PASS = "admin";
    private final String Db_URL = "jdbc:postgresql://localhost:5432/sbahia";

    /**
     * constructor
     */
    public Database() {
        super();
    }

    /**
     * @return connection to database
     */
    public Connection makeConnection() {

        try {
            Class.forName(DB_DRIVER);	
            connection = DriverManager.getConnection(Db_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
