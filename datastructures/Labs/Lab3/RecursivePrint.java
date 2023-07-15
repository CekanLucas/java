package datastructures.Labs.Lab3;

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
 * @Lab 3
 * @class Recursive Printing
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question The printBoth is a discussion method
 */

public class RecursivePrint {
  /*
   * For n = 4
   * 
   * *
   * * *
   * * * *
   */
  public static void printUp(int n) {
    if (n == 1)
      System.out.println("*");
    else {
      StringBuilder s = new StringBuilder("");
      for (int i = 0; i < n; i++) {
        s.append((new AnsiColorGenerator().generateRandomColor()) + "* ");
      }
      printUp(n - 1);
      System.out.println(s.toString());
    }
  }

  /*
   * Expected Output
   * For n = 4
   * * * *
   * * *
   * *
   */
  public static void printDown(int n) {
    if (n == 1)
      System.out.println("*");
    else {
      StringBuilder s = new StringBuilder("");
      for (int i = 0; i < n; i++) {
        s.append((new AnsiColorGenerator().generateRandomColor()) + "* ");
      }
      System.out.println(s.toString());
      printDown(n - 1);
    }
  }

  /*
   * This method is impossible for how recursion works
   * Expected Output for n = 4
   * *
   * * *
   * * * *
   * * * *
   * * *
   * *
   */
  public static void printBoth(int n) {
    if (n == 1)
      System.out.println("*");
    else {
      StringBuilder s = new StringBuilder("");
      for (int i = 0; i < n; i++) {
        s.append("* ");
      }
      System.out.println(s.toString().trim());
      printBoth(n - 1);
      System.out.println(s.toString().trim());
    }
  }

  public static void main(String[] args) {
    System.out.println("\033[2J"); // clear console
    printUp(6);
    printDown(6);
  }
}

interface ColorGenerator {
  String generateRandomColor();
}

class AnsiColorGenerator implements ColorGenerator {
  @Override
  public String generateRandomColor() {
    int randomCode = (int) (Math.random() * 255);
    return "\033[1;38;5;" + randomCode + "m";
  }
}