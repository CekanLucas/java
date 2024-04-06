package application.controller;

import java.io.IOException;

// import org.w3c.dom.Node;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


public class MainController {

    @FXML
    private TextField searchBar;

    @FXML
    private Label pageLabel;

    @FXML
    private Label positionCountLabel;

    @FXML
    private Label jobOpenCountLabel;

    @FXML
    private Label employeeCountLabel;

    @FXML
    private Label talentRequestCountLabel;

    @FXML
    private void initialize() {
        // Initialize any default values or bindings here
        searchBar.setOnAction(event -> search());
    }

    private void search() {
        // Implement search functionality here
        String searchText = searchBar.getText();
        // Perform search operation based on searchText
        System.out.println("Searching for: " + searchText);
    }

    // Method to handle button click for dashboard
    // Method to handle button click for dashboard
    @FXML
    private void handleDashboardButtonClick() {
        System.out.println("Dashboard button clicked");
        // Get the stage from the button
        Stage stage = (Stage) searchBar.getScene().getWindow();
        switchToDashboard(stage);
    }

    private void switchToDashboard(Stage stage) {
        try {
            // Load the FXML file for the dashboard page
            Parent dashboardRoot = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));

            // Create a new scene with the dashboard root
            Scene dashboardScene = new Scene(dashboardRoot);

            // Set the scene on the stage
            stage.setScene(dashboardScene);

        } catch (IOException e) {
            System.err.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to handle button click for adding a member
    @FXML
    private void handleAddMemberButtonClick(ActionEvent event) {
        try {
            // Load the FXML file for the Add Members page
            Parent AddMemberButtonRoot = FXMLLoader.load(getClass().getResource("/application/view/dashboard.fxml"));

            // Create a new scene with the Add Members root
            Scene AddMemberButtonScene = new Scene(AddMemberButtonRoot);

            // Get the stage from the event
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the scene on the stage
            stage.setScene(AddMemberButtonScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Implement action for add member button click
        System.out.println("Add Member button clicked");
        // You can add more functionality here
    }

    // Method to handle button click for schedule
    @FXML
    private void handleScheduleButtonClick() {
        // Implement action for schedule button click
        System.out.println("Schedule button clicked");
        // You can add more functionality here
    }

    // Method to handle button click for faculty members
    @FXML
    private void handleFacultyMembersButtonClick() {
        // Implement action for faculty members button click
        System.out.println("Faculty Members button clicked");
        // You can add more functionality here
    }

    // Method to handle button click for departments
    @FXML
    private void handleDepartmentButtonClick() {
        // Implement action for department button click
        System.out.println("Department button clicked");
        // You can add more functionality here
    }

}
