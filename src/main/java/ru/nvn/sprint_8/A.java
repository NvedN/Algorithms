package ru.nvn.sprint_8;

import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Разбиваем строку на массив слов
        String[] words = input.split(" ");

        // Создаем пустую строку для хранения результата
        StringBuilder reversedWords = new StringBuilder();

        // Итерируемся по массиву слов в обратном порядке
        for (int i = words.length - 1; i >= 0; i--) {
            // Добавляем очередное слово в результирующую строку
            reversedWords.append(words[i]);

            // Добавляем пробел между словами, кроме последнего
            if (i > 0) {
                reversedWords.append(" ");
            }
        }

        // Выводим результат
        System.out.println(reversedWords);
    }
}
