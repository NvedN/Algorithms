package ru.nvn.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskG {

  private static String getBinaryNumber(int n) {

    StringBuilder sb = new StringBuilder();
    if (n == 0) {
      return "0";
    } else {
      while (n > 0) {
        int r = n % 2;
        sb.append(r);
        n = n / 2;
      }
      return sb.reverse().toString();
    }
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = readInt(reader);
      System.out.println(getBinaryNumber(n));
    }
  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

}
