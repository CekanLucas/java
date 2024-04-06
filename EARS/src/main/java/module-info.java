module GroupEARS06_D5_Implementation {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	exports application.controller to javafx.fxml;
	opens application.controller to javafx.fxml;
}
