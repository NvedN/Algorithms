package ru.nvn.yandexAlgorithmsCourse.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class A {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] line1 = reader.readLine().split(" ");
    int n = Integer.parseInt(line1[0]);
    int m = Integer.parseInt(line1[1]);
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      String[] line = reader.readLine().split(" ");
      int u = Integer.parseInt(line[0]) - 1;
      int v = Integer.parseInt(line[1]) - 1;
      adjList.get(u).add(v);
    }
    for (int i = 0; i < n; i++) {
      System.out.print(adjList.get(i).size() + " ");
      for (int j = 0; j < adjList.get(i).size(); j++) {
        System.out.print((adjList.get(i).get(j) + 1) + " ");
      }
      System.out.println();
    }
    reader.close();
  }
}
