package datastructures.assignments.assignment1;

import java.util.Arrays;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @assignment 1
 * @class Palindrome
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question 1) Design the recursive algorithm to check given string is
 *           palindrome or not then convert into a java code. Write a program to
 *           solve towers of hanoi problem using recursion
 */

public class Palindrome {
  public static boolean isPalindrome(String str) {
    if (str.isEmpty() || str.length() == 1)
      return true;

    char[] chars = str.toCharArray();

    char firstChar = chars[0];
    char lastChar = chars[chars.length - 1];

    if (firstChar != lastChar)
      return false;

    String newString = String.copyValueOf(Arrays.copyOfRange(chars, 1, chars.length - 1));

    return isPalindrome(newString);
  }

  public static void main(String[] args) {
    System.out.print(isPalindrome("racecar"));
    System.out.print(isPalindrome("racecars"));
  }
}

/*
 * It involves moving a specified number of disks of distinct sizes from one
 * tower to another
 * 
 * The rules are given below:
 * • There are n disks labelled 1, 2, 3, . . . , n and three towers labelled
 * tower1, tower2, and tower3
 * • No disk can be on top of a smaller disk at any time
 * • All the disks are initially placed on tower A
 * • Only one disk can be moved at a time and it must be the smallest disk on a
 * tower
 */



/** QUESTION
Write a  recursive program to search a number by using binary search method.
The main techniques are given below:
 • Case 1: If the key is less than the middle element, recursively search for the key in the first half of the array.
 • Case 2: If the key is equal to the middle element, the search ends with a match.
 • Case 3: If the key is greater than the middle element, recursively search for the key in the second half of the array.

returns -1 if search not found
 */
class RecursiveBinarySearch {
  static int[] exampleArr = new int[]{ 1,2,3,4,5,6,7,8 };
  
  static int search(int[] arr, int num) {
    int middleElement = arr[arr.length / 2];
    if(middleElement == num) {
      return num;
    } else if(arr.length == 1) {
      return -1;
    } else {
      if(num > middleElement) {
        int[] arrRight = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        return search(arrRight, num);
      } else {
        int[] arrLeft = Arrays.copyOfRange(arr, 0, arr.length / 2);
        return search(arrLeft, num);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(RecursiveBinarySearch.search(exampleArr, 1));
    System.out.println(RecursiveBinarySearch.search(exampleArr, 7));
    System.out.println(RecursiveBinarySearch.search(exampleArr, 6));
    System.out.println(RecursiveBinarySearch.search(exampleArr, 9));
    System.out.println(RecursiveBinarySearch.search(exampleArr, 10));
  }
}



class LinkedList {
  private Node startNode;

  // initialize with a single item
  LinkedList(int item) {
    this.startNode = new Node(item);
  }

  public Node getStartNode() {
    return startNode;
  }

  void insertBeginning(int newData) {
    Node newNode = new Node(newData, startNode);
    this.startNode = newNode;
  }

  void insertEnd(int newData) {
    Node newNode = new Node(newData, null);

    Node currentNode = startNode; 

    while(currentNode.next != null ) {
      currentNode = currentNode.next;
    }

    currentNode.next = newNode;
  }

  void insertAfterValue(int targetData, int newData) {
    Node newNode = new Node(newData, null);

    Node currentNode = startNode; 

    while(currentNode.data != targetData ) {
      currentNode = currentNode.next;
    }

    newNode.next = currentNode.next;
    currentNode.next = newNode;
  }

  void printTraverse() {
    Node currentNode = startNode;

    while(currentNode.next != null ) {
      System.out.print(currentNode.data + " -> ");
      currentNode = currentNode.next;
    }

    System.out.print(currentNode.data);
  }
  
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }

    Node(int data, Node next){
      this.data = data;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList(52);
    linkedList.insertBeginning(9);
    linkedList.insertBeginning(40);
    linkedList.insertEnd(2);
    linkedList.insertAfterValue(9, 10);
    linkedList.printTraverse();
  }
}