package assignment4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Calculator");
    primaryStage.setAlwaysOnTop(true);

    Label number1Label = new Label("Number 1: ");
    TextField number1 = new TextField();
    Label number2Label = new Label("Number 2: ");
    TextField number2 = new TextField();
    Label resultLabel = new Label("Result: ");
    TextField result = new TextField();
    HBox calculatorTextFields = new HBox(10, number1Label, number1, number2Label, number2, resultLabel, result);

    Button addButton = new Button("Add");
    addButton.setOnAction(e -> {
      double num1 = 
        Double.parseDouble("".equals(number1.getText()) ? "0" : number1.getText());
      double num2 = 
        Double.parseDouble("".equals(number2.getText()) ? "0" : number2.getText());
      result.setText(String.format("%f", num1 + num2));
    });
    Button subtractButton = new Button("Subtract");
    subtractButton.setOnAction(e -> {
      double num1 = 
        Double.parseDouble("".equals(number1.getText()) ? "0" : number1.getText());
      double num2 = 
        Double.parseDouble("".equals(number2.getText()) ? "0" : number2.getText());
      result.setText(String.format("%f", num1 - num2));
    });
    Button multipleButton = new Button("Multiply");
    multipleButton.setOnAction(e -> {
      double num1 = 
        Double.parseDouble("".equals(number1.getText()) ? "0" : number1.getText());
      double num2 = 
        Double.parseDouble("".equals(number2.getText()) ? "0" : number2.getText());
      result.setText(String.format("%f", num1 * num2));
    });
    Button divideButton = new Button("Divide");
    divideButton.setOnAction(e -> {
      double num1 = 
        Double.parseDouble("".equals(number1.getText()) ? "0" : number1.getText());
      double num2 = 
        Double.parseDouble("".equals(number2.getText()) ? "0" : number2.getText());
      result.setText(String.format("%f", num1 / num2));
    });

    HBox calculatorButtons = new HBox(10, addButton, subtractButton, multipleButton, divideButton);
    calculatorButtons.setAlignment(Pos.CENTER);

    VBox pane = new VBox(10, calculatorTextFields, calculatorButtons);

    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.show();

    // new Stage for Investment calculator
    Stage investmentCalculator = new Stage();
    investmentCalculator.setTitle("Investment Calculator");
    investmentCalculator.setAlwaysOnTop(true);
    investmentCalculator.setX(10);
    investmentCalculator.setY(10);

    Label investmentAmountLabel = new Label("Investment Amount");
    TextField investmentAmount = new TextField();

    Label numberOfYearsLabel = new Label("Number of Years");
    TextField numberOfYears = new TextField();

    Label annualInterestRateLabel = new Label("Annual Interest Rate");
    TextField annualInterestRate = new TextField();

    Label futureValueLabel = new Label("Future Value");
    TextField futureValue = new TextField();

    Button calculate = new Button("Calculate");


    GridPane grid = new GridPane();
    grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    grid.setHgap(10);
    grid.setVgap(10);

    grid.add(investmentAmountLabel, 0, 0);
    grid.add(investmentAmount, 1, 0);
    grid.add(numberOfYearsLabel, 0, 1);
    grid.add(numberOfYears, 1, 1);
    grid.add(annualInterestRateLabel, 0, 2);
    grid.add(annualInterestRate, 1, 2);
    grid.add(futureValueLabel, 0, 3);
    grid.add(futureValue, 1, 3);
    grid.add(calculate, 1, 4);
    Scene investmentScene = new Scene(grid);

    calculate.setOnAction( e -> {
      double investmentAmountValue = 
        Double.parseDouble(
          "".equals(investmentAmount.getText()) ? "0" : investmentAmount.getText()
        );

        double numberOfYearsValue = 
        Double.parseDouble(
          "".equals(numberOfYears.getText()) ? "0" : numberOfYears.getText()
        );

        double annualInterestRateValue = 
        Double.parseDouble(
          "".equals(annualInterestRate.getText()) ? "0" : annualInterestRate.getText()
        );
      
      futureValue.setText(String.format("$%.2f", 
        investmentAmountValue * Math.pow((annualInterestRateValue / 100) + 1, numberOfYearsValue)
      ));

    });

    investmentCalculator.setScene(investmentScene);
    investmentCalculator.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
