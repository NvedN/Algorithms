//https://contest.yandex.ru/contest/25597/run-report/87326165/

package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.util.Scanner;

public class FinalA {

  /**
   * -- ПРИНЦИП РАБОТЫ -- Алгоритм Левенштейна вычисляет минимальное количество операций (вставки,
   * удаления, замены) для превращения одной строки в другую. Для этого используется динамическое
   * программирование, где подзадачи решаются в порядке увеличения их размера. В нашем случае,
   * подзадача - вычисление расстояния Левенштейна между префиксами двух строк.
   * https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- Алгоритм Левенштейна удовлетворяет принципу оптимальной
   * подструктуры, то есть оптимальное решение задачи может быть получено из оптимальных решений её
   * подзадач. Кроме того, он учитывает все возможные варианты редактирования строк и выбирает
   * наименьший среди них. Поэтому он гарантированно вычисляет минимальное расстояние между двумя
   * строками.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- Алгоритм Левенштейна использует два цикла для перебора всех
   * префиксов первой и второй строк, и для каждого префикса вычисляет расстояние Левенштейна. Всего
   * выполняется (n + 1) * (m + 1) операций, где n и m - длины строк. Поэтому временная сложность
   * алгоритма составляет O(n * m).
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- Алгоритм Левенштейна использует два массива размером (n +
   * 1) и одномерный массив размером (n + 1) для хранения текущих и предыдущих расстояний. Поэтому
   * пространственная сложность алгоритма составляет O(n).
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String firstStr = scanner.nextLine();
    String secondStr = scanner.nextLine();
    System.out.println(levenshteinDistance(firstStr, secondStr));
  }

  public static int levenshteinDistance(String firstStr, String secondStr) {
    int n = firstStr.length();
    int m = secondStr.length();
    if (n > m) {
      String temp = firstStr;
      firstStr = secondStr;
      secondStr = temp;
      n = firstStr.length();
      m = secondStr.length();
    }

    int[] current = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      current[i] = i;
    }
    for (int i = 1; i <= m; i++) {
      int[] previous = current;
      current = new int[n + 1];
      current[0] = i;
      for (int j = 1; j <= n; j++) {
        int insertCost = previous[j] + 1;
        int deleteCost = current[j - 1] + 1;
        int replaceCost =
                previous[j - 1] + (firstStr.charAt(j - 1) == secondStr.charAt(i - 1) ? 0 : 1);
        current[j] = Math.min(Math.min(insertCost, deleteCost), replaceCost);
      }
    }
    return current[n];
  }
}
