package ru.nvn.sprint_8;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // читаем количество строк
        int n = scanner.nextInt();

        // читаем первую строку и сохраняем её как префикс
        String prefix = scanner.next();

        // проходимся по оставшимся строкам и обновляем префикс
        for (int i = 1; i < n; i++) {
            String s = scanner.next();
            int j = 0;
            // находим максимальную длину общего префикса для текущей строки и префикса
            while (j < prefix.length() && j < s.length() && prefix.charAt(j) == s.charAt(j)) {
                j++;
            }
            // обновляем префикс
            prefix = prefix.substring(0, j);
        }

        // выводим длину префикса
        System.out.println(prefix.length());
    }
}
