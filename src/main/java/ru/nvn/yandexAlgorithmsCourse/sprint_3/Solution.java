// https://contest.yandex.ru/contest/23815/run-report/83356559/

package ru.nvn.yandexAlgorithmsCourse.sprint_3;

public class Solution {

  /**
   * -- ПРИНЦИП РАБОТЫ --
   *
   * <p>Данный алгоритм основан на модификации бинарного поиска. Идея заключается в том, чтобы на
   * каждом шаге проверять, в какой половине массива находится искомый элемент. 1.Находим середину
   * массива. Если элемент в середине массива равен искомому, возвращаем его индекс. 2.Если элемент
   * в середине массива меньше искомого, то либо левая, либо правая половина массива содержит набор
   * элементов, которые могут содержать искомый элемент. Мы сравниваем элемент в середине массива со
   * значением левого конца, чтобы определить, содержится ли искомый элемент в левой половине. Если
   * да, то выполняем поиск в левой половине массива, иначе - в правой половине массива. 3.Если
   * элемент в середине массива больше искомого, то аналогично п.2 выполняем поиск в левой или
   * правой половине массива.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
   *
   * <p>После каждой итерации поиска длина оставшейся части массива уменьшается в два раза. Таким
   * образом, алгоритм закончит работу после log2(n) итераций, где n - длина исходного массива. В
   * каждой итерации алгоритм делает одно сравнение, поэтому общая временная сложность алгоритма
   * составляет O(log n).
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
   *
   * <p>Временная сложность алгоритма показывает, что алгоритм действительно находит элемент за
   * логарифмическое время.
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
   *
   * <p>Пространственная сложность алгоритма равна O(1), так как в ходе алгоритма мы не создаем
   * дополнительных структур данных и используем только константное количество переменных.
   */
  public static int brokenSearch(int[] arr, int k) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (arr[mid] == k) {
        return mid;
      }

      if (arr[left] <= arr[mid]) {
        if (k >= arr[left] && k < arr[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (k > arr[mid] && k <= arr[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }

  private static void test() {
    int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
    assert 6 == brokenSearch(arr, 5);
  }
}
