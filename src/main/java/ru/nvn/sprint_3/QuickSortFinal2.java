// https://contest.yandex.ru/contest/23815/run-report/83357719/

package ru.nvn.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSortFinal2 {

  /**
   * Данный код реализует алгоритм быстрой сортировки (QuickSort) для сортировки массива объектов
   * Contestant по заданному порядку. Contestant - это класс, который содержит поля имя, количество
   * * решенных задач и штрафное время. Сначала пользователь вводит количество участников, затем для
   * каждого участника - его имя, количество решенных задач и штрафное время.
   *
   * <p>-- ПРИНЦИП РАБОТЫ --
   *
   * <p>1.Выбирается опорный элемент из массива (pivot). 2.Остальные элементы сравниваются с опорным
   * элементом и переставляются таким образом, что все элементы меньше опорного перемещаются влево
   * от него, а все элементы больше опорного перемещаются вправо от него. 3.Опорный элемент тоже
   * перемещается на свое место в отсортированном массиве. 4.Рекурсивно повторяем шаги 1-3 для двух
   * подмассивов, созданных вокруг опорного элемента.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- Базовый случай: если массив, который нужно отсортировать,
   * содержит меньше двух элементов, то он уже отсортирован.
   *
   * <p>Для массива размером больше 1 элемента, мы выбираем опорный элемент (pivot), и перемещаем
   * все элементы, меньшие или равные опорному, в левую часть массива, а все элементы, большие
   * опорного, в правую часть. Затем мы рекурсивно применяем QuickSortFinal2 для левой и правой
   * частей массива.
   *
   * <p>При выполнении рекурсивного вызова для каждой из подмассивов гарантируется, что все
   * элементы, находящиеся левее опорного элемента, меньше или равны ему, а все элементы,
   * находящиеся правее опорного элемента, больше него. Таким образом, на каждом шаге мы разбиваем
   * массив на две части, каждая из которых уже отсортирована. Когда рекурсия закончится и будет
   * выполнен базовый случай, массив будет полностью отсортирован.
   *
   * <p>Данный алгоритм можно использовать для сортировки массивов любого размера и типа данных, при
   * условии, что определен порядок сравнения элементов. Он имеет лучшую временную сложность O(n log
   * n) и пространственную сложность O(log n) в худшем случае.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- Временная сложность алгоритма QuickSort в среднем составляет
   * O(n*log(n)), где n - размер массива. В худшем случае (когда массив уже отсортирован или
   * отсортирован в обратном порядке), временная сложность становится квадратичной, т.е. O(n^2). В
   * данном случае, поскольку в качестве опорного элемента выбирается последний элемент массива, то
   * в худшем случае временная сложность будет O(n^2).
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- Пространственная сложность данного решения составляет O(n),
   * т.е. пространство, необходимое для хранения входного массива и дополнительных переменных,
   * используемых в процессе сортировки.
   */
  static class Contestant {
    String name;
    int problemsSolved;
    int penalty;

    public Contestant(String name, int problemsSolved, int penalty) {
      this.name = name;
      this.problemsSolved = problemsSolved;
      this.penalty = penalty;
    }
  }

  static void swap(Contestant[] contestants, int i, int j) {
    Contestant tmp = contestants[i];
    contestants[i] = contestants[j];
    contestants[j] = tmp;
  }

  static int partition(Contestant[] contestants, int lo, int hi) {
    Contestant pivot = contestants[hi];
    int i = lo;
    for (int j = lo; j < hi; j++) {
      if (contestants[j].problemsSolved > pivot.problemsSolved
          || (contestants[j].problemsSolved == pivot.problemsSolved
              && contestants[j].penalty < pivot.penalty)
          || (contestants[j].problemsSolved == pivot.problemsSolved
              && contestants[j].penalty == pivot.penalty
              && contestants[j].name.compareTo(pivot.name) < 0)) {
        swap(contestants, i, j);
        i++;
      }
    }
    swap(contestants, i, hi);
    return i;
  }

  static void quicksort(Contestant[] contestants, int lo, int hi) {
    if (lo < hi) {
      int p = partition(contestants, lo, hi);
      quicksort(contestants, lo, p - 1);
      quicksort(contestants, p + 1, hi);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    Contestant[] contestants = new Contestant[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(reader.readLine());
      String name = st.nextToken();
      int problemsSolved = Integer.parseInt(st.nextToken());
      int penalty = Integer.parseInt(st.nextToken());
      contestants[i] = new Contestant(name, problemsSolved, penalty);
    }
    quicksort(contestants, 0, n - 1);
    for (int i = 0; i < n; i++) {
      System.out.println(contestants[i].name);
    }
  }
}
