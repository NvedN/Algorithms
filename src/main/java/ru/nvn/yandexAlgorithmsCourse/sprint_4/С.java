package ru.nvn.yandexAlgorithmsCourse.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class С {

  private static long[] pPow;
  private static long[] hashes;

  private static long a;
  private static long m;

  private static void precompute(String s) {
    int n = s.length();
    pPow = new long[n + 1];
    hashes = new long[n + 1];

    pPow[0] = 1;
    for (int i = 1; i <= n; i++) {
      pPow[i] = (pPow[i - 1] * a) % m;
      hashes[i] = (hashes[i - 1] * a + s.charAt(i - 1)) % m;
    }
  }

  private static long getHash(int left, int right) {
    return (hashes[right] - (hashes[left - 1] * pPow[right - left + 1]) % m + m) % m;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    a = Long.parseLong(tokenizer.nextToken());
    m = Long.parseLong(reader.readLine());
    String s = reader.readLine();
    precompute(s);

    int t = Integer.parseInt(reader.readLine());
    while (t-- > 0) {
      tokenizer = new StringTokenizer(reader.readLine());
      int left = Integer.parseInt(tokenizer.nextToken());
      int right = Integer.parseInt(tokenizer.nextToken());
      System.out.println(getHash(left, right));
    }
  }
}
