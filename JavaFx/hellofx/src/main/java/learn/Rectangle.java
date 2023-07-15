package learn;

public class Rectangle implements Comparable, Cloneable {
  private double width;
  private double height;

  Rectangle() {
    this.width = 1.0;
    this.height = 1.0;
  }

  Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public double getWidth() {
    return width;
  }
  public double getHeight() {
    return height;
  }
  public void setWidth(double width) {
    this.width = width;
  }
  public void setHeight(double height) {
    this.height = height;
  }
  
  double getArea() {
    return width * height;
  }
    double getPerimeter() {
    return 2 * (width + height);
  }

  @Override // perimeter
  public boolean equals(Object obj){
    if(!(obj instanceof Rectangle))
      return false;
    Rectangle rectangle = (Rectangle)obj;
    return rectangle.getArea() == this.getArea();
  } 

  @Override
  public String toString() {
    return "Width: " + width + "\tHeight: " + height;
  }

  @Override
  public int compareTo(Object o) {
    Rectangle rectangle = (Rectangle)o;
    double diff = this.getArea() - rectangle.getArea();
    if(diff> 0)
      return 1;
    else if (diff<0)
      return -1;  
    else
      return 0;
  }

  @Override
  public Rectangle clone() throws CloneNotSupportedException {
      return (Rectangle) super.clone();
  }

  public static void main(String[] args) {
    
  }
}
