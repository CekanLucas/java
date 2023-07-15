package learn.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;

public class Sample extends Application {
  @Override
  public void start(Stage primaryStage) {
    Button btOk = new Button("OK");
    Scene scene = new Scene(btOk, 200, 250);

    primaryStage.setTitle("My Java Project");
    primaryStage.setScene(scene);
    Circle circle = new Circle();
    circle.setCenterX(100);
    circle.setCenterY(100);
    circle.setRadius(50);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);

    Pane pane = new Pane();
    pane.getChildren().add(circle);

    primaryStage.setResizable(false);
    primaryStage.show();

    // Another stage
    Stage stage = new Stage();
    stage.setTitle("Second Stage");
    stage.setScene(new Scene(new Button("New Stage"), 200, 250));        
    stage.show();
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support
   * Not needed for running from the command line
   */
  public static void main(String[] args) {
    Application.launch(args);
  }
}