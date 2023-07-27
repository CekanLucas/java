package datastructures.Labs.Lab10;

import java.util.Arrays;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @Lab 10 - Sorting and Searching
 * @class ReferenceQueue
 * @Disclaimer Any and all work in this file is my own except otherwise
 *             specified ie the questions
 * @Question Sorting and searching
 * @PseudoCode
 * 
 *             <pre>

Input: A[0..n-1], the array and k, a key to search for
Output: the index of the item in the array, if it exists, or -1 otherwise.
ALGORITHM SequentialSearch(A[0..n-1], k)
for i <- 0 to n - 1:
if A[i] == k return i
else i <- i + 1
end if
end for
return -1

Input: A[0..n-1], the array, sorted in ascending order, start, the index of the starting point of the search, end, the index of the end point of the search, and k, the key to search for
Output: the index of the item in the array, if it exists, or -1 otherwise
ALGORITHM BinarySearch(A[0..n-1], start, end, k)
  if start < 0 or start >= n or end < 0 or end >= n or start >= end return -1
  else
    mid = (start + end) / 2
    if A[mid] == k return mid;
    else if k < A[mid] return BinarySearch(A[0..n-1], start, mid - 1, k)
    else if k > A[mid] return BinarySearch(A[0..n-1], mid + 1, end, k)
    end if
  end if 

Input:  A[0..n-1], the array
Output: A[0..n-1], sorted in ascending order

ALGORITHM BubbleSort(A[0..n-1])
  for i <- 0 to n - 1
    for j <- 0 to n - 1
      if A[j] > A[j + 1] swap(A[j], A[j +1])
      end if
  end for
end for

Input: A[0..n-1], the array to sort
Output: A[0..n-1], sorted in ascending order
ALGORITHM MergeSort(A[0..n-1])
  if(n == 1) return;
  else
      mid <- n / 2
      B = A[0..mid], C = A[mid + 1..n-1]
      B = MergeSort(B)
      C = MergeSort(C)
      A = merge(B, C)
  end if

Input: A[0..x - 1] and B[0..y - 1], the arrays to merge
Output: C[0..x + y - 1], the merged arrays, sorted in ascending order
ALGORITHM merge(A[0..x-1], B[0..y-1])
            result[0..x+y-1] = new array
            aPos <- 0, bPos <- 0, i <- 0
            while aPos < x and bPos < y:
              if A[aPos] < B[bPos]:
              result[i] <- A[aPos]
              i <- i + 1
              aPos <- aPos + 1
              else:
              result[i] <- B[bPos]
              i <- i + 1
              bPos <- bPos + 1
              end if
            end while
          
            while aPos < x:
              result[i] <- A[aPos]
              i <- i + 1
              aPos <- aPos + 1
            end while
          
            while bPos < y:
              result[i] <- B[bPos]
              i <- i + 1
              bPos <- bPos + 1
            end while
  return result[0..x+y-1]
 *             </pre>
 */
public class SearchingAndSorting {
  int[] array = { 10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45 };

  SearchingAndSorting(int[] array) {
    this.array = Arrays.copyOf(array, array.length);
  }

