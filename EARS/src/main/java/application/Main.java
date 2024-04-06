package application;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    // The URL of the SQLite database
    private static final String URL = "jdbc:sqlite:ears.db";

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Main.fxml"));
            Parent root = loader.load();

            // Check if the root element is an HBox
            if (!(root instanceof HBox)) {
                throw new IllegalStateException("Root element in FXML file is not an HBox");
            }

            HBox hbox = (HBox) root;

            // Create a scene with the loaded root
            Scene scene = new Scene(hbox, 573.0, 385.0);

            // Add CSS stylesheet
            scene.getStylesheets().add("/css/application.css");

            // Set the scene and show the stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("EARS");
            primaryStage.show();

            // Connect to the SQLite database and display data
            displayData();

        } catch (Exception e) {
            System.err.println("Error in Main: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Displays the data from the SQLite database.
     * This method is responsible for connecting to the database, executing the query, and printing the results.
     * It also handles any SQLException that may occur.
     */
    private void displayData() {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM profile")) {

            // Iterate through the query results and print the values
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving data from database");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}