package application.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {

    @FXML
    private TextField email_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button login_button;
    
    private Stage stage;

    @FXML
    void handleLoginButtonAction(ActionEvent event) {
        String email = email_field.getText();
        String password = password_field.getText();

        try {
            // Here you should perform the authentication logic
            boolean authenticated = authenticate(email, password);

            if (authenticated) {
                // Login successful, switch to the main page
                switchToMain(login_button.getScene().getWindow());
            } else {
                // Show error message for invalid credentials
                showErrorAlert("Invalid email or password");
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during authentication
            e.printStackTrace();
            showErrorAlert("An error occurred during login");
        }
    }

    private boolean authenticate(String email, String password) {
        try {
        	// Provide the path to your SQLite database file
            String dbFilePath = "ears.db";
            
            // Construct the connection URL for SQLite
            String URL = "jdbc:sqlite:" + dbFilePath;
            
            // Establish connection to the SQLite database
            Connection connection = DriverManager.getConnection(URL);
            
            // Prepare SQL statement to retrieve user with matching email and password
            String query = "SELECT * FROM profile WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            
            // Execute the query
            ResultSet resultSet = statement.executeQuery();
            
            // Check if the result set contains any rows
            if (resultSet.next()) {
                // User with matching email and password found
                resultSet.close();
                statement.close();
                connection.close();
                return true;
            } else {
                // No matching user found
                resultSet.close();
                statement.close();
                connection.close();
                return false;
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions that occur during authentication
            e.printStackTrace();
            return false;
        }
    }


    private void switchToMain(Window window) {
        // Load the main page and switch to it
        try {
            Stage stage = (Stage) window;
            stage.close(); // Close the login window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Main.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main Page");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showErrorAlert(String message) {
        // Show an error alert with the given message
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void loginSuccessful() {
        try {
            // Load the main application scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Main.fxml"));
            Parent mainRoot = loader.load();
    
            Scene scene = new Scene(mainRoot);
            stage.setScene(scene); // 'stage' should be your current Stage, passed from Main
            stage.setTitle("EARS");
            stage.show();
        } catch (Exception e) {
            System.err.println("Error loading Main.fxml after login: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
