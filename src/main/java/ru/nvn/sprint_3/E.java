package ru.nvn.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = reader.readLine().split(" ");
    int n = Integer.parseInt(firstLine[0]); // количество домов
    int k = Integer.parseInt(firstLine[1]); // общий бюджет
    int[] costs = new int[n]; // стоимости домов
    String[] secondLine = reader.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      costs[i] = Integer.parseInt(secondLine[i]);
    }
    Arrays.sort(costs); // сортируем стоимости по возрастанию
    int count = buyHouses(n, k, costs); // вызываем метод, который покупает дома
    System.out.println(count); // выводим количество купленных домов
  }

  private static int buyHouses(int n, int k, int[] costs) {
    int count = 0; // счетчик купленных домов
    for (int i = 0; i < n; i++) {
      if (k >= costs[i]) { // если бюджет позволяет купить этот дом
        count++;
        k -= costs[i]; // вычитаем стоимость купленного дома из бюджета
      } else {
        break; // если бюджет не позволяет купить этот дом, то и следующие дома уже не купим
      }
    }
    return count; // возвращаем количество купленных домов
  }
}
