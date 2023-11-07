package ru.nvn.yandexAlgorithmsCourse.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(reader.readLine());
    String[] roundsStr = reader.readLine().split(" ");
    int[] rounds = new int[n];
    for (int i = 0; i < n; i++) {
      rounds[i] = Integer.parseInt(roundsStr[i]);
    }

    Map<Integer, Integer> sums = new HashMap<>();
    sums.put(0, -1);
    int sum = 0;
    int maxLength = 0;
    for (int i = 0; i < n; i++) {
      sum += (rounds[i] == 0 ? -1 : 1);
      if (sums.containsKey(sum)) {
        maxLength = Math.max(maxLength, i - sums.get(sum));
      } else {
        sums.put(sum, i);
      }
    }

    System.out.println(maxLength);
  }
}
