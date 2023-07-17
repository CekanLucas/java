package datastructures.assignments.assignment2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * * Exercise#1
 * Make a java program that uses Queue as a part of the priority queue in
 * java.util package. Create a queue and perform the following operations
 * • Add the elements in the queue in the following order: 1, 17, 40, 52, 76
 * • Access the element using peek // this will always display 1 don't know if
 * this is by design, I assume not
 * • Remove the element of the queue (76) and display the remaining elements
 */
public class UseQueue {
  public static void main(String[] args) {
    int[] elements = { 1, 17, 40, 52, 76 };

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int element : elements) {
      if (queue.add(element))
        System.out.println("Element " + element +
            " has been added to queue" +
            "\n\t queue =>\t" + queue);
    }

    if (queue.remove(76))
      System.out.println("Element 76" +
          " has been removed to queue" +
          "\n\t queue =>\t" + queue);
  }
}

/**
 * * Exercise#2
 * Implement stack and its operations using Queue data structure in java
 */
class ImplementStack {
  private Queue<Integer> stack = new LinkedList<>();

  ImplementStack() {
    this.stack = new LinkedList<>();
  }

  // here we add a element to the end of the list in line with stack
  boolean push(int item) {
    return stack.add(item);
  }

  // remove and return element in line with last in first out
 int pop() {
    // Create a temporary queue to preserve order while removing elements
    Queue<Integer> tempQueue = new LinkedList<>();
    
    // Move all elements except the last one to temporary queue
    while (stack.size() > 1) {
        tempQueue.add(stack.remove());
    }
    
    // Remove and return the last element (top of the stack)
    int poppedElement = stack.remove();
    
   // Move back remaining elements from temporary queue to original stack 
   while (!tempQueue.isEmpty()) {
       stack.add(tempQueue.remove());
   }

   return poppedElement;
}

  // traverse and print to output
  void traverseAndDisplay() {
    if (stack.isEmpty()) {
        System.out.println("This Stack is empty!");
        return;
    }

    // Create a temporary queue to preserve order while displaying
    Queue<Integer> tempQueue = new LinkedList<>(stack);

    StringBuilder sb = new StringBuilder();
    
    while (!tempQueue.isEmpty()) {
        int element = tempQueue.remove();
        
        // Append the current element to the string builder
        sb.append(element);
        
        // If it's not the last element, append " <- "
        if (!tempQueue.isEmpty()) {
            sb.append(" <- ");
        }
    }
    
    System.out.println(sb.toString());
}
  public static void main(String[] args) {
    int[] elements = { 1, 17, 40, 52, 76 };

    ImplementStack stack = new ImplementStack();

    for (int element : elements) {
      if (stack.push(element))
        System.out.println("Element " + element +
            " has been pushed to stack");
    }
    stack.traverseAndDisplay();

      System.out.println("Element " + stack.pop() +
          " has been popped from stack");
    stack.traverseAndDisplay();
  }
}

/**
 * * Exercise #3
 * Implement Queue using array in java. You are required to implement the
 * methods for insertion, deletion, traversing/displaying the elements in it.
 */
class ArrayQueue {
  private int[] arr = new int[0];

  // initialize empty array
  ArrayQueue() {
    this.arr = new int[0];
  }

  // in a queue elements are always added to tail ie the end of the list
  // this means here insertion is at the end of the array
  void insertion(int item) {
    int[] newArr = Arrays.copyOf(arr, arr.length + 1);
    newArr[newArr.length - 1] = item;
    arr = newArr;
  }

  // In a queue firstIn firstOut means first element is always deleted
  // here we return the deleted element
  int deletion() {
    int deletedElement = arr[0];
    int[] newArr = Arrays.copyOfRange(arr, 1, arr.length - 1);
    arr = newArr;
    return deletedElement;
  }

  // traverse through queue list &
  // print to output
  void traverseAndDisplay() {
    if (arr.length == 0)
      System.err.println("This Queue is empty!");

    for (int i = 0; i < arr.length; i++) {
      int element = arr[i];
      System.out.print((i == 0 ? "" : " <- ") + element);
    }
  }

