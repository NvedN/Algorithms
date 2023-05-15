package ru.nvn.sprint_7;

import java.util.*;
public class K {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        int[][] lcs = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        int len = lcs[n][m];
        System.out.println(len);
        List<Integer> aIndexes = new ArrayList<>();
        List<Integer> bIndexes = new ArrayList<>();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                aIndexes.add(i);
                bIndexes.add(j);
                i--;
                j--;
            } else if (lcs[i - 1][j] >= lcs[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        Collections.reverse(aIndexes);
        Collections.reverse(bIndexes);
        for (int k = 0; k < len; k++) {
            System.out.print(aIndexes.get(k) + " ");
        }
        System.out.println();
        for (int k = 0; k < len; k++) {
            System.out.print(bIndexes.get(k) + " ");
        }
        System.out.println();
    }
}
