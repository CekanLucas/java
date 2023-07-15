package learn.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class ButtonInPane extends Application {
  @Override
  public void start(Stage primaryStage) {
    Button btOk = new Button("OK");
    Scene scene = new Scene(btOk, 200, 250);

    primaryStage.setTitle("My Java Project");
    primaryStage.setScene(scene);

    StackPane pane = new StackPane();
    pane.getChildren().add(new Button("OK"));    
    primaryStage.setTitle("Button in a pane");
    primaryStage.setScene(scene);

    primaryStage.setResizable(false);
    primaryStage.show();

    // Another stage
    Stage stage = new Stage();
    stage.setTitle("Second Stage");
    stage.setScene(new Scene(new Button("New Stage"), 200, 250));        
    stage.show();
  }
  public static void main(String[] args) {
    Application.launch(args);
  }
}