package datastructures.Labs.Lab2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MUST USE RECURSION, MUST USE ALL PARAMETERS OF METHOD HEADERS, MUST
 * NOT USE STATIC VARIABLES
 * else get 0
 * 
 * Copyright © 2021-2023 by Prof. Johnny Console, Algoma University.
 * All rights reserved. No parts of this work may be reproduced by any
 * means without prior written permission from the author.
 * 
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 1
 * @class DownToZeroByThree
 * @Disclaimer Any and all work in this file is my own except where otherwise
 *             specified ie the questions
 * @Question This is a discussion class with questions specified
 */

public class MaximumCharacter {
  /** Determine character with the hightest ASCII value within a string */
  public static char maximumChar(String str, char max) {
    if (str.isEmpty())
      return max;

    char[] chars = str.toCharArray();

    String newString = String.copyValueOf(Arrays.copyOfRange(chars, 1, chars.length));

    return chars[0] > max ? maximumChar(newString, chars[0]) : maximumChar(newString, max);
  }

  public static void main(String[] args) {
    System.out.print("\033[35;1m \033[2J" +
        "Type a string to get the maximum character:  " +
        "\033[34;1m");
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    String str = input.next();
    System.out.print("\n\t\033[31;7m  ");
    System.out.print(maximumChar(str, '\0'));
    System.out.print("  \n");
    input.close();
  }
}
