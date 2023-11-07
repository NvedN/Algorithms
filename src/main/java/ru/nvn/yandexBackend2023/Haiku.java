package ru.nvn.yandexBackend2023;
import java.util.Scanner;

public class Haiku {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        String result = createPerfectHaiku(s);
        System.out.println(result);
    }

    public static String createPerfectHaiku(String s) {
        // Функция замены символов в строке
        char[] charArray = s.toCharArray();

        // Поиск подстрок "Yandex" и "Cup"
        int yandexIndex = -1;
        int cupIndex = -1;

        for (int i = 0; i < charArray.length - 5; i++) {
            if (s.substring(i, i + 6).equalsIgnoreCase("Yandex")) {
                yandexIndex = i;
                break;
            }
        }

        for (int i = 0; i < charArray.length - 3; i++) {
            if (s.substring(i, i + 4).equals("Cup")) {
                cupIndex = i;
                break;
            }
        }

        if (yandexIndex == -1) {
            // Если "Yandex" не найдено, добавляем его в начало строки
            s = "Yandex" + s;
        } else {
            // Если "Yandex" найдено, приводим его к нужному регистру
            for (int i = yandexIndex; i < yandexIndex + 6; i++) {
                charArray[i] = Character.isLowerCase(charArray[i]) ? Character.toUpperCase(charArray[i]) : charArray[i];
            }
        }

        if (cupIndex == -1) {
            // Если "Cup" не найдено, добавляем его в конец строки
            s = s + "Cup";
        } else {
            // Если "Cup" найдено, приводим его к нужному регистру
            for (int i = cupIndex; i < cupIndex + 3; i++) {
                charArray[i] = Character.isLowerCase(charArray[i]) ? Character.toUpperCase(charArray[i]) : charArray[i];
            }
        }

        return new String(charArray);
    }
}
