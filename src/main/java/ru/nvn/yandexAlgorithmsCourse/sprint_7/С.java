package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.util.*;

public class С {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int M = scanner.nextInt();
    int n = scanner.nextInt();

    List<Pair<Integer, Integer>> piles = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int c = scanner.nextInt();
      int m = scanner.nextInt();
      piles.add(new Pair<>(c, m));
    }

    Collections.sort(piles, new Comparator<Pair<Integer, Integer>>() {
      @Override
      public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
        double ratio1 = (double) p1.getFirst() / p1.getSecond();
        double ratio2 = (double) p2.getFirst() / p2.getSecond();
        return Double.compare(ratio2, ratio1);
      }
    });

    int totalValue = 0;
    for (Pair<Integer, Integer> pile : piles) {
      int c = pile.getFirst();
      int m = pile.getSecond();

      if (M >= m) {
        totalValue += c * m;
        M -= m;
      } else {
        totalValue += c * M;
        break;
      }
    }

    System.out.println(totalValue);
  }

  static class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
      this.first = first;
      this.second = second;
    }

    public T getFirst() {
      return first;
    }

    public U getSecond() {
      return second;
    }
  }
}
