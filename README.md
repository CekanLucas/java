## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Non-modular samples for Visual Studio Code

JavaFX 17 samples to run from Visual Studio Code with different options and build tools.

Version Visual Studio Code: 1.63.0 or higher.

Download [JDK 11 or later](http://jdk.java.net/) for your operating system. Make sure `JAVA_HOME` is properly set to the JDK installation directory.

### Java

For the first time only:

- Download [JavaFX SDK](https://gluonhq.com/products/javafx/) for your operating 
system and unzip to a desired location.

- Make sure you have the [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) installed in your Visual Studio Code.

- Open `.vscode/settings.json`, replace the `<JavaFX_lib_path>` to you JavaFX lib folder.

- Open `.vscode/launch.json`, replace the `<JavaFX_lib_path>` to you JavaFX lib folder.

#### Run the JavaFX Application

To run the JavaFX Application, open left side `Run and Debug` panel -> `Launch App`.


```mermaid
classDiagram
direction RL

class Node {
  style() void
  rotate() void
}
class Color["javafx.scene.paint.Color"] {
  -red: double
  -green: double
  -blue: double
  -opacity: double
  +Color(r: double, g: double, b: double, opacity: double)
  +brighter() Color
  +darker() Color
  +color(r: double, g: double, b: double, opacity: double)$ Color
  +color(r: double, g: double, b: double)$ Color
  +rgb(r: int, g: int, b: int, opacity: double)$ Color
  +rgb(r: int, g: int, b: int)$ Color
}
class Font["javafx.scene.text.Font"] {
  -size: double
  -name: String
  -family: String
  +Font(size: double)
  +Font(name:String, size: double)
  +font(name:String, size: double)$
  +font(name:String, w: FontWeight, size: double)$
  +font(name:String, w: FontWeight, p: FontPosture size: double)$
  +getFamilies()$ List&gt;String&gt;
  +getFontNames()$ List&gt;String&gt;
}
class ImageView["javafx.scene.image.ImageView"] {
  -fitHeight: DoubleProperty
  -fitWidth: DoubleProperty
  -x: DoubleProperty
  -y: DoubleProperty
  -image: Object~Image~
  +ImageView()
  +ImageView(image:Image)
  +ImageView(filenameOrUrl: String)
}
class FlowPane["javafx.scene.layout.FlowPane"] {
  -alignment: ObjectProperty~Pos~
  -orientation: ObjectProperty~Orientation~
  -hgap: DoubleProperty
  -vgap: DoubleProperty
  +FlowPane()
  +FlowPane(hgap: double, vgap: double)
  +FlowPane(orientation: ObjectProperty~Orientation~)
  +FlowPane(orientation: ObjectProperty~Orientation~, hgap: double, vgap: double)
}

class GridPane["javafx.scene.layout.GridPane"] {
  -alignment: ObjectProperty~Pos~
  -gridLinesVisible: BooleanProperty
  -hgap: DoubleProperty
  -vgap: DoubleProperty
  +GridPPane()
  +add(child: Node, columnIndex: int, rowIndex: int) void
  +addColumns(columnIndex: int, children: Node.. ) void
  +addRow(rowIndex: int, children: Node.. ) void
  +getColumnIndex(child: Node)$ int
  +setColumnIndex(child: Node, columnIndex:int)$ void
  +getRowIndex(child: Node)$ int
  +setRowIndex(child: Node, rowIndex:int)$ void
  +setHalignment(child: Node, value Hpos)$ void
  +setValignment(child: Node, value Vpos)$ void
}
class BorderPane["javafx.scene.layout.BorderPane"] {
  -top: ObjectProperty~Node~
  -right: ObjectProperty~Node~
  -bottom: ObjectProperty~Node~
  -left: ObjectProperty~Node~
  -center: ObjectProperty~Node~
  +BorderPPane()
  +setAlignment(child: Node, pos: Pos) 
}
class HBox["javafx.scene.layout.HBox"] {
  -alignment: ObjectProperty~Pos~
  -fillHeight: BooleanProperty
  -spacing: DoubleProperty
  +HBox()
  +HBox(spacing: double)
  +setMargin(node: Node, value: Insets) void
}
class VBox["javafx.scene.layout.VBox"] {
  -alignment: ObjectProperty~Pos~
  -fillHeight: BooleanProperty
  -spacing: DoubleProperty
  +VBox()
  +VBox(spacing: double)
  +setMargin(node: Node, value: Insets) void
}
class Text["javafx.scene.text.Text"] {
  -text: StringProperty
  -x: DoubleProperty
  -y: DoubleProperty
  -underline: BooleanProperty
  -strikethrough: BooleanProperty
  -font: ObjectProperty~Font~
  +Text()
  +Text(text: String)
  +Text(x: double, y: double, text: String)
}
class Line["javafx.scene.text.Line"] {
  -startX: DoubleProperty
  -startY: DoubleProperty
  -endX: DoubleProperty
  -endY: DoubleProperty
  +Line()
  +Line(see data fields...)
}
class Rectangle["javafx.scene.shape.Rectangle"] {
  -x: DoubleProperty
  -y: DoubleProperty
  -width: DoubleProperty
  -height: DoubleProperty
  -arcWidth: DoubleProperty
  -arcHeight: DoubleProperty
  +Rectangle()
  +Rectangle(see data fields...)
}
class Circle["javafx.scene.shape.Circle"] {
  -centerX: DoubleProperty
  -centerY: DoubleProperty
  -radius: DoubleProperty
  +Circle()
  +Circle(x: double, y: double)
  +Circle(x: double, y: double, radius)
}
class Ellipse["javafx.scene.shape.Ellipse"] {
  -centerX: DoubleProperty
  -centerY: DoubleProperty
  -radiusX: DoubleProperty
  -radiusY: DoubleProperty
  +Ellipse()
  +Ellipse(x: double, y: double)
  +Ellipse(x: double, y: double, radiusX: double, radiusY)
}
class Arc["javafx.scene.shape.Arc"] {
  -centerX: DoubleProperty
  -centerY: DoubleProperty
  -radiusX: DoubleProperty
  -radiusY: DoubleProperty
  -startAngle: DoubleProperty
  -length: DoubleProperty
  -type: ObjectProperty~ArcType~
  +Arc()
  +Arc(see data fields...)
}
class Polygon["javafx.scene.shape.Polygon"] {
  +Polygon()
  +Polygon(double... points)
  +getPoints() Observables~Double~
}
class Polyline
note for Polyline "Same as Polygon except not self closing"

Stage "1"*-- Scene
Parent --*"1" Scene
Shape --> Node
Circle --> Shape
Ellipse --> Shape
Rectangle --> Shape
Arc --> Shape
Polygon --> Shape
Polyline --> Shape
Text --> Shape
Control --> Node
Label --> Control
TextField --> Control
TextArea --> Control
Button --> Control
CheckBox --> Control
RadioButton --> Control
Group --> Parent
Pane --> Parent
Node "*"--* Pane
FlowPane --> Pane
GridPane --> Pane
BorderPane --> Pane
HBox --> Pane
VBox --> Pane
StackPane --> Pane
ImageView --> Node
```





