package application.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DepartmentController {

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
			e.printStackTrace();
		}
	}

	// Method to handle button click for adding a member
	@FXML
	private void handleAddMemberButtonClick() {
		try {
			// Load the FXML file for the Add Members page
			Parent AddMemberButtonRoot = FXMLLoader.load(getClass().getResource("/application/view/dashboard.fxml"));

			// Create a new scene with the Add Members root
			Scene AddMemberButtonScene = new Scene(AddMemberButtonRoot);

			Stage stage = (Stage) searchBar.getScene().getWindow();
			
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
	private void handleScheduleButtonClick(Stage stage) {
		try {
			// Load the FXML file for the Add Members page
			Parent ScheduleButtonRoot = FXMLLoader.load(getClass().getResource("/application/view/Schedule.fxml"));

			// Create a new scene with the Add Members root
			Scene ScheduleButtonScene = new Scene(ScheduleButtonRoot);

			// Set the scene on the stage
			stage.setScene(ScheduleButtonScene);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Implement action for schedule button click
		System.out.println("Schedule button clicked");
		// You can add more functionality here
	}

	// Method to handle button click for faculty members
	@FXML
	private void handleFacultyMembersButtonClick(Stage stage) {
		try {
			// Load the FXML file for the Add Members page
			Parent FaultyMemberButtonRoot = FXMLLoader.load(getClass().getResource("/application/view/FaultyMember.fxml"));

			// Create a new scene with the Add Members root
			Scene FaultyMemberButtonScene = new Scene(FaultyMemberButtonRoot);

			// Set the scene on the stage
			stage.setScene(FaultyMemberButtonScene);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Implement action for faculty members button click
		System.out.println("Faculty Members button clicked");
		// You can add more functionality here
	}

	// Method to handle button click for departments
	@FXML
	private void handleDepartmentButtonClick(Stage stage) {
		try {
			// Load the FXML file for the Add Members page
			Parent DepartmentButtonRoot = FXMLLoader.load(getClass().getResource("/application/view/Department.fxml"));

			// Create a new scene with the Add Members root
			Scene DepartmentButtonScene = new Scene(DepartmentButtonRoot);

			// Set the scene on the stage
			stage.setScene(DepartmentButtonScene);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Implement action for department button click
		System.out.println("Department button clicked");
		// You can add more functionality here
	}
}
