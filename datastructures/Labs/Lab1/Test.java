package datastructures.Labs.Lab1;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 1
 * @class Test
 * @Disclaimer Any and all work in this file is my own except where otherwise specified ie the questions
 * @Question
Putting it all together. Create a test class that:

Copyright © 2021-2023 by Prof. Johnny Console, Algoma University.
All rights reserved. No parts of this work may be reproduced by any means without prior written permission from the author.
 */

public class Test {
  public static void main(String[] args) {
    /*Creates 7 students with different id numbers and names. One of these students must have your name on it - the rest can be random. Print each one to the console */

    Student student1 = new Student(123, "Lucas Cekan");
    student1.print(); 
    Student student2 = new Student(133, "student2");
    student2.print(); 
    Student student3 = new Student(323, "student3");
    student3.print(); 
    Student student4 = new Student(423, "student4");
    student4.print(); 
    Student student5 = new Student(523, "student5");
    student5.print(); 
    Student student6 = new Student(623, "student6");
    student6.print(); 
    Student student7 = new Student(723, "student7");
    student7.print();

    /*Set the student’s averages to any values you like (range from 0-100). Use a variety of values and print the students to the console again. If you’d like to use random numbers, you can use this code to get a random number between 0 and 100: Math.random()*101. Note: we don’t cast to int here because average is a double value. */

    // Set student averages with random values
    student1.setAverage(95); // not random to check calculation
    student1.print(); 
    student2.setAverage(Math.random() * 101); 
    student2.print(); 
    student3.setAverage(Math.random() * 101); 
    student3.print(); 
    student4.setAverage(Math.random() * 101); 
    student4.print(); 
    student5.setAverage(Math.random() * 101); 
    student5.print(); 
    student6.setAverage(Math.random() * 101); 
    student6.print(); 
    student7.setAverage(Math.random() * 101); 
    student7.print(); 

    /* Creates an instructor with a different id and name to the students. Print it to the console. */

    Instructor instructor = new Instructor(345, "Jamie Remstone", "Computer Science");
    instructor.print();

    /* (d) Create two courses with any code and names you wish - be creative! 
     (e) Assign the instructor to both courses. Print the courses to the console.
    */

    Course course1 = new Course("COSC123", "COSC course 1", instructor);
    course1.print();
    Course course2 = new Course("INTD101", "Introduction to Interpretative Dance", instructor);
    course2.print();

    // (f) Assign 5 of the 7 students to the first course and the other 2 to the second. Print the courses after you are done.

    course1.enroll(student1);
    course1.enroll(student2);
    course1.enroll(student3);
    course1.enroll(student4);
    course1.enroll(student5);
    course2.enroll(student6);
    course2.enroll(student7);
    course1.print();
    course2.print();

    // (g) Assign all students grades. Print all the students to the console.
    course1.assignGrade(student1, 100); // new average should be 97.5
    course1.assignGrade(student2, Math.random() * 101);
    course1.assignGrade(student3, Math.random() * 101);
    course1.assignGrade(student4, Math.random() * 101);
    course1.assignGrade(student5, Math.random() * 101);
    course2.assignGrade(student6, Math.random() * 101);
    course2.assignGrade(student7, Math.random() * 101);
    student1.print(); 
    student2.print(); 
    student3.print(); 
    student4.print(); 
    student5.print(); 
    student6.print(); 
    student7.print(); 

    // (h) Unenroll two students (your choice) from the first course. Print the course to the console.
    course1.unenroll(student2);
    course1.unenroll(student3);
    course1.print();
  }
}