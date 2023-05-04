package ru.nvn.sprint_6;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class F {
  static class Edge {
    int to, weight;

    Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  static class Pair implements Comparable<Pair> {
    int vertex, distance;

    Pair(int vertex, int distance) {
      this.vertex = vertex;
      this.distance = distance;
    }

    @Override
    public int compareTo(Pair other) {
      return Integer.compare(distance, other.distance);
    }
  }

  static Edge[][] graph;
  static int[] distances;

  static void dijkstra(int start) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.offer(new Pair(start, 0));
    distances[start] = 0;

    while (!pq.isEmpty()) {
      Pair top = pq.poll();
      int vertex = top.vertex;
      int distance = top.distance;

      if (distance > distances[vertex]) {
        continue;
      }

      for (Edge neighbor : graph[vertex]) {
        int newDistance = distances[vertex] + neighbor.weight;
        if (newDistance < distances[neighbor.to]) {
          distances[neighbor.to] = newDistance;
          pq.offer(new Pair(neighbor.to, newDistance));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] parts = br.readLine().split(" ");
    int n = Integer.parseInt(parts[0]);
    int m = Integer.parseInt(parts[1]);

    graph = new Edge[n][];
    distances = new int[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new Edge[0];
      distances[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < m; i++) {
      parts = br.readLine().split(" ");
      int u = Integer.parseInt(parts[0]) - 1;
      int v = Integer.parseInt(parts[1]) - 1;
      int weight = 1;

      graph[u] = Arrays.copyOf(graph[u], graph[u].length + 1);
      graph[u][graph[u].length - 1] = new Edge(v, weight);

      graph[v] = Arrays.copyOf(graph[v], graph[v].length + 1);
      graph[v][graph[v].length - 1] = new Edge(u, weight);
    }

    parts = br.readLine().split(" ");
    int start = Integer.parseInt(parts[0]) - 1;
    int end = Integer.parseInt(parts[1]) - 1;

    dijkstra(start);

    if (distances[end] == Integer.MAX_VALUE) {
      bw.write("-1");
    } else {
      bw.write(Integer.toString(distances[end]));
    }
    bw.newLine();

    bw.flush();
  }
}
