package datastructures.Labs.Lab1;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 1
 * @class Instructor
 * @Disclaimer Any and all work in this file is my own
 * @Question
 *  Create a new public class called Instructor that extends the Person class.
 * 
 *  Create a private string variable for the instructor’s department 
 * 
 * and a constructor that takes in the person’s id, name, and department. (Hint: There should only be two lines of code in this constructor). 
 * 
 * Implement the appropriate set and get methods. 
 * 
 * Override the toString method to display something like Instructor
 * <p><code>[id=3456, name=Jamie Remstone, department=Computer Science]</code></p>
 */

public class Instructor extends Person {
  private String department;

  Instructor(int id, String name, String department) {
    super(id, name);
    this.department = department;
  }

  public String department() {
    return this.department;
  }
  public void setDepartment(String department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return Ansi.GREEN + "🧑‍🏫 Instructor " + 
    Ansi.RED + "[ " + 
    Ansi.BLUE + "id = " + Ansi.YELLOW + this.id() + 
    Ansi.BLUE + ", name = " + Ansi.YELLOW + this.name() +
    Ansi.BLUE + ", department = " + Ansi.YELLOW + department +
    Ansi.RED + " ]";
  }

  public static void main(String[] args) {
    Instructor instructor = new Instructor(3456, "Jamie Remstone", "Computer Science");
    instructor.print();
  }
}