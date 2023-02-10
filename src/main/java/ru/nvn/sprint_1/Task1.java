package ru.nvn.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {

  public static void main(String[] args) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    try {

      String s = bufferedReader.readLine();
      bufferedReader.close();
      String[] s2 = s.split(" ");
      int a = Integer.parseInt(s2[0]);
      int x = Integer.parseInt(s2[1]);
      int b = Integer.parseInt(s2[2]);
      int c = Integer.parseInt(s2[3]);
      System.out.println((a * x * x) + (b * x) + c);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}