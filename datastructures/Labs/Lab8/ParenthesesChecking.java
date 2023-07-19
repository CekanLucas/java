package datastructures.Labs.Lab8;

import java.util.Scanner;

import datastructures.Labs.Lab8.ArrayStack.StackException;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 8 - The Stack
 * @class Test for ArrayStack
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question Array Stacks
 * @Note we fix the size no dynamic resizing of arrays
 */

public class ParenthesesChecking {

  /**
   * @title PARENTHESIS CHECKING
   *        Write another test class to check that an inputted string (that also
   *        must
   *        be able to have spaces in it) contains the same number of opening
   *        parenthesis “(“ characters as
   *        it does closing parenthesis “)” characters. Show if the string is
   *        valid or not by pushing opening
   *        parenthesis characters to the stack and popping when a closing
   *        parenthesis character is found.
   *        Assume that all opening parenthesis characters will be in the string
   *        before the closing ones.
   *        Catch all exceptions that may occur and print the message to standard
   *        error as we’ve done in
   *        the past.
   * 
   *        Your success case is that when you are done examining the entire
   *        string, the stack is empty
   *        (Valid string).
   * 
   *        One failure case is that there are more opening parentheses than
   *        closing parentheses. This will
   *        happen if there are still characters on the stack when you are done
   *        examining the string. The
   *        other failure case is that there are more closing parentheses than
   *        opening parentheses. This
   *        happens if, at any point while examining the string, you can’t pop
   *        something from the stack.
   * 
   *        Your output should look something like the following:
   *        Enter a string: ((((( This string is valid )))))
   *        The string “((((( This string is valid )))))” has the correct number
   *        of parentheses.
   * 
   *        Enter a string:
   *        ((((( This string has too many opening parentheses )))
   *        The string “(((( This string has too many opening parentheses )))” has
   *        too many opening
   *        parentheses.
   * 
   *        Enter a string: 
   * ((((( This string has too many closing parentheses )))))))) *        The string “((((( This string has too many closing parentheses
   *        ))))))))” has too many closing parentheses
   * @return boolean
   * @throws StackException
   */
  static void parenthesisChecking(String str) throws StackException {
    char[] chars = str.toCharArray();
    ArrayStack stack = new ArrayStack(chars.length);

    for (char c : chars) {
      if (c == '(')
        stack.push(c);
      else if (c == ')') {
        if (stack.isEmpty()) {
          System.out.println(str + "\n\t has too many opening parenthesis");
          return;
        } else {
          stack.pop();
        }
      }
    }
    System.out.println(stack.isEmpty() ? str + "\n\t has correct number of parenthesis"
        : str + "\n\t has too many closing parenthesis");
  }

  public static void main(String[] args) throws StackException {
    System.out.print("Input string:\t");
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    String str = input.next();

    parenthesisChecking(str);

    input.close();
  }

}
