package ru.nvn.yandexBackend2023;
import java.util.Scanner;
public class Art {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Максимальное количество первичных баллов
        int m = scanner.nextInt(); // Количество оценок критериев
        int[] a = new int[m]; // Массив оценок критериев

        // Считываем оценки критериев
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }

        // Инициализируем переменные для хранения суммы вторичных баллов и бонусных баллов
        long secondaryPoints = 0;
        long bonusPoints = 0;

        // Перебираем оценки критериев в обратном порядке
        for (int i = m - 1; i >= 0; i--) {
            int primaryPoints = a[i];
            secondaryPoints += primaryPoints; // Добавляем первичные баллы

            if (i != m - 1) {
                bonusPoints += primaryPoints; // Добавляем бонусные баллы за предыдущие критерии
            }

            primaryPoints = Math.min(primaryPoints, n); // Ограничиваем первичные баллы до максимального значения n
            secondaryPoints += (long) primaryPoints * primaryPoints; // Добавляем вторичные баллы
        }

        // Выводим сумму набранных баллов
        long totalPoints = secondaryPoints + bonusPoints;
        System.out.println(totalPoints);
    }
}
