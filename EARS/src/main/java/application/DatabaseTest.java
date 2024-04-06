package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {

  public static void main(String[] args) throws Exception {
    // Initialize the database
    DatabaseHelper.initDatabase();

    // Test saving a profile
    saveProfileTest();

    // Test retrieving all profiles
    retrieveAllProfilesTest();
  }

  // Test saving a profile to the database
  private static void saveProfileTest() throws Exception {
    Connection connection = null;
    try {
      connection = DatabaseHelper.getConnection();
      Statement statement = connection.createStatement();
      String sql = "INSERT INTO profile (name, email, title) VALUES ('John Doe', 'john@example.com', 'Software Engineer')";
      statement.executeUpdate(sql);
      System.out.println("Profile saved successfully.");
    } catch (SQLException e) {
      System.err.println("Error saving profile: " + e.getMessage());
    } finally {
      // DON'T CLOSE CONNECTION YET
      // try {
      //   if (connection != null) {
      //     connection.close();
      //   }
      // } catch (SQLException e) {
      //   System.err.println("Error closing connection: " + e.getMessage());
      // }
    }
  }

  // Test retrieving all profiles from the database
  private static void retrieveAllProfilesTest() throws Exception {
    Connection connection = null;
    try {
      connection = DatabaseHelper.getConnection();
      if (connection == null) {
        throw new SQLException("Failed to establish a database connection.");
      }

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM profile");
      System.out.println("Retrieving all profiles:");
      while (resultSet.next()) {
        System.out.println("ID: " + resultSet.getInt("ID"));
        System.out.println("Name: " + resultSet.getString("name"));
        System.out.println("Email: " + resultSet.getString("email"));
        System.out.println("Title: " + resultSet.getString("title"));
        System.out.println();
      }
    } catch (SQLException e) {
      System.err.println("Error retrieving profiles: " + e.getMessage());
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        System.err.println("Error closing connection: " + e.getMessage());
      }
    }
  }
}
