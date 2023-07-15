package labs.lab7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Once the user selects a lunch item, a drink and clicks the "Submit" button,
 * 
 * the total will be displayed in the text area.
 * 
 * You may make up whatever prices you wish for each food and drink item, just
 * make sure the prices are unique to each item.
 * 
 * Feel free to create and use lunch price and drink price as static double
 * members if it helps you build the program!
 */

public class LunchMenu extends Application {
  static int total = 0;
  static String drinkSelected = "";
  static String menuItemSelected = "";

  private String[] itemsInMenu = { "Hot Dog", "Sandwich", "Hamburger" };
  private ComboBox<String> cbo = new ComboBox<>();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Lunch Menu");

    BorderPane pane = new BorderPane();

    // combo box
    BorderPane paneForComboBox = new BorderPane();
    paneForComboBox.setLeft(new Label("Select an Item"));
    paneForComboBox.setCenter(cbo);
    pane.setTop(paneForComboBox);
    cbo.setPrefWidth(400);

    ObservableList<String> items = FXCollections.observableArrayList(itemsInMenu);
    cbo.getItems().addAll(items);

    // drinks radio buttons
    VBox paneForDrinks = new VBox(20);
    Label labelDrinks = new Label("Drink");
    labelDrinks.setContentDisplay(ContentDisplay.BOTTOM);

    paneForDrinks.setPadding(new Insets(5, 5, 5, 5));
    RadioButton coffee = new RadioButton("Coffee");
    RadioButton tea = new RadioButton("Tea");
    RadioButton pop = new RadioButton("Pop");
    paneForDrinks.getChildren().addAll(labelDrinks, coffee, tea, pop);
    pane.setLeft(paneForDrinks);

    coffee.setOnAction(e -> {
      if (coffee.isSelected())
        drinkSelected = "Coffee";
    });
    tea.setOnAction(e -> {
      if (tea.isSelected())
        drinkSelected = "Tea";
    });
    pop.setOnAction(e -> {
      if (pop.isSelected())
        drinkSelected = "Pop";
    });

    ToggleGroup drinks = new ToggleGroup();
    coffee.setToggleGroup(drinks);
    tea.setToggleGroup(drinks);
    pop.setToggleGroup(drinks);

    // Bottom Submit Button
    HBox panelSubmit = new HBox(20);
    Button submitButton = new Button("Submit");
    submitButton.setAlignment(Pos.CENTER);
    panelSubmit.setAlignment(Pos.CENTER);
    HBox.setMargin(submitButton, new Insets(20, 0, 20, 0));
    panelSubmit.getChildren().add(submitButton);
    pane.setBottom(panelSubmit);

    // Center TextField of Price
    TextArea textArea = new TextArea("Select your Order");
    textArea.setFont(new Font("Ubuntu", 16));

    pane.setCenter(textArea);

    Scene scene = new Scene(pane, 300, 400);
    primaryStage.setScene(scene);
    primaryStage.show();

    // handle submit
    submitButton.setOnAction(e -> textArea.setText(String.format("Total is $%.2f",
        getPrice(cbo.getValue() == null ? "" : cbo.getValue()) +
            getPrice(drinkSelected == null ? "" : drinkSelected))

    ));
  }

  public static void main(String[] args) {
    launch(args);
  }

  private double getPrice(String item) {
    // prices
    final double HOTDOG = 1.0;
    final double SANDWICH = 2.5;
    final double HAMBURGER = 3.0;
    final double COFFEE = 0.25;
    final double TEA = 0.2;
    final double POP = 0.1;
    switch (item) {
      case "Hot Dog":
        return HOTDOG;
      case "Sandwich":
        return SANDWICH;
      case "Hamburger":
        return HAMBURGER;
      case "Pop":
        return POP;
      case "Tea":
        return TEA;
      case "Coffee":
        return COFFEE;
      default:
        return 0.0;
    }
  }

}