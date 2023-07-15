package datastructures.Labs.Lab7;

import datastructures.Labs.Lab7.SortedLinkedList.ListException;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 7
 * @class Test
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question The Sorted Linked List
 */

public class Test {

  public static void main(String[] args) {
    try {
      SortedLinkedList sortedList = new SortedLinkedList();
      sortedList.insert("Zed"); 
      sortedList.print();
      sortedList.insert("Ben");
      sortedList.print();
      sortedList.insert("Amanda");
      sortedList.print();
      sortedList.insert("Lucas");
      sortedList.print();
      sortedList.insert("Charles");
      sortedList.print();
      sortedList.insert("Prometheus");
      sortedList.print();
      sortedList.insert("Cleo");
      sortedList.print();
      sortedList.insert("Socrates");
      sortedList.print();
      sortedList.insert("Yuri");
      sortedList.print();
      sortedList.insert("Johnny");
      sortedList.print();
      sortedList.remove(0);
      sortedList.print();
      sortedList.remove(3);
      sortedList.print();
      sortedList.remove(1);
      sortedList.print();
      // test other methods
      sortedList.remove(
        sortedList.find("Cleo")
      );
      sortedList.print();
      System.out.println("Name at index 5 " + sortedList.get(5));
      // test exception
      sortedList.get(6);
    } catch (ListException e) {
      System.err.println("An List Error: " + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      System.err.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
