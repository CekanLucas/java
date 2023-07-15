package datastructures.assignments.assignment2;

/**
 * Queues are first in first out Leave <- 1 2 3 4 5 <- Insertion
 */
public class QueueList {
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
 * 
 * 
 * Exercise#1
 * Make a java program that uses Queue as a part of the priority queue in
 * java.util package. Create a queue and perform the following operations
 * • Add the elements in the queue in the following order: 1, 17, 40, 52, 76
 * • Access the element using peek
 * • Remove the element of the queue (76) and display the remaining elements
 * 
 * Exercise#2
 * Implement stack and its operations using Queue data structure in java
 * 
 * Exercise #3
 * Implement Queue using array in java. You are required to implement the
 * methods for insertion, deletion, traversing/displaying the elements in it.
 * 
 * Exercise #4
 * Implement Queue using linked list in java. You are required to implement the
 * methods for insertion, deletion, traversing/displaying the elements in it.
 * 
 * 
 * 
 */
