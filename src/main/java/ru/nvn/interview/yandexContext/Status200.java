package ru.nvn.interview.yandexContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Status200 {

  private static long getNumberOfGoodPairs(int n, List<Integer> numbers) {
    int[] countMod200 = new int[200];

    // Подсчитываем количество чисел для каждого остатка при делении на 200.
    for (int number : numbers) {
      countMod200[number % 200]++;
    }
    // Посчитаем количество комбинаций для каждого остатка используя формулу: n * (n - 1) / 2
    long pairCount = 0;
    for (int j : countMod200) {
      pairCount += (long) j * (j - 1) / 2;
    }

    return pairCount;
  }

  private static long getNumberOfGoodPairs2(int n, List<Integer> numbers) {
    int pairCount = 0;
    for (int i = 0 ; i < numbers.size(); i ++){
      int firstPair = numbers.get(i);
      for (int k = 1 ; k < numbers.size();k++){
        int secondPair = numbers.get(k);
        if (firstPair < secondPair && ((firstPair - secondPair)%200 == 0)){
          pairCount++;
        }
      }
    }
    return pairCount;
  }

  public static boolean formula(int firstPair, int secondPair) {
    System.out.println("----Formula");
    int test = (firstPair - secondPair) % 200;
    System.out.println("----------test = " + test);
    return (firstPair - secondPair) % 200 == 0;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = readInt(reader);
      List<Integer> numbers = readList(reader);
      System.out.println(getNumberOfGoodPairs(n, numbers));
    }
  }

  private static List<Integer> readList(BufferedReader reader) throws IOException {
    return Arrays.stream(reader.readLine().strip().split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  private static int readInt(BufferedReader reader) throws NumberFormatException, IOException {
    return Integer.parseInt(reader.readLine());
  }
}
