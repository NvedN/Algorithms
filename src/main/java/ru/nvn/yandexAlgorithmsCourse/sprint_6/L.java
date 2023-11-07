package ru.nvn.yandexAlgorithmsCourse.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class L {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] input = reader.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    Set<Integer> vertices = new HashSet<>();
    Set<Integer> edges = new HashSet<>();

    for (int i = 0; i < m; i++) {
      String[] line = reader.readLine().split(" ");
      int u = Integer.parseInt(line[0]);
      int v = Integer.parseInt(line[1]);
      if (u == v) continue; // пропускаем петли

      int smaller = Math.min(u, v);
      int larger = Math.max(u, v);
      vertices.add(smaller);
      vertices.add(larger);
      edges.add(smaller * n + larger);
    }

    int maxEdges = n * (n - 1) / 2;
    if (n == 1) {
      System.out.println("YES");
    } else if (vertices.size() == n && edges.size() == maxEdges) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
