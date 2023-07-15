package learn.javafx.Lab8;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Write a program that creates a GUI that contains a
 * label(“Enter the data”), a text area and button ✅
 * 
 * The user types in the text area lines each containing the first name of a
 * student
 * and an integer representing the grade ✅
 * 
 * When the user clicks the button,
 * 
 * the program should first create a binary file called file2.dat ✅
 * 
 * It should then get the number of lines of data in text area
 * and save it into the binary file as an integer (for example 3 for 3 lines)
 * 
 * then it should save the text data from text area into the binary file as UTF
 * strings and as integers until you reach the end of the number of students
 * 
 * Calculate the average (a double) of the grades and save it to the end of the
 * binary file.
 * 
 * Hint: Use object of type DataOutputStream for Question #2. ✅
 * 
 * Your program does not need to read the binary file. My program should be able
 * to read any binary file your program creates and the average at the end of
 * your binary file should be correct.
 */
public class AverageGradeData extends Application {
  static String file = "file2.dat";

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Average Student Grades from Binary File");
    primaryStage.setIconified(false);
    primaryStage.setAlwaysOnTop(true);
    primaryStage.setX(100);
    primaryStage.setY(100);

    Label label = new Label("Enter the Data");
    TextArea textArea = new TextArea();
    Button button = new Button("Save");

    button.setOnAction(e -> write(handleText(textArea.getText())));

    VBox pane = new VBox();
    pane.setSpacing(10);

    pane.getChildren().addAll(label, textArea, button);

    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  void write(String result) {
    try {
      DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
        System.out.println(result);
        String[] lines = result.split("\n");
        output.writeInt(lines.length - 1); // [Average: double] is a line so need to minus it
        System.out.println("number of lines (number of students) " + (lines.length -1));
        for (String line : lines) {
          line = line.trim();
          String[] dataPair = line.split("\s");
          if ("Average:".equals(dataPair[0])) {
            String string = dataPair[0];
            output.writeUTF(string);
            String average = dataPair[1];
            output.writeDouble(Double.parseDouble(average));
          } else {
            String name = dataPair[0];
            output.writeUTF(name);
            String grade = dataPair[1];
            output.writeInt(Integer.parseInt(grade));
          }
        }
        output.close();
      
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      System.out.println("End of Binary IO Operations");
    }
  }

  String handleText(String text) {

    String[] lines = text.split("\n");
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> grades = new ArrayList<>();

    for (String line : lines) {
      String lineTrimmed = line.trim();
      String[] lineArr = lineTrimmed.split("\s");
      names.add(lineArr[0]);
      grades.add(Integer.parseInt(lineArr[1]));
    }

    int sum = 0;
    for (Integer integer : grades) {
      sum = integer + sum;
    }
    double average = (double) sum / lines.length;

    return text + "\nAverage: " + average;
  }
}

/*
 * EXMAPLE INPUT
 * 
 Amy 80
 Brian 70
 Alan 100
 * 
 */