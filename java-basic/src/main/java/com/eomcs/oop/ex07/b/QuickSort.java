package com.eomcs.oop.ex07.b;

public class QuickSort {

  int partition(int[] arr, int low, int high)
  {
    int pivot = arr[high];
    int i = (low-1); // index of smaller element
    for (int j=low; j<high; j++)
    {
      // If current element is smaller than or
      // equal to pivot
      if (arr[j] <= pivot)
      {
        i++;

        // swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // swap arr[i+1] and arr[high] (or pivot)
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;

    return i+1;
  }

  public void start(int[] arr, int low, int high) { // 배열, 가장 낮은 수, 가장 높은 수 -> 인덱스 지정해서 돌리기
    if (low < high)
    {
      /* pi is partitioning index, arr[pi] is
          now at right place */
      int pi = partition(arr, low, high);

      // Recursively sort elements before
      // partition and after partition
      start(arr, low, pi-1);
      start(arr, pi+1, high);
    }
  }
}

// 쭉 가다가 작은 수를 만나면 앞으로 당겨서 순서를 바꾼다
// 작은 수를 앞으로 보냄
// bubbleSoft보다 속도가 빠름

// visualgo.net/en 참고하기