  int sequentialSearch(int[] arr, int num) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        return i;
      }
    }
    return -1;
  }

  int binarySearch(int[] arr, int searchNum, int startIndex, int endIndex) {
    int midIndex = (int) Math.floor((startIndex + endIndex) / 2.0);
    int midNum = arr[midIndex];

    if (midNum == searchNum)
      return midIndex;
    else if (endIndex - startIndex == 1) {
      if (arr[startIndex] == searchNum)
        return startIndex;
      else if (arr[endIndex] == searchNum)
        return endIndex;
      else
        return -1;
    } else if (endIndex == startIndex)
      return arr[endIndex] == searchNum ? endIndex : -1;

    return searchNum < midNum ? binarySearch(arr, searchNum, startIndex, midIndex)
        : binarySearch(arr, searchNum, midIndex, endIndex);

  }

  int[] bubbleSort(int[] arr) {

    boolean isSorted = true;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        // swap values
        int num1 = arr[i];
        int num2 = arr[i + 1];
        arr[i] = num2;
        arr[i + 1] = num1;
        isSorted = false;
      }
    }
    // if pass through array without swapping then sort complete else recursively
    // sort array again in line with the bubble sort algorithm
    return isSorted ? arr : bubbleSort(arr);
  }

  int[] mergeSort(int[] arr) {

    int n = arr.length;

    if (n <= 1)
      return arr;

    int mid = n / 2;

    int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
    int[] rightArr = Arrays.copyOfRange(arr, mid, n);

    leftArr = mergeSort(leftArr);
    rightArr = mergeSort(rightArr);

    return merge(leftArr, rightArr);
  }

  int[] merge(int[] leftArr, int[] rightArr) {

    int i = 0;
    int j = 0;
    int k = 0;

    int lLen = leftArr.length;
    int rLen = rightArr.length;

    int[] merged = new int[lLen + rLen];

    while (i < lLen && j < rLen) {
      if (leftArr[i] <= rightArr[j])
        merged[k] = leftArr[i++];
      else
        merged[k] = rightArr[j++];

      k++;
    }

    while (i < lLen)
      merged[k++] = leftArr[i++];

    while (j < rLen)
      merged[k++] = rightArr[j++];

    return merged;
  }

  /**
   * @example
   * 
   *          <pre>
   initial Array:  29 10 14 37 13 => max 37
   After 1st Swap: 29 10 14 13 37 => max 29
   After 2nd Swap: 13 10 14 29 37 => max 14
   After 3rd Swap: 10 13 14 29 37 => max 13
   *          </pre>
   */
  int[] selectionSort(int[] arr) {
    // every run you find the max and add max to end, n times
    int lastIndex = arr.length - 1;

    while (lastIndex >= 0) {
      int maxIndex = 0;
      for (int i = lastIndex; i >= 0; i--) {
        if (arr[maxIndex] < arr[i])
          maxIndex = i;
      }

      // swap
      int temp = arr[lastIndex];
      arr[lastIndex] = arr[maxIndex];
      arr[maxIndex] = temp;

      lastIndex--;
    }

    return arr;
  }

  int[] quickSort(int[] arr) {
    int length = arr.length;
    // recursive exit conditions
    if (length <= 1)
      return arr;

    // PARTITION ARRAY AROUND PIVOT
    // Selecting Pivot Strategy middle
    int pivotIndex = (int) Math.floor(arr.length / 2.0);
    int pivot = arr[pivotIndex];
    int last = arr.length - 1;
    int first = 0;

    int[] partition = new int[length];
    for (int i = 0; i < length; i++) {
      if (arr[i] < pivot) {
        partition[first++] = arr[i];
      } else {
        if (i != pivotIndex) // skip pivot
          partition[last--] = arr[i];
      }
    }

    // finally add pivot to array
    pivotIndex = first;
    partition[pivotIndex] = pivot; 

    return combineSortedArrays(partition, pivot, pivotIndex);
  }

  int[] combineSortedArrays(int[] partition, int pivot, int pivotIndex) {
    int length = partition.length;
    // don't include pivot in partition since it is already sorted
    int[] leftArr = Arrays.copyOfRange(partition, 0, pivotIndex);
    int[] rightArr = Arrays.copyOfRange(partition, pivotIndex + 1, length);
    int[] sortedLeftArr = quickSort(leftArr);
    int[] sortedRightArr = quickSort(rightArr);

    int[] sortedArr = new int[length];
    for (int i = 0; i < length; i++) {
      if (i < leftArr.length) {
        sortedArr[i] = sortedLeftArr[i];
      } else {
        if(i == pivotIndex) {
          sortedArr[i] = pivot;
        } else 
          sortedArr[i] = sortedRightArr[i - 1 - leftArr.length];
      }
    }
    return sortedArr;
  }

  public static void main(String[] args) {
    int[] originalArray = { 10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45 };
    SearchingAndSorting ss = new SearchingAndSorting(originalArray);

    int[] sorted = ss.bubbleSort(Arrays.copyOf(originalArray, originalArray.length));
    System.out.println(Arrays.toString(originalArray) +
        "\nBubble Sort:\n" + Arrays.toString(sorted) +
        "\nSequential Search 9:\t" + ss.sequentialSearch(sorted, 9) + // => should be 8
        "\nSequential Search 3:\t" + ss.sequentialSearch(sorted, 3) + // => should be -1
        "\nBinary Search 20:\t" + ss.binarySearch(sorted, 20, 0, originalArray.length - 1) + // => should be 9
        "\nBinary Search 3:\t" + ss.binarySearch(sorted, 3, 0, originalArray.length - 1) + "\n" // => should be -1
    );

    sorted = ss.mergeSort(Arrays.copyOf(originalArray, originalArray.length));
    System.out.println(Arrays.toString(originalArray) +
        "\nMerge Sort:\n" + Arrays.toString(sorted) +
        "\nSequential Search 14:\t" + ss.sequentialSearch(sorted, 14) +
        "\nSequential Search 1:\t" + ss.sequentialSearch(sorted, 1) +
        "\nBinary Search 20:\t" + ss.binarySearch(sorted, 20, 0, originalArray.length - 1) +
        "\nBinary Search 7:\t" + ss.binarySearch(sorted, 7, 0, originalArray.length - 1) + "\n");

    int[] selectionArr = { 29, 10, 14, 37, 13 };
    sorted = ss.selectionSort(Arrays.copyOf(selectionArr, selectionArr.length));
    System.out.println(Arrays.toString(selectionArr) +
        "\nSelection Sort:\n" + Arrays.toString(sorted) +
        "\nSequential Search 14:\t" + ss.sequentialSearch(sorted, 14) +
        "\nSequential Search 7:\t" + ss.sequentialSearch(sorted, 7) +
        "\nBinary Search 14:\t" + ss.binarySearch(sorted, 14, 1, selectionArr.length - 1) +
        "\nBinary Search 7:\t" + ss.binarySearch(sorted, 7, 0, selectionArr.length - 1) + "\n");

    int[] quickArr = { 10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45 };
    sorted = ss.quickSort(Arrays.copyOf(quickArr, quickArr.length));
    System.out.println(Arrays.toString(quickArr) +
        "\nQuick Sort:\n" + Arrays.toString(sorted));
  }
}