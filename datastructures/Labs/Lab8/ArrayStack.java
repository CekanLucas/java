package datastructures.Labs.Lab8;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 8 - The Stack
 * @class ArrayStack
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question Array Stacks
 * @Note we fix the size no dynamic resizing of arrays
 */

public class ArrayStack {
  private char[] arr = new char[0];

  /**
   * You will need a constructor to set up the array reference with a specified
   * number of spaces.
   * If the entered size is zero or negative,
   * throw a custom StackException with an appropriate message,
   * 
   * Do not dynamically resize the array or set a constant size
   */
  ArrayStack(int numberOfSpace) throws StackException {
    if (numberOfSpace <= 0)
      throw new StackException("Number of spaces cannot be less or equal than 0");
    this.arr = new char[numberOfSpace];
  }

  boolean isEmpty() {
    for (char c : arr)
      if (c != '\0')
        return true;
    return false;
  }

  void push(char item) throws StackException {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '\0') {
        arr[i] = item;
        return;
      }
    }
    throw new StackException("Stack is full can't push element\t element: " + item);
  }

  char pop() throws StackException {
    char deletedElement = '\0';
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] != '\0') {
        deletedElement = arr[i];
        arr[i] = '\0';
        return deletedElement;
      }
    }
    throw new StackException("Stack is empty can't pop element");
  }

  void popAll() {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = '\0';
    }
  }

  char peek() throws StackException {
    if (isEmpty())
      throw new StackException("Can't peek, array is empty");
    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i] != '\0')
        return arr[i];
    }
    throw new StackException("Can't peek");
  }

  class StackException extends Exception {
    StackException(String message) {
      super(message);
    }
  }

}

/*
 * 
 * COSC2006 Lab 8 – The Stack
 * Lab Demo: The Array Stack. The stack operations (push, pop, peek, etc.) and
 * how to do them
 * on paper. Think about what we’re doing, and how to put it into code.
 * 
 * The Stack. Create an array-based stack to hold characters.
 * 
 * Implement the following methods:
 * boolean isEmpty(), void push(char item), char pop(), void popAll() and char
 * peek().
 * 
 * 
 * Implement your exception whenever any error can occur, using an appropriate
 * message
 * 
 * Do NOT use a Stack or any other Java-provided data structure
 * Doing so will result in a mark of zero for this lab. You do not need to
 * create a toString method
 * 
 * 
 * 
 * 
 * 
 * Copyright © 2021-2023 by Prof. Johnny Console, Algoma University.
 * All rights reserved. No parts of this work may be reproduced by any means
 * without prior
 * written permission from the author.
 */