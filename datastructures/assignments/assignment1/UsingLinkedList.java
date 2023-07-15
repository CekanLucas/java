package datastructures.assignments.assignment1;

import java.util.LinkedList;

public class UsingLinkedList {
  public static void main(String[] args) {
    LinkedList<String> linkedList = new LinkedList<>();

    linkedList.add("Apple");
    linkedList.add("Banana");
    linkedList.add("Cherry");

    System.out.println("Initial Linked List: " + linkedList);

    linkedList.addFirst("Orange");

    linkedList.addLast("Grapes");

    System.out.println("\nAfter adding elements: " + linkedList);

    linkedList.set(1, "Mango");

    System.out.println("\nAfter updating element: " + linkedList);

    boolean removed = linkedList.remove("Banana");
    if (removed)
      System.out.println("\nElement 'Banana' successfully removed.");
    else
      System.out.println("\nElement 'Banana' not found.");

    System.out.println("\nAfter removing an element: " + linkedList);

    String firstElement = linkedList.removeFirst();
    String lastElement = linkedList.removeLast();

    System.out.println("\nThe first element '" + firstElement + "' is removed.");
    System.out.println("The last element '" + lastElement + "' is removed.");

    System.out.println("\nFinal Linked List :" + linkedList);

    System.out.println("\nIterating over elements (using both for and foreach):");
    for (int i = 0; i < linkedList.size(); i++) {
      String element = linkedList.get(i);
      System.out.println(element);
    }
    for (String fruit : linkedList) {
      System.out.println(fruit);      
    }
  }
}
