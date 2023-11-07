package ru.nvn.interview.yandexContext;

import java.util.Scanner;

public class AplusB {

    private static int getSum(int a, int b) {
        // Ваше решение

        return a+b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(getSum(a, b));
        scanner.close();
    }


}
