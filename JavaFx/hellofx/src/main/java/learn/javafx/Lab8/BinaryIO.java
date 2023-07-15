package learn.javafx.Lab8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * Write a program (does not have to be GUI) that stores a Date object for the
 * current time,
 * the double value 2.5, and an array of five int values 1, 2, 3, 4, and 5,
 * into a binary file (not text file) named file1.dat.
 * Then provide code to read and display all the data stored in the file.
 */

public class BinaryIO {
  static String file = "file1.dat";

  public static void main(String[] args) {
    ReadWrite();
  }

  public static void ReadWrite() {
    try {
      try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file)))
      {
        Date date = new Date();
        output.writeObject(date);
        output.writeDouble(2.5);
        output.writeObject(new int[] {1, 2, 3,4,5});
      }
    
      try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
        Date d = (Date)input.readObject();
          System.out.println(d);
          System.out.println(input.readDouble());
        int[] ints = (int[]) input.readObject();
          System.out.println(Arrays.toString(ints));
      }
    } catch (ClassNotFoundException ex) {
      System.out.println("class not found exception");
    } catch (EOFException ex) {
      System.out.println("All data were read");
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      System.out.println("End of Binary IO Operations");
    }
  }
}
