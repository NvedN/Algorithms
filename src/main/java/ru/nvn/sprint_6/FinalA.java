// https://contest.yandex.ru/contest/25070/run-report/86824100/

package ru.nvn.sprint_6;

import java.io.*;
import java.util.*;

public class FinalA {

  /**
   * -- ПРИНЦИП РАБОТЫ -- Данная задача решена с помощью алгоритма Крускала. Алгоритм Крускала
   * предназначен для построения минимального остовного дерева в неориентированном взвешенном графе.
   * Он основан на жадной стратегии, которая заключается в том, чтобы каждый раз выбирать ребро
   * минимального веса, которое не образует цикл с уже выбранными ребрами. Для этого в начале
   * сортируются все ребра по весу, затем перебираются в порядке возрастания и добавляются в
   * остовное дерево, если они не образуют цикла с уже добавленными ребрами.
   *
   * <p>В данной задаче, поскольку граф не содержит особенностей, алгоритм Крускала - это простой и
   * эффективный выбор для нахождения максимального остовного дерева.
   * https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- Алгоритм Крускала гарантирует построение минимального
   * остовного дерева, так как на каждом шаге он выбирает ребро минимального веса, которое не
   * образует цикла с уже выбранными ребрами. Таким образом, алгоритм не учитывает петли и кратные
   * ребра, что может привести к построению неверного дерева. Однако, в данной задаче необходимо
   * найти максимальное остовное дерево, поэтому нужно модифицировать алгоритм следующим образом:
   * вместо сортировки ребер по возрастанию веса, их необходимо отсортировать по убыванию. В таком
   * случае, при выборе ребра мы будем добавлять в остовное дерево максимально возможное ребро,
   * которое не образует цикла с уже выбранными ребрами.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- Считывание входных данных занимает O(1) времени. Создание списка
   * ребер занимает O(m) времени. Сортировка списка ребер занимает O(m log m) времени. Проход по
   * списку ребер и выполнение объединения компонент занимает O(m * α(n)) времени, где α(n) -
   * обратная функция Аккермана, а значит, практически константа. В итоге, временная сложность
   * алгоритма Крускала составляет O(m log n), где m - количество ребер, а n - количество вершин в графе.
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- Алгоритм использует O(m) дополнительной памяти для хранения
   * списка ребер и массива parent, а также O(1) дополнительной памяти для переменных и счетчиков. В
   * итоге, пространственная сложность алгоритма составляет O(m).
   */
  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
      StringTokenizer st = new StringTokenizer(reader.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      List<Edge> edges = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(reader.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        edges.add(new Edge(u, v, w));
      }

      int maxWeight = findMaxWeight(n, edges);
      if (maxWeight == -1) {
        writer.write("Oops! L did it again");
      } else {
        writer.write(String.format("%d", maxWeight));
      }
    }
  }

  private static int findMaxWeight(int n, List<Edge> edges) {
    int[] parent = new int[n + 1];
    Arrays.fill(parent, -1);

    edges.sort(Comparator.comparingInt(Edge::getWeight).reversed());

    int totalWeight = 0;
    int numComponents = n;
    for (Edge edge : edges) {
      int u = edge.getU();
      int v = edge.getV();
      int w = edge.getWeight();

      int pu = find(parent, u);
      int pv = find(parent, v);

      if (pu != pv) {
        parent[pu] = pv;
        totalWeight += w;
        numComponents--;

        if (numComponents == 1) {
          break;
        }
      }
    }

    return numComponents == 1 ? totalWeight : -1;
  }

  private static int find(int[] parent, int u) {
    if (parent[u] == -1) {
      return u;
    }
    parent[u] = find(parent, parent[u]);
    return parent[u];
  }

  private static class Edge {
    private final int u;
    private final int v;
    private final int weight;

    public Edge(int u, int v, int weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
    }

    public int getU() {
      return u;
    }

    public int getV() {
      return v;
    }

    public int getWeight() {
      return weight;
    }
  }
}
