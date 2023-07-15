package datastructures.Labs.Lab5;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 5
 * @class ListArray
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question The Array-Based List
 */

public class ADTList {
  private String[] arr = new String[0];
  private int size = 0;

  ADTList(int initialSpaces) throws ListException {
    this.arr = new String[initialSpaces];
    this.size = 0; // initial size

    if(initialSpaces < 0)
      throw new ListException("Initial Size of Array must be greater than zero");
  }

  public boolean isEmpty() {
    return arr.length == 0;
  }

  public int size() {
    return size;
  }

  public void add(String item, int i) throws ListException {
    if (i > size + 1 || i < 0) {
      throw new ListException("Index is out of Bounds! method: Add : " + i + " Size: " + size);
    }

    String [] oldArr = Arrays.copyOf(arr, arr.length);    
    
    if(arr[i] == null) {
      arr[i] = item;
      size += 1;
      return;
    }

    for (int index = 0; index < arr.length; index++) {
      if (i == index)
        arr[index] = item;
      else if (i < index)
        arr[index] = oldArr[index - 1];
      else
        arr[index] = oldArr[index];
    }
    size += 1;
  }

  public String remove(int i) throws ListException {
    if (i > size || i < 0) {
      throw new ListException("Index is out of Bounds! Remove : " + i + " Size: " + size);
    }
    String removedElement = arr[i];
    arr[i] = null;

    String [] oldArr = Arrays.copyOf(arr, arr.length);  

    for (int index = 0; index < arr.length; index++) {
      if (index >= i)
        arr[index] = index + 1 < arr.length ? oldArr[index + 1] : oldArr[index];
      else
        arr[index] = oldArr[index];
    }
    size -= 1;
    return removedElement;
  }

  public void removeAll() {
    arr = new String[0];
    size = 0;
  }

  public String get(int i) throws ListException {
    if (i > size || i < 0) {
      throw new ListException("Index is out of Bounds! Get : " + i + " Size: " + size);
    }
    return arr[i];
  }

  public int find(String item) {
    for (int i = 0; i < arr.length; i++) {
      if (Objects.equals(arr[i], item))
        return i;
    }
    return -1;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("");
    for (int i = 0; i < arr.length; i++) {
      str.append("arr[" + i + "] = " + arr[i] + "\n");
    }
    return str.toString();
  }

  void print() {
    System.out.println(toString());
  }

  public static void main(String[] args) throws ListException {
    ADTList arrayList = new ADTList(4);

    arrayList.add("Algoma U", 0);
    arrayList.add("COSC", 1);
    arrayList.add("Data Structures", 1);
    arrayList.add("Java", 3);
    arrayList.print();
    arrayList.remove(1);
    arrayList.remove(0);
    arrayList.print();
  }

  class ListException extends Exception {
    ListException(String message) {
      super(message);
    }
  }
}

/*
 * I wrote this by hand before I coded following instructions given
 * (1) Write the list that results from the following operations:
 * a. add(“Algoma U”, 0)
 * 
 * "Algoma U"
 * 
 * b. add(“COSC”, 1)
 * 
 * "Algoma U" --> “COSC”
 * 
 * c. add(“Data Structures”, 1)
 * 
 * "Algoma U" --> “Data Structures” --> “COSC”
 * 
 * d. add(“Java”, 3)
 * 
 * "Algoma U" --> “Data Structures” --> “COSC” --> “Java”
 * 
 * e. remove(1)
 * 
 * "Algoma U" --> “COSC” --> “Java”
 * 
 * f. remove(0)
 * 
 * “COSC” --> “Java”
 * 
 */