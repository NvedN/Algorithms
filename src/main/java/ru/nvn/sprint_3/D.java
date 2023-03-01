package ru.nvn.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // Считываем количество детей и факторы жадности
    int n = Integer.parseInt(reader.readLine());
    int[] factors = new int[n];
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    for (int i = 0; i < n; i++) {
      factors[i] = Integer.parseInt(tokenizer.nextToken());
    }

    // Считываем количество печенек и их размеры
    int m = Integer.parseInt(reader.readLine());
    int[] cookies = new int[m];
    tokenizer = new StringTokenizer(reader.readLine());
    for (int i = 0; i < m; i++) {
      cookies[i] = Integer.parseInt(tokenizer.nextToken());
    }

    // Считаем количество довольных детей
    int satisfiedChildren = countSatisfiedChildren(factors, cookies);

    System.out.println(satisfiedChildren);
  }

  private static int countSatisfiedChildren(int[] factors, int[] cookies) {
    // Сортируем массивы в порядке убывания
    Arrays.sort(factors);
    Arrays.sort(cookies);

    int satisfiedChildren = 0;
    int i = factors.length - 1; // Индекс последнего ребенка
    int j = cookies.length - 1; // Индекс последней печеньки
    while (i >= 0 && j >= 0) {
      if (cookies[j] >= factors[i]) {
        // Ребенок может получить эту печеньку
        satisfiedChildren++;
        i--;
        j--;
      } else {
        // Печенька слишком мала для этого ребенка
        i--;
      }
    }

    return satisfiedChildren;
  }
}
