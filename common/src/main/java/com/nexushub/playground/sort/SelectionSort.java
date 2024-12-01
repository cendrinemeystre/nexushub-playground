package com.nexushub.playground.sort;

public class SelectionSort implements Sort {
  @Override
  public long[] sort(long[] arr) {
    int sorted = 0;
    for (int i = 0; i < arr.length; i++) {
      long smallest = Long.MAX_VALUE;
      int replaceIndex = 0;
      for (int n = sorted; n < arr.length; n++) {
        if (arr[n] < smallest) {
          smallest = arr[n];
          replaceIndex = n;
        }
      }
      long original = arr[i];
      arr[i] = smallest;
      arr[replaceIndex] = original;
      sorted++;
    }
    return arr;
  }
}
