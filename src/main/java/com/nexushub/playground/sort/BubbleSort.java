package com.nexushub.playground.sort;

public class BubbleSort implements Sort {
  @Override
  public long[] sort(long[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] > arr[i]) {
        long original = arr[i - 1];
        arr[i - 1] = arr[i];
        arr[i] = original;
      }
    }
    return arr;
  }
}
