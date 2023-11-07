package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(); // сумма, которую нужно набрать
        int n = scanner.nextInt(); // количество монет в банкомате
        int[] coins = new int[n]; // достоинства купюр
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        int[] dp = new int[m + 1]; // массив для динамического программирования
        dp[0] = 1; // базовое значение для 0 франков
        for (int coin : coins) {
            for (int i = coin; i <= m; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[m]); // вывод количества способов
    }
}
