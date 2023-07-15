package learn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TemperatureConversion extends Application {
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Select Shape");
    primaryStage.setAlwaysOnTop(true);

    Label celsiusLabel = new Label("Celsius");
    Label fahrenheitLabel = new Label("Fahrenheit");
    TextField celsius = new TextField();
    TextField fahrenheit = new TextField();
    GridPane pane = new GridPane();
    pane.add(celsiusLabel, 0, 0);
    pane.add(celsius, 1, 0);
    pane.add(fahrenheitLabel, 0, 1);
    pane.add(fahrenheit, 1, 1);

    celsius.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.ENTER) {
        fahrenheit.setText("" + celsiusToFahrenheit(Integer.parseInt(celsius.getText())));
      }
    });
    fahrenheit.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.ENTER) {
        celsius.setText("" + fahrenheitToCelsius(Integer.parseInt(fahrenheit.getText())));
      }
    });

    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  double celsiusToFahrenheit(double celsius) {
    return (celsius * (9.0 / 5) + 32);
  }

  double fahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit + 32) * (5 / 9.0);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
