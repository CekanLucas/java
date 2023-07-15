package datastructures.Labs.Lab1;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 1
 * @class Student
 * @Disclaimer Any and all work in this file is my own
 * @Question
 *  Create a new public class called Student that extends the Person class.
 * 
 * Create a private double variable for the student’s average (this should be initialized to zero) and
 * 
 *  a constructor that takes in the person’s id and name. (Hint: The only line in this constructor should be a super call). 
 * 
 * Implement the appropriate set and get methods. 
 * 
 * Override the toString method to display something like Student
 * <p><code>🎓 Student [ id = 123, name = Lucas, average = 96.78% ]</code></p>
 */

public class Student extends Person {
  private double average = 0;

  Student(int id, String name) {
    super(id, name);
  }

  public double averageGrade() {
    return this.average;
  }
  public void setAverage(double average) {
    this.average = average;
  }

  @Override
  public String toString() {
    return Ansi.GREEN + "🎓 Student " + 
    Ansi.RED + "[ " + 
    Ansi.BLUE + "id = " + Ansi.YELLOW + this.id() + 
    Ansi.BLUE + ", name = " + Ansi.YELLOW + this.name() +
    Ansi.BLUE + ", average = " + Ansi.YELLOW + average + "%" +
    Ansi.RED + " ]";
  }
}