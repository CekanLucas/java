package learn;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLight extends Application {
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Traffic Light");
    primaryStage.setAlwaysOnTop(true);

    Circle circleRed = new Circle(50, 50, 50, Color.BLACK);
    Circle circleYellow = new Circle(100, 50, 50, Color.BLACK);
    Circle circleGreen = new Circle(150, 50, 50, Color.BLACK);
    HBox hbox = new HBox(circleRed, circleYellow, circleGreen);
    hbox.setSpacing(10);
    hbox.setPadding(new Insets(10, 10, 10, 10));

    RadioButton red = new RadioButton("Red");
    RadioButton yellow = new RadioButton("Yellow");
    RadioButton green = new RadioButton("Green");
    ToggleGroup toggle = new ToggleGroup();
    red.setToggleGroup(toggle);
    yellow.setToggleGroup(toggle);
    green.setToggleGroup(toggle);

    red.setOnAction(e -> {
      if (red.isSelected()) {
        circleRed.setFill(Color.RED);
        circleYellow.setFill(Color.BLACK);
        circleGreen.setFill(Color.BLACK);
      }
    });

    yellow.setOnAction(e -> {
      if (yellow.isSelected()) {
        circleRed.setFill(Color.BLACK);
        circleYellow.setFill(Color.YELLOW);
        circleGreen.setFill(Color.BLACK);
      }
    });

    green.setOnAction(e -> {
      if (green.isSelected()) {
        circleRed.setFill(Color.BLACK);
        circleYellow.setFill(Color.BLACK);
        circleGreen.setFill(Color.GREEN);
      }
    });

    GridPane pane = new GridPane();
    pane.add(hbox, 0, 0);
    pane.add(new HBox(10, red, yellow, green), 0, 1);

    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
