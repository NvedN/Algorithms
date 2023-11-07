package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] field = new int[n][m];
        // считываем поле из ввода
        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < m; j++) {
                field[i][j] = row.charAt(j) - '0'; // преобразуем символ в число
            }
        }
        int[][] dp = new int[n][m]; // создаем двумерный массив для хранения результатов
        dp[0][0] = field[0][0]; // заполняем начальную ячейку
        // заполняем первый столбец
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + field[i][0];
        }
        // заполняем первую строку
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + field[0][j];
        }
        // заполняем оставшиеся ячейки
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + field[i][j];
            }
        }
        System.out.println(dp[n-1][m-1]); // выводим результат
    }
}
