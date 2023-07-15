package datastructures.Labs.Lab6;

import java.util.Objects;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 6
 * @class ListArray
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question The Linked List
 */

public class SingleLinkedList {
  private SingleNode head = null;

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    int listSize = 0;
    if (head == null)
      return listSize;
    while (head.next != null) {
      listSize += 1;
    }
    return listSize;
  }

  public void add(String item, int i) throws ListException {
    if (i < 0)
      throw new ListException(
          "Index cannot be less than zero Method: add Index: " + i);
    else if (i == 0) {
      head = new SingleNode(item, head);
      return;
    }

    SingleNode currentNode = head;
    int currentIndex = 0;
    while (currentNode != null) {
      SingleNode newNode = new SingleNode(item, currentNode.next);
      if (currentIndex + 1 == i) {
        currentNode.next = newNode;
        return;
      } else {
        currentNode.next = currentNode.next == null ? newNode : currentNode.next;

        currentNode = currentNode.next;
        currentIndex++;
      }
    }

    throw new ListException("Index not found Method: add Index: " + i);
  }

  public String remove(int i) throws ListException {
    if (i < 0)
      throw new ListException("Index cannot be less than zero Method: remove Index: " + i);
    else if (i == 0) {
      head = head.next;
      return head.item;
    }

    SingleNode currentNode = head;
    int currentIndex = 0;
    while (currentNode != null) {
      if (currentIndex + 1 == i) {
        SingleNode removedElement = currentNode.next;
        currentNode.next = removedElement.next;
        return removedElement.item;
      } else {
        currentNode = currentNode.next;
        currentIndex++;
      }
    }

    throw new ListException("Index not found Method: remove Index: " + i);
  }

  public void removeAll() {
    head = null;
  }

  public String get(int i) throws ListException {
    if (i < 0)
      throw new ListException("Index cannot be less than zero Method: get Index: " + i);
    else if (isEmpty())
      throw new ListException("List is empty!  Method: get Index: " + i);

    SingleNode currentNode = head;
    int currentIndex = 0;
    while (currentNode != null) {
      if (currentIndex++ == i)
        return currentNode.item;
      currentNode = currentNode.next;
    }

    throw new ListException("Index not found Method: get Index: " + i);
  }

  public int find(String item) {
    SingleNode currentNode = head;
    int currentIndex = 0;
    while (currentNode != null) {
      if (Objects.equals(currentNode.item, item))
        return currentIndex;
      else {
        currentNode = currentNode.next;
        currentIndex++;
      }
    }
    return -1;
  }

  @Override
  public String toString() {
    SingleNode currentNode = head;
    StringBuilder str = new StringBuilder("");

    if (isEmpty())
      return "List is empty!";

    while (currentNode != null) {
      str.append(currentNode.item +
          (currentNode.next == null ? "" : " -> "));
      currentNode = currentNode.next;
    }
    return str.toString();
  }

  void print() {
    System.out.println(this.toString());
  }

  class SingleNode {
    protected String item;
    protected SingleNode next;

    SingleNode(String item) {
      this.item = item;
      this.next = null;
    }

    SingleNode(String item, SingleNode next) {
      this.item = item;
      this.next = next;
    }
  }

  class ListException extends Exception {
    ListException(String message) {
      super(message);
    }
  }

  public static void main(String[] args) throws ListException {
    SingleLinkedList list = new SingleLinkedList();
    System.out.println(list.size());
    list.print();

    list.add("Algoma U", 0);
    list.print();
    list.add("COSC", 1);
    list.print();
    list.add("Data Structures", 1);
    list.print();
    list.add("Java", 3);
    list.print();
    list.remove(1);
    list.print();
    list.remove(0);
    list.print();
  }

}

/*
 * I wrote this by hand before I coded following instructions given
 * 
 * (1) How would each of the following operations affect the list? Show all link
 * changes. Think
 * about the process while we go through these, and how to implement them in
 * code.
 * 
 * a. Determining if the list is empty
 * 
 * list.listEmpty() ==> true
 * 
 * b. Trivial insertion: Insert at index 0
 * 
 * A
 * list.add[0, A] ==> [0]
 * 
 * c. Non-trivial insertion: Insert at an index > 0
 * 
 * B A
 * list.add[0, B] ==> [0] -> [1]
 * 
 * d. Trivial removal: removal at index 0
 * 
 * A
 * list.delete[0, B] ==> [0]
 * 
 * e. Non-trivial removal: removal at an index > 0
 * 
 * A B C remove(1) A C
 * [0] -> [1] -> [2] ==> [0] -> [1]
 * 
 * f. Retrieval at any index
 * 
 * list.get(1) ==> B
 * 
 * g. Calculation of the size of the list
 * 
 * list.size() = 3
 * 
 * h. Removing all elements in one line
 * 
 * list.removeAll()
 * list.size() ==> 0
 * 
 */
