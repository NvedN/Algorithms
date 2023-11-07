// https://contest.yandex.ru/contest/25597/run-report/87326794/

package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.util.Scanner;

public class FinalB {

  /**
   * -- ПРИНЦИП РАБОТЫ -- алгоритма заключается в использовании динамического программирования.
   *
   * <p>Алгоритм решает задачу в два этапа. На первом этапе вычисляется сумма всех элементов в
   * массиве points, и если она нечетная, то решение задачи невозможно, и метод isSameAmounts
   * возвращает false. Иначе, на втором этапе строится таблица dp размера halfSum + 1, где halfSum —
   * половина суммы элементов массива points. Эта таблица позволяет хранить информацию о возможных
   * суммах элементов подмножества, которые можно получить из заданного массива. Перед началом
   * заполнения таблицы, dp[0] устанавливается в true, поскольку пустое подмножество имеет сумму
   * равную нулю. Далее, используя циклы, каждый раз рассчитывается возможность получения текущей
   * суммы j с помощью комбинации элементов из массива points. Если элемент points[i] меньше или
   * равен текущей сумме j, то значение dp[j] устанавливается в dp[j - point] || dp[j]. Это
   * означает, что dp[j] равно true, если существует комбинация элементов в points, которая дает
   * сумму j или если значение dp[j - point] равно true. Если в результате обхода встречается
   * значение dp[halfSum] = true, то метод isSameAmounts возвращает true, иначе — false.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- данного алгоритма основывается на использовании
   * динамического программирования. Таблица dp хранит информацию о возможных суммах элементов
   * подмножества, которые можно получить из заданного массива. Каждый элемент в dp имеет два
   * возможных состояния — true или false, которые соответствуют тому, может ли данный элемент быть
   * получен из элементов массива points или нет. Значение dp[halfSum] будет равно true, если
   * существует подмножество элементов из points, которые имеют сумму, равную половине суммы всех
   * элементов points.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- алгоритма составляет O(n*s), где n — размер массива points, а s -
   * размер суммы. Это объясняется двойным циклом, используемым для заполнения таблицы dp
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- алгоритма составляет O(s), так как используется один массив
   * dp размера halfSum+1.
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] points = new int[n];
    for (int i = 0; i < n; i++) {
      points[i] = input.nextInt();
    }
    boolean result = isSameAmounts(points);
    System.out.println(result ? "True" : "False");
  }

  public static boolean isSameAmounts(int[] points) {
    int sumPoints = 0;
    for (int point : points) {
      sumPoints += point;
    }
    if (sumPoints % 2 != 0) {
      return false;
    }

    int halfSum = sumPoints / 2;
    boolean[] dp = new boolean[halfSum + 1];
    dp[0] = true;
    for (int point : points) {
      for (int j = halfSum; j >= point; j--) {
        dp[j] = dp[j - point] || dp[j];
        if (j == halfSum && dp[j]) {
          return true;
        }
      }
    }
    return dp[halfSum];
  }
}
