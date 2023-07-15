package learn;

import java.util.Scanner;

public class Triangle extends GeometricObject {
  private double side1 = 0;
  private double side2 = 0;
  private double side3 = 0; 
  
  Triangle() {
    this.side1 = 0;    
    this.side2 = 0;    
    this.side3 = 0;      
  }
  Triangle(double side1, double side2, double side3) {
    this.side1 = side1 ;    
    this.side2 = side2 ;    
    this.side3 = side3 ;      
  }
  Triangle(double side1, double side2, double side3, String color, boolean isFilled) {
    super(color, isFilled);
    this.side1 = side1 ;    
    this.side2 = side2 ;    
    this.side3 = side3 ;      
  }
  public double getSide1() {
    return side1;
  }
  public double getSide2() {
    return side2;
  }
  public double getSide3() {
    return side3;
  }
  public void setSide1(double side1) {
    this.side1 = side1;
  }
  public void setSide2(double side2) {
    this.side2 = side2;
  }
  public void setSide3(double side3) {
    this.side3 = side3;
  }

  double getPerimeter() {
    return side1 + side2 + side3;
  }
  @Override
  public
  String toString() {
    return " side1: " + side1 + " side2: " + side2 + " side3: "+ side3;
  }
  public static void main(String[] args) {
    System.out.println("Enter three side lengths then color and then boolean for filled");
    Scanner input = new Scanner(System.in);
    double side1Input = input.nextDouble();
    double side2Input = input.nextDouble();
    double side3Input = input.nextDouble();
    String colorInput = input.next();
    boolean isFilledInput = input.nextBoolean();
    Triangle triangle = new Triangle(side1Input, side2Input, side3Input, colorInput, isFilledInput);
    System.out.println("Your Trangle Perimeter: " + triangle.getPerimeter() + " " + triangle.toString() );
    input.close();
  }
}

class GeometricObject {

  private String color = "white";

  private boolean filled;

  private java.util.Date dateCreated;

  /** Construct a default geometric object */

  public GeometricObject() {

    dateCreated = new java.util.Date();

  }

  /**
   * Construct a geometric object with the specified color
   * 
   * 12 * and filled value
   */

  public GeometricObject(String color, boolean filled) {

    dateCreated = new java.util.Date();

    this.color = color;

    this.filled = filled;

  }

  /** Return color */

  public String getColor() {

    return color;

  }

  /** Set a new color */

  public void setColor(String color) {

    this.color = color;

  }

  /**
   * Return filled. Since filled is boolean,
   * 
   * its getter method is named isFilled
   */

  public boolean isFilled() {

    return filled;

  }

  /** Set a new filled */

  public void setFilled(boolean filled) {

    this.filled = filled;

  }

  /** Get dateCreated */

  public java.util.Date getDateCreated() {

    return dateCreated;

  }

  /** Return a string representation of this object */

  public String toString() {

    return "created on " + dateCreated + "\ncolor: " + color +

        " and filled: " + filled;

  }

}