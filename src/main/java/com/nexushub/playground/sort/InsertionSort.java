package com.nexushub.playground.sort;

public class InsertionSort implements Sort {
  @Override
  public long[] sort(long[] arr) {
    for (int i = 1; i < arr.length; i++) {
      long current = arr[i];
      int shift;
      for (shift = i - 1; shift >= 0 && current < arr[shift]; shift--) {
        arr[shift + 1] = arr[shift];
      }
      arr[shift + 1] = current;
    }

    return arr;
  }
}
