package ru.nvn.yandexAlgorithmsCourse.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {

  public static void main(String[] args) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    try {
      String s = bufferedReader.readLine();
      bufferedReader.close();
      String[] s2 = s.split(" ");
      int a = Integer.parseInt(s2[0]);
      int b = Integer.parseInt(s2[1]);
      int c = Integer.parseInt(s2[2]);

      int mod = (a % 2) + (b % 2) + (c % 2);
      if (mod == 0 || mod == 3) {
        System.out.println("WIN");
      } else {
        System.out.println("FAIL");
      }
    } catch (
        IOException e) {
      e.printStackTrace();
    }
  }

}
