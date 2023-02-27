package ru.nvn.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class L {

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = readInt(reader);
      int[] savings = readArray(reader, n);
      int bikePrice = readInt(reader);
      // # изначально мы запускаем двоичный поиск на всей длине массива

      int firstBikeDay = binarySearch(savings, bikePrice, 0, n - 1, 1);
      int secondBikeDay = binarySearch(savings, bikePrice, 0, n - 1, 2);
      System.out.println(firstBikeDay + " " + secondBikeDay);
    }
  }

  public static int binarySearch(int[] savings, int bikePrice, int left, int right, int bikes) {
    if (left > right) {
      return -1; // не нашли сумму в копилке, соответствующую цене велосипеда
    }
    int mid = (left + right) / 2;
    int sum = savings[mid];
    int numBikes = sum / bikePrice;
    if (numBikes >= bikes) {
      int prevSum = mid > 0 ? savings[mid - 1] : 0;
      int prevNumBikes = prevSum / bikePrice;
      if (prevNumBikes < bikes) {
        return mid + 1; // первый день, в который можно купить bikes велосипедов
      } else {
        return binarySearch(savings, bikePrice, left, mid - 1, bikes);
      }
    } else {
      return binarySearch(savings, bikePrice, mid + 1, right, bikes);
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
}
