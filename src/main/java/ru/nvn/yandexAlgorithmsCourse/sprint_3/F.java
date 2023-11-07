package ru.nvn.yandexAlgorithmsCourse.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class F {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    int[] sides = new int[n];
    String[] sidesStr = reader.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      sides[i] = Integer.parseInt(sidesStr[i]);
    }
    int maxPerimeter = findMaxPerimeter(sides);
    System.out.println(maxPerimeter);
  }

  private static int findMaxPerimeter(int[] sides) {
    Arrays.sort(sides);
    int maxPerimeter = 0;
    for (int i = sides.length - 1; i >= 2; i--) {
      int a = sides[i];
      int b = sides[i - 1];
      int c = sides[i - 2];
      if (c + b > a) {
        maxPerimeter = a + b + c;
        break;
      }
    }
    return maxPerimeter;
  }
}
