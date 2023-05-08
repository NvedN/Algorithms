//https://contest.yandex.ru/contest/25070/run-report/87060520/

package ru.nvn.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FinalB {

  /**
   * -- ПРИНЦИП РАБОТЫ -- алгоритма заключается в определении наличия цикла в неориентированном
   * графе, заданном списком смежности. Для этого используется поиск в глубину (DFS). Алгоритм
   * построен следующим образом: для каждой вершины запускается процедура DFS, которая проходит по
   * всем смежным вершинам, помечает текущую вершину серым цветом и добавляет ее в стек. Если в
   * процессе обхода нашли серую вершину, то обнаружен цикл, и алгоритм возвращает True. Если же все
   * смежные вершины уже были обработаны и нет серых вершин, то вершина помечается черным цветом и
   * из стека ее можно удалить. Если все вершины были пройдены и цикл не найден, то алгоритм
   * возвращает False.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- Пусть цикл есть в графе. При обходе графа DFS зайдет в
   * некоторую вершину, из которой есть путь в одну из уже помеченных серой вершину. Тогда DFS
   * зайдет в эту серую вершину еще раз, обнаружив цикл и возвращая True.
   *
   * <p>Пусть цикла в графе нет. Тогда в процессе обхода графа вершины становятся серыми, но из
   * каждой вершины можно уйти только в вершины, которые еще не помечены серым цветом, таким образом
   * серые вершины образуют только дерево. По завершению обхода графа все вершины становятся
   * черными, и DFS заканчивает работу, возвращая False.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- O(V+E), где V - количество вершин, E - количество ребер в графе.
   * Поскольку алгоритм посещает каждую вершину и ребро ровно один раз.
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --O(V+E), так как используется массив цветов для вершин, стек
   * и списки смежности.
   */
  private enum Color {
    WHITE, GRAY, BLACK;
  }

  private static final char WIDE_ROAD = 'B';
  private static final char NARROW_ROAD = 'R';

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine().trim());

    List<List<Integer>> adjacency = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjacency.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      String line = reader.readLine().trim();
      for (int j = 0; j < line.length(); j++) {
        char typeRoad = line.charAt(j);
        if (typeRoad == WIDE_ROAD) {
          adjacency.get(i).add(i + j + 1);
        } else if (typeRoad == NARROW_ROAD) {
          adjacency.get(i + j + 1).add(i);
        }
      }
    }

    System.out.println(isCyclic(adjacency) ? "NO" : "YES");
  }

  private static boolean isCyclic(List<List<Integer>> adjacency) {
    Color[] colors = new Color[adjacency.size()];
    for (int i = 0; i < adjacency.size(); i++) {
      if (colors[i] == null) {
        if (dfsIsCyclic(i, adjacency, colors)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean dfsIsCyclic(int startVertex, List<List<Integer>> adjacency, Color[] colors) {
    Stack<Integer> stack = new Stack<>();
    stack.push(startVertex);

    while (!stack.empty()) {
      int v = stack.pop();
      if (colors[v] == null) {
        colors[v] = Color.GRAY;
        stack.push(v);

        for (int w : adjacency.get(v)) {
          if (colors[w] == null) {
            stack.push(w);
          } else if (colors[w] == Color.GRAY) {
            return true;
          }
        }
      } else if (colors[v] == Color.GRAY) {
        colors[v] = Color.BLACK;
      }
    }

    return false;
  }
}
