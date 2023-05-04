package ru.nvn.sprint_6;

import java.io.*;
import java.util.*;

public class E {
  static int n, m;
  static List<Integer>[] adj;
  static boolean[] visited;
  static List<List<Integer>> components = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    adj = new List[n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      String[] line = br.readLine().split(" ");
      int u = Integer.parseInt(line[0]) - 1;
      int v = Integer.parseInt(line[1]) - 1;
      adj[u].add(v);
      adj[v].add(u);
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        List<Integer> component = new ArrayList<>();
        dfs(i, component);
        Collections.sort(component);
        components.add(component);
      }
    }

    components.sort(Comparator.comparingInt(o -> o.get(0)));

    bw.write(components.size() + "\n");
    for (List<Integer> component : components) {
      for (int vertex : component) {
        bw.write((vertex + 1) + " ");
      }
      bw.write("\n");
    }
    bw.flush();
  }

  static void dfs(int u, List<Integer> component) {
    visited[u] = true;
    component.add(u);

    for (int v : adj[u]) {
      if (!visited[v]) {
        dfs(v, component);
      }
    }
  }
}
