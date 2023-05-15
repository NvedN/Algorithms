package ru.nvn.sprint_7;

import java.util.Scanner;

public class E {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt(); // сумма, которую нужно набрать
    int k = scanner.nextInt(); // количество номиналов
    int[] denominations = new int[k]; // массив номиналов купюр

    for (int i = 0; i < k; i++) {
      denominations[i] = scanner.nextInt();
    }

    int[] minBills =
        new int[x + 1]; // массив минимального количества купюр для каждой суммы от 0 до x
    minBills[0] = 0; // для суммы 0 нужно 0 купюр

    for (int i = 1; i <= x; i++) {
      minBills[i] = Integer.MAX_VALUE; // инициализируем массив большим значением
      for (int j = 0; j < k; j++) {
        if (i >= denominations[j] && minBills[i - denominations[j]] != Integer.MAX_VALUE) {
          minBills[i] = Math.min(minBills[i], minBills[i - denominations[j]] + 1);
        }
      }
    }

    if (minBills[x] == Integer.MAX_VALUE) {
      System.out.println("-1");
    } else {
      System.out.println(minBills[x]);
    }
  }
}
