package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.util.*;
public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) {
            ratings[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        int maxLength = 0;
        int lastIdx = -1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (ratings[j] < ratings[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIdx = i;
            }
        }
        System.out.println(maxLength);
        List<Integer> sequence = new ArrayList<>();
        while (lastIdx != -1) {
            sequence.add(lastIdx + 1);
            lastIdx = prev[lastIdx];
        }
        Collections.reverse(sequence);
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + " ");
        }
    }
}
