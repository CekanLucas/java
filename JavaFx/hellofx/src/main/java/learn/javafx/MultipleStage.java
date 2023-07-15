package learn.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MultipleStage extends Application {
  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(new Button("OK"), 200, 250);
    primaryStage.setTitle("MyJavaFX");
    primaryStage.setScene(scene);
    primaryStage.show();

    // Another stage
    Stage stage = new Stage();
    stage.setTitle("Second Stage");
    stage.setScene(new Scene(new Button("New Stage"), 200, 250));
    stage.setX(100); // set where window opens in
    stage.setY(100); // set where window opens in
    stage.setIconified(true); // will be minimized on start
    stage.show();

    // Shape Stage from Bro-code (youtube tutorial)
    Stage broStage = new Stage();
    broStage.setX(20);
    broStage.setY(20);
    broStage.setWidth(420);
    broStage.setHeight(420);
    broStage.setResizable(false);
    broStage.setTitle("Shape Stage - by Bro-code");
    broStage.setAlwaysOnTop(true);
    Image favicon = new Image("https://www.theodinproject.com/favicon-16x16.png");
    broStage.getIcons().add(favicon);

    Group group = new Group();
    Scene broScene = new Scene(group, 400, 400, Color.YELLOWGREEN);
    Text text = new Text();
    text.setText("Hello JavaFX!");
    text.setX(50);
    text.setY(50);
    text.setFont(Font.font("MathJax_Script", FontWeight.BOLD, FontPosture.ITALIC, 20));
    text.setFill(Color.TOMATO);
    
    Line line = new Line();
    line.setStartX(200);
    line.setStartY(200);
    line.setEndX(400);
    line.setEndY(200);
    line.setStrokeWidth(5);
    line.setStroke(Color.DARKORCHID);
    line.setOpacity(.3);
    line.setRotate(30);

    Rectangle rectangle = new Rectangle();
    group.getChildren().addAll(line, rectangle);
    rectangle.setX(100);
    rectangle.setY(100);
    rectangle.setWidth(100);
    rectangle.setHeight(50);
    rectangle.setStroke(Color.STEELBLUE);
    rectangle.setStrokeWidth(3);

    Polygon triangle = new Polygon(
      325.0, 300.0,
      350.0, 250.0,
      300.0, 250.0
    );
    group.getChildren().add(triangle);
    triangle.setStroke(Color.CORAL);
    triangle.setStrokeLineJoin(StrokeLineJoin.BEVEL);
    triangle.setFill(Color.color(0.2, 0.2, 0.6, 0.5));

    Circle circle = new Circle(200, 350, 50, Color.ORANGERED);
    
    Image imageElectric = new Image("https://pngimg.com/uploads/red_star/red_star_PNG44.png");
    ImageView broImage = new ImageView(imageElectric);
    broImage.setFitWidth(100);
    broImage.setFitHeight(100);
    broImage.setX(10);
    broImage.setY(100);

    System.out.println(Font.getFamilies().toString());
    group.getChildren().addAll(text, circle, broImage);
    broStage.setScene(broScene);
    broStage.show();

    // fx Style stage
    StackPane pane = new StackPane();
    Button btOk = new Button("OK");
    btOk.setStyle("-fx-border-color:blue;");
    pane.getChildren().add(btOk);

    pane.setRotate(45);
    pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");

    scene = new Scene(pane, 200, 250);
    primaryStage.setTitle("Node Style Rotate Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}