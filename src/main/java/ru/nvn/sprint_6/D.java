package ru.nvn.sprint_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class D {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Читаем количество вершин и рёбер
    String[] parts = reader.readLine().split(" ");
    int n = Integer.parseInt(parts[0]);
    int m = Integer.parseInt(parts[1]);

    // Создаём список смежности для графа
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    // Читаем рёбра графа и заполняем список смежности
    for (int i = 0; i < m; i++) {
      parts = reader.readLine().split(" ");
      int u = Integer.parseInt(parts[0]) - 1;
      int v = Integer.parseInt(parts[1]) - 1;
      adj[u].add(v);
      adj[v].add(u);
    }

    // Читаем номер стартовой вершины
    int s = Integer.parseInt(reader.readLine()) - 1;

    // Обходим граф в ширину, начиная с вершины s
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    visited[s] = true;
    while (!queue.isEmpty()) {
      int u = queue.poll();
      System.out.print((u+1) + " ");
      Collections.sort(adj[u]);
      for (int v : adj[u]) {
        if (!visited[v]) {
          queue.add(v);
          visited[v] = true;
        }
      }
    }
  }
}
