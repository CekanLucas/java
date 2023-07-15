package datastructures.Labs.Lab1;

import java.util.Arrays;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 1
 * @class Course
 * @Disclaimer Any and all work in this file is my own
 * @Question
 *  Create a new public class called Course that contains a private
 *  final integer called MAX_ENROLLED_STUDENTS and set it equal to 5.
 * 
 *  The class should also have a
 *  * private array variable to hold the students in the course,
 *  * an enrollment variable (of type int) to hold how many students
 *  are currently enrolled in the course,
 *  * a variable of type Instructor to hold the course’s instructor and
 *  * two string values to hold its course code and the name of the course.
 * 
 *  Add a constructor that receives two strings: one for the code and
 *  one for the name. Set the class variables and initialize the array
 *  variable.
 * 
 *  Add an {@code enroll(Student student)} method to add a student to
 *  the course, making sure to check that the student can be enrolled first.
 * 
 *  Add the {@code unenroll(Student student)} method to remove the
 *  student from the course,
 *  * checking if (a) there are students in the course,
 *  * and (b) the student being removed is actually in the course.
 * 
 *  Add the {@code assignGrade(Student student, double grade)} method
 *  to assign the student a grade in the course and change their
 *  average according to the formula (average + grade) / 2.
 * 
 *  Add any other appropriate set and get methods, keeping in mind the
 *  principle of information hiding, and what we do or don’t want our
 *  users to access or change.
 * 
 *  Finally, add a toString method to print something like
 *  <p><code>📚 Course [ code = COSC123, name = COSC course 1, instructor = Jamie Remstone, enrolled = 0 ]</code></p>
 */

public class Course {
  private final int MAX_ENROLLED_STUDENTS = 5;
  private Student[] students;
  private int enrollment;
  private Instructor instructor;
  private String courseCode;
  private String courseName;

  Course(String courseCode, String courseName, Instructor instructor) {
    this.courseCode = courseCode;
    this.courseName = courseName;
    this.instructor = instructor;
    this.students = new Student[0];
    this.enrollment = this.students.length;
  }

  void enroll(Student student) {
    if (enrollment < MAX_ENROLLED_STUDENTS) {
      Student[] newArr = Arrays.copyOf(students, students.length + 1);
      newArr[students.length] = student;
      students = newArr;
      enrollment++;
    } else {
      System.err.println("Max Enrollment reached. " + student.name() + " was unable to be enrolled.");
    }
  }

  void unenroll(Student student) {
    if (students.length > 0) {
      boolean studentFound = false;

      for (int i = 0; i < students.length; i++) {
        if (student.id() == students[i].id()) {
          Student[] newArr = new Student[students.length - 1];

          int indexCounter = 0;
          for (int j = 0; j < newArr.length; j++) {
            if (indexCounter == i) {
              indexCounter++;
            }
            newArr[j] = students[indexCounter++];
          }

          students = newArr;
          enrollment--;
          studentFound = true;
          break;
        }

        if (i == students.length - 1 && !studentFound) {
          System.err.println(student.name() + " was unable to be unenrolled because not enrolled");
          return;
        }
      }
    } else {
      System.err
          .println(student.name() + " was unable to be unenrolled as there are no students enrolled in the course");
    }
  }

  void assignGrade(Student student, double grade) {
    student.setAverage((student.averageGrade() + grade) / 2);
  }

  public int maximumStudents() {
    return MAX_ENROLLED_STUDENTS;
  }
  public String getCourseCode() {
    return courseCode;
  }
  public String getCourseName() {
    return courseName;
  }
  public int getEnrollment() {
    return enrollment;
  }
  public Student[] getStudents() {
    return students;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  @Override
  public String toString() {
    return Ansi.GREEN + "📚 Course " +
        Ansi.RED + "[ " +
        Ansi.BLUE + "code = " + Ansi.YELLOW + courseCode +
        Ansi.BLUE + ", name = " + Ansi.YELLOW + courseName +
        Ansi.BLUE + ", instructor = " + Ansi.YELLOW + instructor.name() +
        Ansi.BLUE + ", enrolled = " + Ansi.YELLOW + enrollment +
        Ansi.RED + " ]";
  }

  public void print() {
    System.out.println(toString());
  }
}