package ru.nvn.yandexAlgorithmsCourse.sprint_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class C {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static ArrayList<Integer> order;

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = reader.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      String[] uv = reader.readLine().split(" ");
      int u = Integer.parseInt(uv[0]);
      int v = Integer.parseInt(uv[1]);
      graph[u].add(v);
      graph[v].add(u);
    }

    int start = Integer.parseInt(reader.readLine());

    visited = new boolean[n + 1];
    order = new ArrayList<>();

    dfs(start);

    for (int v : order) {
      System.out.print(v + " ");
    }
  }

  public static void dfs(int v) {
    visited[v] = true;
    order.add(v);
    Collections.sort(graph[v]);
    for (int u : graph[v]) {
      if (!visited[u]) {
        dfs(u);
      }
    }
  }
}
