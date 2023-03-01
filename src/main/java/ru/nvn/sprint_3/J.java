package ru.nvn.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class J {

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int size = readInt(reader);
      int[] array = readArray(reader, size);
      bubbleSort(array);
    }
  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

  private static int[] readArray(BufferedReader reader, int streetLength) throws IOException {
    //    List<Integer> output = new ArrayList<>();
    int[] output = new int[streetLength];
    List<String> lineArray = List.of(reader.readLine().trim().split("\\s+"));
    for (int i = 0; i < lineArray.size() && i < streetLength; i++) {
      output[i] = (Integer.parseInt(lineArray.get(i)));
    }
    return output;
  }

  public static void bubbleSort(int[] array) {
    boolean isSorted = false;
    int iterationCount = 0;
    int n = array.length;
    while (!isSorted) {
      boolean isSwapped = false;
      isSorted = true;
      for (int i = 0; i < n - 1 - iterationCount; i++) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          isSorted = false;
          isSwapped = true;
        }
      }
      iterationCount++;
      if (isSwapped || iterationCount == 1) {
        System.out.println(
            Arrays.toString(array).replaceAll(",", "").replace("[", "").replace("]", ""));
      }
    }
  }
}
