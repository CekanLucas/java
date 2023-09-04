package pokemon;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class PokeDex extends Application {
  private static String filePath = "JavaFx/hellofx/src/main/java/pokemon/pokemon.txt";
  private static List<Pokemon> pokemonList = new ArrayList<>();

  static void readPokemonList() {
    try (BufferedReader data = new BufferedReader(new FileReader(filePath))) {
      String line;
      int idNumber = 1;
      while ((line = data.readLine()) != null) {
        System.out.print(line + "\t");
        pokemonList.add(new Pokemon(line, idNumber++));
      }
    } catch (Exception e) {
      System.err.println("An exception occurred:\n\t" + e.getMessage());
      e.printStackTrace();
    }
  }

  private void updateFile(String pokemon, String checkbox, boolean isChecked) {
    try {
      List<String> lines = new ArrayList<>();
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      String line;
      while ((line = reader.readLine()) != null) {
        lines.add(line);
      }
      reader.close();

      PrintWriter writer = new PrintWriter(filePath);
      for (String currLine : lines) {
        if (currLine.startsWith(pokemon)) {
          if (isChecked) {
            currLine += " " + checkbox;
          } else {
            currLine = currLine.replace(" " + checkbox, "");
          }
        }
        writer.println(currLine);
      }
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void start(Stage primaryStage) {
    readPokemonList();

    VBox pokeDexList = new VBox();

    for (Pokemon pokemon : pokemonList) {
      CheckBox goldCheckbox = new CheckBox();
      goldCheckbox.setStyle("-fx-body-color: gold;");
      goldCheckbox.setOnAction(event -> updateFile(pokemon.name, "G", goldCheckbox.isSelected()));
      if (pokemon.inGold)
        goldCheckbox.setSelected(true);
      CheckBox silverCheckbox = new CheckBox();
      silverCheckbox.setStyle("-fx-body-color: silver;");
      silverCheckbox.setOnAction(event -> updateFile(pokemon.name, "S", silverCheckbox.isSelected()));
      if (pokemon.inSilver)
        silverCheckbox.setSelected(true);
      CheckBox crystalCheckbox = new CheckBox();
      crystalCheckbox.setStyle("-fx-body-color: SkyBlue;");
      crystalCheckbox.setOnAction(event -> updateFile(pokemon.name, "C", crystalCheckbox.isSelected()));
      if (pokemon.inCrystal)
        crystalCheckbox.setSelected(true);

      Label pokemonLabel = new Label(pokemon.number + ".\t" + pokemon.name);
      pokemonLabel.setOnMouseClicked(event -> CycleLabelColors.cycle(pokemonLabel));
      HBox pokemonDisplay = new HBox();
      pokemonDisplay.getChildren().addAll(goldCheckbox, silverCheckbox, crystalCheckbox, pokemonLabel);

      if (goldCheckbox.isSelected() && silverCheckbox.isSelected() && crystalCheckbox.isSelected()) {
        pokemonDisplay.setManaged(false);
        pokemonDisplay.setVisible(false);
      }

      pokeDexList.getChildren().add(pokemonDisplay);
    }

    ScrollPane scrollPane = new ScrollPane(pokeDexList);
    Scene scene = new Scene(scrollPane, 300, 600);

    primaryStage.setTitle("PokeDex");
    primaryStage.setScene(scene);
    primaryStage.setAlwaysOnTop(true);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}

class Pokemon {
  String name;
  int number;

  boolean inGold = false;
  boolean inSilver = false;
  boolean inCrystal = false;

  Pokemon(String name, int number) {
    this.name = name;
    this.number = number;

    // Parse the checkboxes from the name
    String[] parts = name.split(" ");
    for (String part : parts) {
      if (part.equals("G"))
        this.inGold = true;
      else if (part.equals("S"))
        this.inSilver = true;
      else if (part.equals("C"))
        this.inCrystal = true;
      else
        this.name = part;
    }
  }
}

class CycleLabelColors {

  private CycleLabelColors() {
  }

  private static final Paint[] colors = {
      Paint.valueOf("black"),
      Paint.valueOf("DarkGoldenrod"),
      Paint.valueOf("silver"),
      Paint.valueOf("SkyBlue"),
      Paint.valueOf("red")
  };

  public static void cycle(Label label) {

    Paint currentPaint = label.getTextFill();
    for (int i = 0; i < colors.length; i++) {
      if (colors[i].equals(currentPaint)) {
        if (i == colors.length - 1) {
          label.setTextFill(colors[0]);
          label.setStyle("-fx-font-weight: normal;");
          return;
        } else {
          label.setTextFill(colors[i + 1]);
          label.setStyle("-fx-font-weight: bold;");
          return;
        }
      }
    }
    label.setTextFill(colors[0]);
  }
}