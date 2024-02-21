package ru.nvn.interview.yandexCodeRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task_1 {

  /// 1. Средний элемент
  // легкая sort first_2023_backend

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      List<Integer> numbers = readList(reader);
      System.out.println(average(numbers));
    }
  }

  private static int average(List<Integer> lst) {
    Collections.sort(lst);
    return lst.get(1);
  }

  private static List<Integer> readList(BufferedReader reader) throws IOException {
    return Arrays.stream(reader.readLine().strip().split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
