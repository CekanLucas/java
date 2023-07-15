package learn.javafx;

// defines the essential framework for writing JavaFX programs
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BoilerPlate extends Application {
  @Override // Overrides start of Application
  /* The start method normally places UI controls in a scene and displays the scene in stage */
  public void start(Stage primaryStage) {

    Button btOK = new Button("OK");
    Scene scene = new Scene(btOK, 200, 250);
    
    primaryStage.setTitle("MyJavaFX");
    primaryStage.setScene(scene); // place the scene in the stage
    primaryStage.show();
  }
  /**
   * The main method is only needed for the IDE with limited JavaFX support
   * Not needed for running from the command line
   * 
   * {@systemProperty Application.launch} 
   * this is a static method for a launching a stand-alone JavaFX application
   * When you run a JavaFX application without a main method, JVM automatically invokes the launch method to run the application
   * The main class overrides the <b>start</b> method defined in {@code javafx.application} 
   */
  public static void main(String[] args) {
    Application.launch(args);
  }
}

/*
+-------------------+
|       Stage       | > Top-level window or application frame  
|                   |
|  +-------------+  |
|  |    Scene    |  | > Container for all the visual elements of the application
|  |             |  |
|  |  +-------+  |  |
|  |  |Button |  |  | > Clickable button that performs an action
|  |  +-------+  |  |
|  |             |  |
|  +-------------+  |
|                   |
+-------------------+
*/