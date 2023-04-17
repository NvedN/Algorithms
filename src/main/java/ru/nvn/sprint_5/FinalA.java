//https://contest.yandex.ru/contest/24810/run-report/85924450/

package ru.nvn.sprint_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FinalA {

  /**
   * -- ПРИНЦИП РАБОТЫ -- 1.Сначала производится построение неубывающей пирамиды из элементов
   * массива, начиная с последнего элемента и заканчивая первым (вниз-вверх). 2.Затем извлекается
   * максимальный элемент из пирамиды и помещается в конец массива. Затем производится
   * восстановление свойств пирамиды путем спуска элемента из вершины вниз. 3.Шаг 2 повторяется до
   * тех пор, пока пирамида не опустеет.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- 1. Построение пирамиды происходит корректно, т.к. в каждом
   * узле пирамиды находится максимум из своих потомков. 2. После извлечения максимального элемента
   * из пирамиды и его перемещения в конец массива, новая пирамида будет удовлетворять свойствам
   * неубывающей последовательности. 3. Так как каждый из n элементов массива извлекается из
   * пирамиды и переставляется в конец массива, то после n таких операций массив будет отсортирован.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- O(n log n), так как построение пирамиды занимает O(n) времени, а
   * каждое извлечение максимального элемента и восстановление свойств пирамиды занимает O(log n)
   * времени.
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- Пространственная сложность алгоритма будет O(1), так как
   * все операции производятся над исходным массивом без использования дополнительной памяти.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(reader.readLine());
    Participant[] participants = new Participant[n];
    for (int i = 0; i < n; i++) {
      String[] input = reader.readLine().split(" ");
      String login = input[0];
      int solved = Integer.parseInt(input[1]);
      int penalty = Integer.parseInt(input[2]);
      participants[i] = new Participant(login, solved, penalty);
    }

    heapSort(participants);

    for (Participant participant : participants) {
      System.out.println(participant.getLogin());
    }
  }

  private static void heapSort(Participant[] participants) {
    buildMaxHeap(participants);

    for (int i = participants.length - 1; i > 0; i--) {
      swap(participants, 0, i);
      maxHeapify(participants, 0, i);
    }
  }

  private static void buildMaxHeap(Participant[] participants) {
    for (int i = participants.length / 2 - 1; i >= 0; i--) {
      maxHeapify(participants, i, participants.length);
    }
  }

  private static void maxHeapify(Participant[] participants, int i, int heapSize) {
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    int largest = i;

    if (l < heapSize && participants[l].compareTo(participants[largest]) > 0) {
      largest = l;
    }

    if (r < heapSize && participants[r].compareTo(participants[largest]) > 0) {
      largest = r;
    }

    if (largest != i) {
      swap(participants, i, largest);
      maxHeapify(participants, largest, heapSize);
    }
  }

  private static void swap(Participant[] participants, int i, int j) {
    Participant temp = participants[i];
    participants[i] = participants[j];
    participants[j] = temp;
  }
}

class Participant implements Comparable<Participant> {
  private String login;
  private int solved;
  private int penalty;

  public Participant(String login, int solved, int penalty) {
    this.login = login;
    this.solved = solved;
    this.penalty = penalty;
  }

  public String getLogin() {
    return login;
  }

  @Override
  public int compareTo(Participant o) {
    if (this.solved != o.solved) {
      return Integer.compare(o.solved, this.solved);
    }

    if (this.penalty != o.penalty) {
      return Integer.compare(this.penalty, o.penalty);
    }

    return this.login.compareTo(o.login);
  }
}