  public static void main(String[] args) {
    QueueList queueList = new QueueList();
    queueList.insertion(1);
    queueList.traverseAndDisplay();
    queueList.insertion(17);
    queueList.traverseAndDisplay();
    queueList.insertion(40);
    queueList.traverseAndDisplay();
    queueList.insertion(52);
    queueList.traverseAndDisplay();
    queueList.insertion(76);
    queueList.traverseAndDisplay();
    queueList.deletion();
    queueList.traverseAndDisplay();
  }
}

/**
 * Queues are first in first out Leave <- 1 2 3 4 5 <- Insertion
 * 
 * * Exercise #4
 * Implement Queue using linked list in java. You are required to implement the
 * methods for insertion, deletion, traversing/displaying the elements in it.
 */
class QueueList {
  private Node endNode = null;
  private Node startNode = null;

  // constructor for initial empty list
  QueueList() {
    this.endNode = null;
    this.startNode = null;
  }

  // constructor for initial list with starting element
  QueueList(int item) {
    Node newNode = new Node(item);
    this.endNode = newNode;
    this.startNode = newNode;
  }

  // insert element from the back of the queue
  void insertion(int item) {
    Node newNode = startNode == null ? new Node(item)
        : new Node(item, endNode);
    if (endNode != null) {
      endNode.prev = newNode;
      endNode = newNode;
    }
    if (startNode == null) {
      startNode = newNode;
      endNode = newNode;
    }
  }

  // delete element from beginning of queue, move up next element to head of the
  // queue and return the deleted element
  int deletion() {
    Node deletedNode = startNode;
    startNode = deletedNode.prev;
    startNode.next = null;
    return deletedNode.item;
  }

  // traverse through queue list, noting journey from back to front of queue and
  // print to output
  void traverseAndDisplay() {
    Node currentNode = startNode;
    StringBuilder str = new StringBuilder("");

    while (currentNode != null) {
      str.append(
          (currentNode.next == null ? "" : " <- ") + currentNode.item);
      currentNode = currentNode.prev;
    }

    System.out.println(str);
  }

  // create Node inner class for traversal with next and prev
  class Node {
    protected int item;
    protected Node next;
    protected Node prev;

    Node(int item) {
      this.item = item;
      this.next = null;
      this.prev = null;
    }

    Node(int item, Node next) {
      this.item = item;
      this.next = next;
      this.prev = null;
    }
  }

  /*
   * • Add the elements in the queue in the following order: 1, 17, 40, 52, 76
   * • Access the element using peek
   * • Remove the first element, first-in first-out
   */
  public static void main(String[] args) {
    QueueList queueList = new QueueList();
    queueList.insertion(1);
    queueList.traverseAndDisplay();
    queueList.insertion(17);
    queueList.traverseAndDisplay();
    queueList.insertion(40);
    queueList.traverseAndDisplay();
    queueList.insertion(52);
    queueList.traverseAndDisplay();
    queueList.insertion(76);
    queueList.traverseAndDisplay();
    queueList.deletion();
    queueList.traverseAndDisplay();
  }

}

/*
 * 
 * Assignment 2
 * Instructions:
 * This assessment covers the contents discussed till now
 * ◦ All submitted assigned work must conform to proper Java programming style
 * and documentation. Especially regarding naming conventions.
 * ◦ Your source code should contain comments describing the functionality and
 * the major components of each object and method.
 * ◦ Student full name and student number MUST be included on each submitted
 * work
 * ◦ The word file is to be submitted with proper page borders and formatting.
 * Screenshot of code and output is to be submitted on doc file. Student name,
 * assignment name, ID number should be displayed on every page header.
 * ◦ All assigned work should be completed by the student without the
 * collaboration of others.
 * ◦ Unauthorized collaboration will be treated as violations of academic
 * integrity under the University’s Academic Integrity Policy.
 * ◦ All assignment solutions should be uploaded to the appropriate Assignments
 * folder
 * ◦ Professional/personal integrity is very important. Any noted cheating will
 * be dealt accordingly with the university policies.
 * ◦ For writing code, proper indentation, naming conventions are to be
 * followed. Also paste the screenshot of code and its output
 * 
 * Please don’t submit .java files
 */
