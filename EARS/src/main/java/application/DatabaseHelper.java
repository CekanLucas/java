package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    static Connection c = null;

    public static Connection getConnection() throws Exception {
        if (c == null) {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ears.db");
        }
        return c;
    }

    public static int setData(String sql) throws Exception {
        int row = DatabaseHelper.getConnection().createStatement().executeUpdate(sql);
//        System.out.println("===============\n"+sql+"\n====================");
        return row;
    }

    public static ResultSet getData(String sql) throws Exception {
        ResultSet executeQuery = DatabaseHelper.getConnection().createStatement().executeQuery(sql);
//        System.out.println("===============\n"+sql+"\n====================");
        return executeQuery;
    }

    // Initialize the SQLite database
    public static void initDatabase() {
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database (ears.db)
            c = DriverManager.getConnection("jdbc:sqlite:ears.db");

            // Create tables if they don't exist
            createTables();

            System.out.println("Database initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create tables if they don't exist
    private static void createTables() {
        try (Statement stmt = c.createStatement()) {
            // Create the profile table
            String createProfileTableSQL = "CREATE TABLE IF NOT EXISTS profile ("
                    + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name VARCHAR(255),"
                    + "email VARCHAR(255),"
                    + "password VARCHAR(255),"
                    + "title VARCHAR(255)"
                    + ")";
            stmt.executeUpdate(createProfileTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


