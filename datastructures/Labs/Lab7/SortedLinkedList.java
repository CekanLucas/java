package datastructures.Labs.Lab7;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 7
 * @class SortedLinkedList
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question The Sorted Linked List 
 * @sort Ascending Order  1 -> 2 -> 3
 */

public class SortedLinkedList {
  private SingleNode head = null;

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    int listSize = 0;
    if (head == null)
      return listSize;

    SingleNode currentNode = head;
    while (currentNode != null) {
      listSize += 1;
      currentNode = currentNode.next;
    }
    return listSize;
  }

  public void insert(String item) {
    
    SingleNode currentNode = head;
    SingleNode newNode = new SingleNode(item);
    
    if(head == null) {
      head = newNode;
      return;
    }
    else if (size() == 1) {
      String[] comparisonArray = {head.item, item};
      Arrays.sort(comparisonArray);
      if(Objects.equals(comparisonArray[0], item)) {
        newNode.next = head;
        head = newNode;
        return;
      } else {
        head.next = newNode;
        return;
      }
    }
    
    while (currentNode.next != null) {
      String item1 = currentNode.item;
      String item2 = currentNode.next.item;
      String[] comparisonArray = {item1, item2, item};
      
      Arrays.sort(comparisonArray);

      boolean isFirstElement = Objects.equals(comparisonArray[0], item);  
      boolean shouldInsert = Objects.equals(comparisonArray[1], item);  
      if(isFirstElement) {
        newNode.next = head;
        head = newNode;
        return;
      } else if(shouldInsert) {
        SingleNode node1 = currentNode;
        SingleNode node2 = currentNode.next;
        node1.next = newNode;
        newNode.next = node2;
        return;
      } else 
        currentNode = currentNode.next;
    }

    currentNode.next = newNode;
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
    SortedLinkedList list = new SortedLinkedList();
    System.out.println(list.size());
    list.print();

    list.insert("Z");
    list.print();
    list.insert("A");
    list.print();
    list.insert("C");
    list.print();
    list.insert("B");
    list.print();
    System.out.println(list.size());
    list.remove(1);
    list.print();
    list.remove(0);
    list.print();
  }
}

/* DISCUSSION QUESTION: will the list remain sorted on removal? Explain  */

// yes, as long as you don't break the node chain