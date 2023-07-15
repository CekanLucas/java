package datastructures.Labs.Lab4;

import java.util.regex.Pattern;

import datastructures.Labs.Lab4.BankAccount.BankException;

/**
 * Copyright © 2021-2023 by Prof. Johnny Console, Algoma University.
 * All rights reserved. No parts of this work may be reproduced by any
 * means without prior written permission from the author.
 * 
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 4 Abstract Data Structures
 * @class BitBank
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question
 * @accountNumber composed of
 *                * two-character country code (ie CA for Canada)
 *                * followed by 2 digit transit number
 *                * followed by 4 digit account number
 */

public class BankAccount {
  private String accountId;
  private double accountBalance;

  /*
   * Constructor must verify the account number if number isInvalid constructor
   * should throw another BankException with an appropriate message
   * 
   * Only create the object with valid account number (Throwing the exception
   * stops the program
   ** Do not catch any exceptions here**)
   */
  BankAccount(String accountNumber, double accountBalance) throws BankException {
    if (accountBalance < 0)
      throw new BankException("Bank account balance must not be less then zero");
    if (verify(accountNumber)) {
      this.accountId = accountNumber;
      deposit(accountBalance); // initial deposit

    } else
      throw new BankException("Bank account number is not valid");
    // this.accountBalance = accountBalance;
  }

  void deposit(double amount) throws BankException {
    if (amount < 0)
      throw new BankException("Can't deposit a negative amount");
    accountBalance += amount;
  }

  void withdraw(double amount) throws BankException {
    if (amount < 0)
      throw new BankException("Can't withdraw a negative amount");
    else if (accountBalance - amount < 0)
      throw new BankException("Insufficient funds");
    else
      accountBalance -= amount;
  }

  double balance() {
    return accountBalance;
  }

  private boolean verify(String testAccountNumber) {
    /*
     * MOD-ELEVEN Algorithm
     * 1) Check that the length of the number is correct: should be 8. If length is
     * incorrect number is not valid
     * 2) Move the first four characters to the end of the string
     * 3) Convert the letters to their corresponding integer values, where A = 10, B
     * = 11, C = 12 ...
     * 4) Interpret the number as a long value (Long.parseLong) and divide by 11. Id
     * the remainder is 1 (% modulus operator) the number is valid else not
     * 
     * Examples
     * - GB821234 is a valid number
     * - CA123456 is an invalid number
     */

    if (testAccountNumber.length() != 8)
      return false;

    String reorderedNumber = testAccountNumber.substring(4, testAccountNumber.length()) +
        testAccountNumber.substring(0, 4);

    reorderedNumber.replaceAll("([A-Z])",
        "$1".charAt(0) - 55 + "");

    String newString = Pattern.compile("[A-Z]")
        .matcher(reorderedNumber)
        .replaceAll(m -> Integer.toString(m.group().charAt(0) - 55));

    return Long.parseLong(newString) % 11 == 1;
  }

  @Override
  public String toString() {
    return Ansi.GREEN + "🏦💵 BankAccount " +
        Ansi.RED + "[ " +
        Ansi.BLUE + "accountNumber = " + Ansi.YELLOW + accountId +
        Ansi.BLUE + ", balance = " + Ansi.GREEN + String.format("$%.2f", accountBalance) +
        Ansi.RED + " ]";
  }

  public void print() {
    System.out.println(toString());
  }

  class BankException extends Exception {
    public BankException(String message) {
      super(message);
    }
  }
}

/**
 * Test that an account can be created with a valid account number
 * but not with a invalid account number
 * and that methods work
 * 
 * Print your bank account object whenever you change something (deposit or
 * withdraw)
 * 
 * Catch any exceptions that you methods throw and use System.err.println() and
 * System.err.flush() to flush the error stream buffer (this will be explained
 * in lab)
 */

class Test {
  public static void main(String[] args) throws BankException {
    try {
      BankAccount bankAccount = new BankAccount("GB821234", 10.10);
      System.out.println("New valid bank account with initial account balance of " + bankAccount.balance());
      bankAccount.print();
      bankAccount.deposit(100);
      bankAccount.print();
      bankAccount.withdraw(50);
      bankAccount.print();
      bankAccount.withdraw(100);
      System.err.flush();

      // exceptions for negative amounts don't have to be tested as code handles it
      // already from looking at it

      BankAccount invalidBankAccount = new BankAccount("CA123456", 10.10);
      invalidBankAccount.deposit(-11);

    } catch (BankException e) {
      System.err.println(e.getMessage());
      System.err.flush();
    } catch (Exception e) {
      System.err.println("A exception has been called");
      System.err.flush();
    }
  }
}

interface Ansi {
  String RESET = "\033[0m";
  String CC = "\033[2J"; // clear console
  String RED = "\033[22;31m";
  String GREEN = "\033[1;32m";
  String YELLOW = "\033[1;33m";
  String BLUE = "\033[22;34m";
  String PURPLE = "\033[1;35m";
  String WHITE = "\033[1;37m";
}