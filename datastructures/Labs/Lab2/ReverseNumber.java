package datastructures.Labs.Lab2;

import java.util.Scanner;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 1
 * @class ReverseNumber
 * @Disclaimer Any and all work in this file is my own except where otherwise
 *             specified ie the questions
 * @Question This is a discussion class with questions specified
 * 
 *  MUST USE RECURSION, MUST USE ALL PARAMETERS OF METHOD HEADERS, MUST
 *  NOT USE STATIC VARIABLES
 *  else get 0
 * 
 *  Copyright © 2021-2023 by Prof. Johnny Console, Algoma University.
 *  All rights reserved. No parts of this work may be reproduced by any
 *  means without prior written permission from the author.
 */

public class ReverseNumber {
  /**
   * Reverses method, if the number is negative, reverse the number and put the
   * negative sign after the reversed number
   * 
   * <p>
   * Your main program must ask for the number
   * </p>
   * 
   * <p>
   * <strong>not allowed to use any string operations here* </strong>
   * </p>
   * 
   * <pre>{@code
   * // Examples
   *    reverse(12345) // prints 54321 
   *    reverse(-12345) // prints 54321-
   * }</pre>
   * 
   * @hint Need to use divide operation and the modulus operator
   */
  public static void reverse(int number) {
    if (Math.abs(number) > 10) {
      int lastDigit = number % 10;
      int remainingDigits = number / 10;

      System.out.print(Math.abs(lastDigit));

      reverse(remainingDigits);
    } else 
      System.out.print(number<0 ? Math.abs(number) + "-" : number);
  }

  public static void main(String[] args) {
    System.out.print("\033[35;1m \033[2J" + "Give a number to reverse:  " + "\033[34;1m");
    Scanner input = new Scanner(System.in);
    int number = input.nextInt();
    System.out.print("\n\t\033[31;7m  " );
    reverse(number);
    System.out.print("  " );
    input.close();
  }
}