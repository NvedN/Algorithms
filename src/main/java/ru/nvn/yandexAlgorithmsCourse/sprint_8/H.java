package ru.nvn.yandexAlgorithmsCourse.sprint_8;

import java.util.*;
public class H {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String pattern = scanner.nextLine();
        String replacement = scanner.nextLine();

        String result = text.replace(pattern, replacement);

        System.out.println(result);
    }
}
