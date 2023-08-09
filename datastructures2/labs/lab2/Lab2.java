
package datastructures2.labs.lab2;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @course COSC 2007
 * @Lab 2 - Exercise#1 & #2
 * @class Lab2
 * @Question
 * 
 *           <pre>
Exercise#1
Write a program to check given string is palindrome or not using recursion
Exercise#2
Write a program to convert prefix into postfix expression
 *           </pre>
 * 
 * @pseudoCode Written before I coded
 * 
 *             <pre>
 Exercise#1
** Write a program to check given string is palindrome or not using recursion

Boolean isPalindrome(String string) 

base case (length = zero) => return true

maybe convert to char array split in two and check each end if they are equal

Exercise#2
**Write a program to convert prefix into postfix expression

Store operators in a stack and pop them after two operands 

 *             </pre>
 * 
 * @output @see#main
 * 
 *         <pre>
               PALINDROME
        string          : true/false
--------------------------------------------
        racecar         : true
        racecars        : false

                Prefix to PostFix
--------------------------------------------
        /ab     🔄       ab/
        +46*-85 🔄       46+85-*
        *ab/d   🔄       ab*d/
 *         </pre>

 */
public class Lab2 {
  static boolean isPalindrome(String string) {
    if (string.length() <= 1)
      return true;
    char[] chars = string.toCharArray();
    char firstChar = chars[0];
    char lastChar = chars[chars.length - 1];
    if (firstChar == lastChar) {
      String newString = String.copyValueOf(
          chars, 1, chars.length - 2);
      return isPalindrome(newString);
    } else
      return false;
  }

  /**
   * 
   * @Definitions
   * 
   *              <pre>
   * Infix Expressions : a+b
   * (4 + 6) * (8 - 5)
   * Prefix Expressions : +ab Also known as Polish Notation
   * + 4 6 * - 8 5
   * Postfix Expressions : ab+ Also known as reverse Polish Notation
   * 4 6 + 8 5 - *
   *              </pre>
   * 
   */
  // + 4 6 * - 8 5 --> 4 6 + 8 5 - *
  static String prefixToPostfix(String prefix) {
    char[] chars = prefix.toCharArray();
    StringBuilder str = new StringBuilder();

    Stack<Character> operators = new Stack<>();

    // number of operands 2 means operator next expected
    int operands = 0;
    for (char c : chars) {
      if (isOperator(c)) {
        operators.push(c);
      } else {
        str.append(c);
        operands++;
        while (operands >= 2) {
          operands -= 2;
          str.append(operators.pop());
        }
      }
    }

    while (!operators.empty()) 
      str.append(operators.pop());

    return str.toString();
  }

  static boolean isOperator(char c) {
    char[] operators = { '+', '-', '*', '/' };
    Arrays.sort(operators); // Sort the operators array
    return Arrays.binarySearch(operators, c) >= 0;
  }

  public static void main(String[] args) {
    String palindrome = "racecar";
    String notPalindrome = "racecars";
    System.out.println(
        "\t\tPALINDROME\n\tstring\t\t: true/false\n" +
            "--------------------------------------------\n\t" +
            palindrome + "\t\t: " + isPalindrome(palindrome) + "\n\t" +
            notPalindrome + "\t: " + isPalindrome(notPalindrome));
    System.out.println();

    String prefix1 = "/ab";
    String prefix2 = "+46*-85";
    String prefix3 = "*ab/d";
    String boundaryPrePostFix = "\t🔄\t ";
    System.out.println(
        "\t\tPrefix to PostFix\n" +
            "--------------------------------------------\n\t" +
            prefix1 + boundaryPrePostFix + prefixToPostfix(prefix1) + "\n\t" +
            prefix2 + boundaryPrePostFix + prefixToPostfix(prefix2) + "\n\t" +
            prefix3 + boundaryPrePostFix + prefixToPostfix(prefix3));
  }
}