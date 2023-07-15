package datastructures.Labs.Lab5;

import datastructures.Labs.Lab5.ADTList.ListException;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 5
 * @class Test
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question The Array-Based List
 */

public class Test {
  /**
   * Defines a method, called swap, that swaps the items at the indexes provided
   * in a list
   * 
   * You must define the operations in terms of list operations, not array
   * accesses
   * 
   * Do not assume anything – if the positions provided are not occupied in the
   * list, or are invalid
   * (less than zero or greater than the number of items in the list), the method
   * should throw an exception.
   * 
   * @throws ListException
   */
  public static void swap(ADTList list, int i, int j) throws ListException {
    String item1 = list.get(i);
    String item2 = list.get(j);

    list.remove(i);
    list.add(item2, i);

    list.remove(j);
    list.add(item1, j);
  }

  public static void main(String[] args) {
    try {
      ADTList list = new ADTList(8);
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

      swap(list, list.find("Apples"), list.find("Eggs"));
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
