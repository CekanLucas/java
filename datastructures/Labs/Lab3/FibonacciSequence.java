package datastructures.Labs.Lab3;

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
 * @Lab 3
 * @class FibonacciSequence
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question recursively calculate the fibonacci number
 * @Formula fib(n) = fib(n-1) + fib(n-2), fib(1) & fib(2) = 1
 * @sequence 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
 */

// Wow! One line - Recursion is magical
public class FibonacciSequence {
  public static int fib(int n) {
    return n <= 1 ? 1 : fib(n - 1) + fib(n - 2);
  }

  // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 --> n
  // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 --> fib(n)
  public static void main(String[] args) {
    System.out.print("\033[35;1m \033[2J" + "Give n for the term in the Fibonacci sequence\t"
        + "\033[34;1m");
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    System.out.print("\n\t\033[31;7m  ");
    System.out.print(fib(n));
    System.out.print("  ");
    input.close();
  }
}
