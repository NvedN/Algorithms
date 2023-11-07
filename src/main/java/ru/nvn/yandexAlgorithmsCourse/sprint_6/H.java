package ru.nvn.yandexAlgorithmsCourse.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class H {
    private static int time;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] inTime;
    private static int[] outTime;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        graph = new List[n];
        visited = new boolean[n];
        inTime = new int[n];
        outTime = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            line = reader.readLine().split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int to = Integer.parseInt(line[1]) - 1;
            graph[from].add(to);
        }

        time = 0;
        dfs(0);

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " " + inTime[i] + " " + outTime[i]);
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        inTime[v] = time++;

        for (int u : graph[v]) {
            if (!visited[u]) {
                dfs(u);
            }
        }

        outTime[v] = time++;
    }
}
