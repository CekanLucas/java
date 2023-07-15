package datastructures.Labs.Lab6;

import datastructures.Labs.Lab6.SingleLinkedList.ListException;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 6
 * @class Test
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question The Linked List
 */

public class Test {

  public static void main(String[] args) {
    try {
      SingleLinkedList list = new SingleLinkedList();
      list.add("Milk", 0);
      list.print();
      list.add("Eggs", 1);
      list.print();
      list.add("Celery", 2);
      list.print();
      list.add("Bananas", 0);
      list.print();
      list.add("Apples", 3);
      list.print();
      list.add("Oranges", 0);
      list.print();
      list.add("Cookies", 1);
      list.print();
      list.add("Steak", 0);
      list.print();

      list.remove(list.find("Celery"));
      list.print();
      list.remove(list.find("Oranges"));
      list.print();

      list.print();

      list.get(9); // test exception
    } catch (ListException e) {
      System.err.println("An List Error: " + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      System.err.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
