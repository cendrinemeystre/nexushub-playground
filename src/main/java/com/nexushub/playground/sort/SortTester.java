package com.nexushub.playground.sort;

import java.util.List;
import java.util.Random;

public class SortTester {
  private static final Random random = new Random();

  private static final Stopwatch stopwatch = new Stopwatch();

  private static final int ARR_SIZE = 5000;

  private static final int ARR_BOUND = 1000;

  public static void main(String[] args) {
    List<Sort> sortList = List.of(
      new BubbleSort(),
      new SelectionSort(),
      new InsertionSort()
    );
    sortList.forEach(SortTester::runSort);
  }

  private static void runSort(Sort sortAlgorithm) {
    long[] arr = createRandomArray();
//    printArr(arr);
    stopwatch.start();
    long[] sorted = sortAlgorithm.sort(arr);
    stopwatch.stop();
    printArr(sorted);
    System.out.println("Time: " + stopwatch.getElapsedTimeMillis());
  }

  private static long[] createRandomArray() {
    long[] arr = new long[ARR_SIZE];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextLong(0, ARR_BOUND);
    }
    return arr;
  }

  private static void printArr(long[] arr) {
    for (long l : arr) {
      System.out.print(l + ",");
    }
    System.out.println();
  }
}
