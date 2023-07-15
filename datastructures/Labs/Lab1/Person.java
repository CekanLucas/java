package datastructures.Labs.Lab1;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 1
 * @class Person
 * @Disclaimer Any and all work in this file is my own
 * @Question
 *  Create a public class named Person that contains two private data
 *  variables called
 *  * id (of type int)
 *  * name (of type String)
 * 
 *  Create a constructor for the person class that
 *  receives two parameters, id (type int) and name (type String).
 * 
 *  In your constructor, assign the values to the appropriate class
 *  variables.
 * 
 *  Add the id() and name() methods to the class to return the value of
 *  the appropriate variables.
 * 
 *  Also add a setName() method to set the name variable.
 * 
 *  Note that the id variable must not be able to be changed. (What
 *  modifier is used to make that
 *  happen?)
 * 
 *  Finally, add a method such that when a person object is printed
 *  (with
 *  System.out.println) it will display something like Person[id=1234,
 *  name=John Smythe]
 */
public class Person {
  /* Can't use private for extended data fields */
  private int id; // cant be changed because no set method
  private String name;

  Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int id() {
    return id;
  }

  public String name() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return Ansi.GREEN + "🧍 Person " + 
    Ansi.RED + "[ " + 
    Ansi.BLUE + "id = " + Ansi.YELLOW + id + 
    Ansi.BLUE + ", name = " + Ansi.YELLOW + name +
    Ansi.RED + " ]";
  }

  public void print() {
    System.out.println(toString());
  }
}

interface Ansi {
  String RESET = "\033[0m";
  String CC = "\033[2J"; // clear console
  String RED = "\033[22;31m";
  String GREEN = "\033[1;32m";
  String YELLOW = "\033[1;33m";
  String BLUE = "\033[22;34m";
  String PURPLE = "\033[1;35m";
  String WHITE = "\033[1;37m";
}