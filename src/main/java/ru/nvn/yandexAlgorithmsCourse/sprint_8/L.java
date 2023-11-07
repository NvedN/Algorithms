package ru.nvn.yandexAlgorithmsCourse.sprint_8;

import java.io.*;

public class L {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = reader.readLine();
    int n = s.length();
    int[] pi = new int[n];
    pi[0] = 0;

    for (int i = 1; i < n; i++) {
      int j = pi[i - 1];
      while (j > 0 && s.charAt(i) != s.charAt(j)) {
        j = pi[j - 1];
      }
      if (s.charAt(i) == s.charAt(j)) {
        j++;
      }
      pi[i] = j;
    }

    for (int i = 0; i < n; i++) {
      writer.write(pi[i] + " ");
    }
    writer.flush();
  }
}
