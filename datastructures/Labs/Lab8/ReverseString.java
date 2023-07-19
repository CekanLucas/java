package datastructures.Labs.Lab8;

import java.util.Scanner;

import datastructures.Labs.Lab8.ArrayStack.StackException;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 8 - The Stack
 * @class ReverseString - Test for ArrayStack
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question Array Stacks
 * @Note we fix the size no dynamic resizing of arrays
 */

public class ReverseString {
  /**
   * @throws StackException
   * @title REVERSING STRINGS
   * @description One great use of a stack is to reverse strings.
   * 
   *              Using your stack, create a test program to collect an input
   *              string
   *              from the user, and display the reverse of the string.
   *              Your input string must be able to have spaces in it, and the
   *              output
   *              must be all on the same line. Catch all
   *              exceptions that may occur and print the message to standard
   *              error as
   *              we’ve done in the past.
   * 
   * @Example:
   *           The string “Data Structures are cool”
   *           would print “looc era serutcurtS ataD”
   */
  static void reverseString(String str) throws StackException {
    char[] chars = str.toCharArray();
    ArrayStack stack = new ArrayStack(chars.length);
    for (int i = 0; i < chars.length; i++)
      stack.push(chars[i]);
    while (stack.isEmpty())
      System.out.print(stack.pop());
  }

  public static void main(String[] args) throws StackException {
    System.out.print("Input string:\t");
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    String str = input.next();
    
    reverseString(str);
    
    input.close();
  }
}
