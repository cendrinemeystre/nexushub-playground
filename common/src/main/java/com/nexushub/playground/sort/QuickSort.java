package com.nexushub.playground.sort;

import java.util.Random;

public class QuickSort implements Sort {
  @Override
  public long[] sort(long[] arr) {
    Random random = new Random();
    int key = random.nextInt(0, arr.length);
    for (int i = key; i < arr.length; i++) {
      while (arr[i + 1] > arr[key]) {
        
      }
    }

    return arr;
  }
}
