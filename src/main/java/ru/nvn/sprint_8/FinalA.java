//https://contest.yandex.ru/contest/26133/run-report/87433254/

package ru.nvn.sprint_8;

import java.io.*;
import java.util.*;

public class FinalA {

  /**
   * -- ПРИНЦИП РАБОТЫ -- Алгоритм использует две функции unpack и maxPrefix. Функция unpack
   * принимает входную строку, которая содержит символы и числа. Символы сохраняются в списке
   * символов. Если встречается число, то оно сохраняется в стеке. Если встречается открывающая
   * скобка, создается новый пустой список символов. Если встречается закрывающая скобка, то
   * происходит распаковка списка символов, сохраненного в последней открывающей скобке, и умножение
   * этого списка на число, которое было сохранено в стеке чисел. Если стек пустой, результат
   * распаковки добавляется в итоговый список. Если стек не пустой, то результат добавляется в
   * список символов, сохраненный в вершине стека. Функция maxPrefix считывает число строк n и
   * строку prefix из входного потока. Затем, она проходит по оставшимся строкам и обновляет
   * значение prefix, чтобы он стал наибольшим общим префиксом. Для этого, она последовательно
   * сравнивает текущую строку с prefix и уменьшает prefix, пока не найдет максимальный префикс.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- алгоритма заключается в том, что он рассматривает все
   * возможные варианты префиксов для всех строк и выбирает максимальный общий префикс.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- алгоритма может быть определена как O(m * n), где m - максимальная
   * длина общего префикса, а n - количество строк.
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- алгоритма составляет O(m), где m - максимальная длина
   * входных строк.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    writer.write(maxPrefix(reader));
    writer.newLine();
    writer.flush();
  }

  public static String unpack(String string) {
    Deque<Integer> multiply = new ArrayDeque<>();
    Deque<List<Character>> symbol = new ArrayDeque<>();
    List<Character> result = new ArrayList<>();

    for (char c : string.toCharArray()) {
      if (Character.isDigit(c)) {
        multiply.push(Character.getNumericValue(c));
        continue;
      }
      if (c == '[') {
        symbol.push(new ArrayList<>());
        continue;
      }
      if (c == ']') {
        List<Character> current = symbol.pop();
        int repeat = multiply.pop();
        if (symbol.isEmpty()) {
          for (int i = 0; i < repeat; i++) {
            result.addAll(current);
          }
        } else {
          List<Character> previous = symbol.peek();
          for (int i = 0; i < repeat; i++) {
            previous.addAll(current);
          }
        }
        continue;
      }
      if (symbol.isEmpty()) {
        result.add(c);
        continue;
      }
      symbol.peek().add(c);
    }

    StringBuilder sb = new StringBuilder();
    for (char ch : result) {
      sb.append(ch);
    }
    return sb.toString();
  }

  public static String maxPrefix(BufferedReader reader) throws IOException {
    int n = Integer.parseInt(reader.readLine());

    if (n == 0) {
      return "";
    }

    String prefixStr = unpack(reader.readLine());
    char[] prefix = prefixStr.toCharArray();
    for (int i = 1; i < n; i++) {
      String stringStr = unpack(reader.readLine());
      char[] string = stringStr.toCharArray();
      int j;
      for (j = 0; j < prefix.length && j < string.length; j++) {
        if (prefix[j] != string[j]) {
          break;
        }
      }
      prefix = Arrays.copyOf(prefix, j);
    }

    return new String(prefix);
  }

}
