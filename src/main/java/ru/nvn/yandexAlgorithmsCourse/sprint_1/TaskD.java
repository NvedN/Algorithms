package ru.nvn.yandexAlgorithmsCourse.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskD {

  public static void main(String[] args) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    try {
//      String[] s2 = s.split(" ");
      int temperature = readInt(bufferedReader);
      List<Integer> temperatureList = readList(bufferedReader);

      System.out.println(calculateRandomWeather(temperatureList, temperature));

    } catch (
        IOException e) {
      e.printStackTrace();
    }

  }

  public static Integer calculateRandomWeather(List<Integer> temperatureList, Integer temperature) {
    int result = 0;
    if (temperatureList.size() == 1) {
      result++;
      return result;
    }
    if (temperatureList.get(0) > temperatureList.get(1)) {
      result++;
    }

    if (temperatureList.get(temperatureList.size() - 1) > temperatureList.get(
        temperatureList.size() - 2)) {
      result++;
    }
    ;

    for (int i = 1; i < temperatureList.size() - 1; i++) {
      if (temperatureList.get(i - 1) < temperatureList.get(i) &&
          temperatureList.get(i) > temperatureList.get(i + 1)) {
        result++;
      }
    }

    return result;
  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

  private static List<Integer> readList(BufferedReader reader) throws IOException {
    return Arrays.asList(reader.readLine().split(" "))
        .stream()
        .map(elem -> Integer.parseInt(elem))
        .collect(Collectors.toList());
  }


}
