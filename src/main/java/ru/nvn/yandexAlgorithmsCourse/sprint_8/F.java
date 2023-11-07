package ru.nvn.yandexAlgorithmsCourse.sprint_8;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class F {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    Map<String, Integer> frequencies = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String word = reader.readLine();
      frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
    }

    List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencies.entrySet());
    entries.sort(
        (a, b) -> {
          if (a.getValue().equals(b.getValue())) {
            return a.getKey().compareTo(b.getKey());
          }
          return b.getValue() - a.getValue();
        });

    writer.write(entries.get(0).getKey() + "\n");
    writer.flush();
  }
}
