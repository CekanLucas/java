package assignment4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class OutsideShapes extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Select Shape");
        primaryStage.setAlwaysOnTop(true);

        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);
        StackPane circlePane = new StackPane(circle);

        Tooltip tooltip = new Tooltip();
        circle.setOnMouseMoved(event -> {
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            boolean isInsideShape = circle.contains(mouseX, mouseY);

            tooltip.setText("Mouse point is " + (isInsideShape ? "" : "not") + " inside the circle");
            tooltip.show(circle, mouseX + 10, mouseY + 10);

            System.out.println("Mouse Coordinates (Scene): X=" + mouseX + ", Y=" + mouseY + isInsideShape);
        });
        circle.setOnMouseExited(event -> tooltip.hide());

        Scene scene = new Scene(circlePane, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
