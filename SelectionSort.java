/**
 * Using the selection sort algorithm we would sort
 * 
 * <pre>
 * <code>{ 2, 9, 5, 4, 8, 1, 6 }</code>
 * </pre>
 * 
 * @author Lucas Cekan
 */

public class SelectionSort {
  public static int[] nums = { 2, 9, 5, 4, 8, 1, 6 };

  public static void main(String[] args) {
    selectionSort(nums);

    // Testing Array Methods
    double[] numbers = { 6.0, 4.4, 1.9, 2.9, 3.4, 3.5 };
    System.out.println("\033[1;32m" + "Before .sort or .parallelSort");
    printArr(numbers);
    System.out.println("\033[1;33m" + "After .sort or .parallelSort");
    java.util.Arrays.sort(numbers); // Sort the whole array
    printArr(numbers);
    // java.util.Arrays.parallelSort(numbers); // Sort the whole array
    // printArr(numbers);

    char[] chars = { 'a', 'A', '4', 'F', 'D', 'P' };
    System.out.println("\033[1;32m" + "Before .sort or .parallelSort");
    printArr(chars);
    java.util.Arrays.sort(chars, 1, 3); // Sort part of the array
    System.out.println("\033[1;33m" + "After .sort or .parallelSort\t\033[1;31mPart of the Array index 1 to 3");
    printArr(chars);
    // java.util.Arrays.parallelSort(chars, 1, 3); // Sort part of the array
    // printArr(chars);
  }

  public static int[] selectionSort(int[] arr) {
    System.out.println("\033[1;32m" + "Before selection sort:");
    printArr(nums);
    for (int i = 0; i < arr.length - 1; i++) {
      int[] subArray = new int[arr.length - i];
      System.arraycopy(arr, i, subArray, 0, subArray.length);
      int smallestElementIndex = findSmallestElementOfArray(subArray);
      swapElements(i, smallestElementIndex + i, arr);
    }
    System.out.println("\033[1;33m" + "After selection sort:");
    nums = arr;
    printArr(nums);
    return nums;
  }

  private static int findSmallestElementOfArray(int[] arr) {
    int smallestNum = arr[0];
    int smallestNumIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      int num = arr[i];
      if (num < smallestNum) {
        smallestNum = num;
        smallestNumIndex = i;
      }
    }
    return smallestNumIndex;
  }

  private static int[] swapElements(int index1, int index2, int[] arr) {
    int element1 = arr[index1];
    int element2 = arr[index2];
    arr[index1] = element2;
    arr[index2] = element1;
    return arr;
  }

  private static void printArr(int[] arr) {
    String str = "";
    for (int el : arr) {
      str += "\033[1;36m" + el + "\033[24;35m" + ", ";
    }
    str = "The array is { " + str + "}";
    str = str.replace(", }", " }");
    System.out.println("\033[0;35m" + str);
  }

  private static void printArr(double[] arr) {
    String str = "";
    for (double el : arr) {
      str += "\033[1;36m" + el + "\033[24;35m" + ", ";
    }
    str = "The array is { " + str + "}";
    str = str.replace(", }", " }");
    System.out.println("\033[0;35m" + str);
  }

  private static void printArr(char[] arr) {
    String str = "";
    for (char el : arr) {
      str += "\033[1;36m" + el + "\033[24;35m" + ", ";
    }
    str = "The array is { " + str + "}";
    str = str.replace(", }", " }");
    System.out.println("\033[0;35m" + str);
  }
}
