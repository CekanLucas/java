package datastructures.Labs.Lab2;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 1
 * @class DownToZeroByThree
 * @Disclaimer Any and all work in this file is my own except where otherwise specified ie the questions
 * @Question This is a discussion class with questions specified

Copyright © 2021-2023 by Prof. Johnny Console, Algoma University.
All rights reserved. No parts of this work may be reproduced by any means without prior written permission from the author.
 */


public class DownToZeroByThree {
  public static void downToZeroByThree(int value) {
    if(value != 1) {
      System.out.println(value);
      downToZeroByThree(value - 3);
    }
  }

  public static void main(String[] args) {
    /* OUTPUT (a)
     * 10
     * 7
     * 4
     */
    downToZeroByThree(10);

    /* OUTPUT (b)
      Crash because base condition never met
     */
    // downToZeroByThree(6);
    rewrittenDownToZeroByThree(6); // now it works
  }

  /** For question (h)  */
  public static void rewrittenDownToZeroByThree(int value) {
    if(value > 1) return;
    else {
        System.out.println(value);
        rewrittenDownToZeroByThree(value - 3);
    }
  }
}

/* Questions 
 * (c) How can the problem be broken into multiple subproblems of the same type?
 Iteration of each value being reduced by 1 so subproblem of 9 would be 6 subproblem of 3 would be zero and so on
 * (d) How does each recursive call diminish the size of the problem?
 Each recursive call decreases the value until the base case is reached
 * (e) What instance of the problem space serve as the base case?
 If the value equals 1 the recursion stops so at 1 is the base case
 * (f) Will this solution _always_ reach the base case? If not, explain why
 No, because the base case could be passed if the initial value is not a multiple of 3
 * (g) What change can be made to make the solution correct
 Change the condition from value != 1 to value > 1
 * (h) What change can be made to make the solution correct

*/