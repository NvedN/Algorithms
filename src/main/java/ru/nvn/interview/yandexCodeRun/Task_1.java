package ru.nvn.interview.yandexCodeRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task_1 {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = readInt(reader);
      List<Integer> numbers = readList(reader);
      System.out.println(test(n, numbers));
    }
  }

  private static int test(Integer n, List<Integer> lst) {
    Collections.sort(lst);
    int[] d = new int[n];
    d[1] = lst.get(1) - lst.get(0);
    if (n > 2) {
      d[2] = lst.get(2) - lst.get(0);

      for (int i = 3; i < n; i++) {
        d[i] = Math.min(d[i - 2], d[i - 1]) + lst.get(i) - lst.get(i - 1);
      }
    }
    return d[n - 1];
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
