package ru.nvn.sprint_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class FinalA {

  /**
   * -- ПРИНЦИП РАБОТЫ -- 1.Из исходного массива строим бинарную кучу, где каждый элемент является
   * родителем для своих дочерних элементов и имеет значение, большее или равное, чем у своих детей.
   * 2.После построения кучи, меняем местами корневой элемент (максимальный) с последним элементом в
   * массиве. 3.Уменьшаем размер кучи на 1, и вызываем процедуру "просеивания" корня (т.е.
   * соблюдения правил бинарной кучи). 4.Повторяем шаги 2 и 3 до тех пор, пока в куче не останется 1
   * элемент. 5.Отсортированный массив будет получен в обратном порядке - от последнего к первому.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- 1. Построение кучи гарантирует, что максимальный элемент
   * находится в корне. 2. Меняем местами максимальный элемент с последним в массиве, что
   * гарантирует, что максимальный элемент будет находиться в конце массива. 3. После этого
   * производим просеивание корня, чтобы восстановить свойства бинарной кучи. 4. Повторяем шаги 2 и
   * 3 до тех пор, пока в куче не останется 1 элемент. 5. Корректность алгоритма доказана тем, что
   * он сначала формирует корректную бинарную кучу, а затем на каждом шаге перемещает максимальный
   * элемент на свое место в отсортированном массиве.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ --  O(nlog n), где n - число элементов
   * в массиве. Построение бинарной кучи требует O(n) операций, а каждое просеивание занимает O(log
   * n) операций. Всего нужно выполнить n-1 операций для построения отсортированного массива, что
   * дает общую сложность O(nlog n).
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --O(1), т.к. алгоритм работает с исходным массивом,
   * без создания дополнительных структур данных.
   *
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(reader.readLine());

    Participant[] participants = new Participant[n];
    for (int i = 0; i < n; i++) {
      String[] input = reader.readLine().split(" ");
      String name = input[0];
      int tasks = Integer.parseInt(input[1]);
      int penalty = Integer.parseInt(input[2]);
      participants[i] = new Participant(name, tasks, penalty);
    }

    Arrays.sort(participants, new ParticipantComparator());

    for (Participant participant : participants) {
      System.out.println(participant.name);
    }
  }

  static class Participant {
    String name;
    int tasks;
    int penalty;

    public Participant(String name, int tasks, int penalty) {
      this.name = name;
      this.tasks = tasks;
      this.penalty = penalty;
    }
  }

  static class ParticipantComparator implements Comparator<Participant> {

    @Override
    public int compare(Participant p1, Participant p2) {
      if (p1.tasks != p2.tasks) {
        return Integer.compare(p2.tasks, p1.tasks);
      } else if (p1.penalty != p2.penalty) {
        return Integer.compare(p1.penalty, p2.penalty);
      } else {
        return p1.name.compareTo(p2.name);
      }
    }
  }
}
