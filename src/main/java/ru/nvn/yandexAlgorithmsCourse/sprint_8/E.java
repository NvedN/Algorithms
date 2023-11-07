package ru.nvn.yandexAlgorithmsCourse.sprint_8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class E {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    int n = scanner.nextInt();
    scanner.nextLine();

    List<Pair<String, Integer>> pairs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] line = scanner.nextLine().split(" ");
      String ti = line[0];
      int ki = Integer.parseInt(line[1]);
      pairs.add(new Pair<>(ti, ki));
    }

    pairs.sort(Comparator.comparingInt(Pair::getValue));

    StringBuilder sb = new StringBuilder(s);
    int offset = 0;
    for (Pair<String, Integer> pair : pairs) {
      int ki = pair.getValue() + offset;
      String ti = pair.getKey();
      sb.insert(ki, ti);
      offset += ti.length();
    }

    System.out.println(sb.toString());
  }

  public static class Pair<String, Integer> {
    private final String key;
    private final int value;

    public Pair(String key, int value) {
      this.key = key;
      this.value = value;
    }

    public String getKey() {
      return key;
    }

    public int getValue() {
      return value;
    }
  }
}
