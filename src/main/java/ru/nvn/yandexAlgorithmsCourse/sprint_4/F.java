package ru.nvn.yandexAlgorithmsCourse.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    String[] strings = reader.readLine().split(" ");

    Map<String, List<Integer>> anagramMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char[] charArray = strings[i].toCharArray();
      Arrays.sort(charArray);
      String sortedString = new String(charArray);
      List<Integer> anagramList = anagramMap.getOrDefault(sortedString, new ArrayList<>());
      anagramList.add(i);
      anagramMap.put(sortedString, anagramList);
    }

    List<List<Integer>> anagramGroups = new ArrayList<>(anagramMap.values());
    anagramGroups.sort(Comparator.comparingInt(g -> g.get(0)));

    StringBuilder sb = new StringBuilder();
    for (List<Integer> group : anagramGroups) {
      group.sort(Integer::compareTo);
      for (int index : group) {
        sb.append(index).append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
