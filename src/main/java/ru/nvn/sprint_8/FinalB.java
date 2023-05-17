// https://contest.yandex.ru/contest/26133/run-report/87396204/

package ru.nvn.sprint_8;

import java.io.*;
import java.util.HashMap;

public class FinalB {

  /**
   * -- ПРИНЦИП РАБОТЫ -- алгоритма заключается в построении префиксного дерева на основе списка
   * слов. Затем алгоритм проверяет, можно ли разделить входную строку на подстроки, которые
   * являются словами из списка. Алгоритм использует динамическое программирование для этой цели.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- если входная строка может быть разделена на слова из
   * списка, то должно существовать разбиение, которое начинается с пустой строки и заканчивается
   * полной входной строкой. Для каждой подстроки входной строки, мы проверяем, можно ли разделить
   * ее на слова из списка. Это происходит путем перебора всех возможных разбиений этой подстроки,
   * начиная с ее начала, и заканчивая ее концом. Если мы обнаруживаем, что конец подстроки может
   * быть разделен на слова из списка, то мы помечаем соответствующий элемент массива dp как True.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- O(n*m), где n - длина строки, m - количество слов в массиве words.
   * Это происходит из-за цикла for в функции isSplitWords, который выполняется n раз, а внутри него
   * выполняется еще один цикл for, который будет выполняться в худшем случае n раз (если все
   * символы строки будут валидными словами), и производить поиск в HashMap, который имеет временную
   * сложность O(1) в среднем случае.
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- Пространственная сложность данного кода зависит от длины
   * слов в массиве words и длины строки string. Создание дерева префиксов в функции createTree
   * требует O(m * k) дополнительной памяти, где k - максимальная длина слова в массиве words. В то
   * же время, использование массива dp в функции isSplitWords требует O(n) дополнительной памяти.
   * Таким образом, пространственная сложность кода составляет O(m * k + n).
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String string = reader.readLine();
    int n = Integer.parseInt(reader.readLine());
    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = reader.readLine();
    }
    boolean result = isSplitWords(string, words);
    writer.write(result ? "YES" : "NO");
    writer.newLine();
    reader.close();
    writer.close();
  }

  public static Node createTree(String[] words) {
    Node root = new Node("");
    for (String word : words) {
      Node node = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        node.next.putIfAbsent(c, new Node(String.valueOf(c)));
        node = node.next.get(c);
      }
      node.terminal = true;
    }
    return root;
  }

  public static boolean isSplitWords(String string, String[] words) {
    Node root = createTree(words);
    boolean[] dp = new boolean[string.length() + 1];
    dp[0] = true;
    for (int i = 0; i < string.length(); i++) {
      Node node = root;
      if (dp[i]) {
        for (int j = i; j < string.length() + 1; j++) {
          if (node.terminal) {
            dp[j] = true;
          }
          if (j == string.length() || !node.next.containsKey(string.charAt(j))) {
            break;
          }
          node = node.next.get(string.charAt(j));
        }
      }
    }
    return dp[string.length()];
  }

  public static class Node {
    String value;
    HashMap<Character, Node> next;
    boolean terminal;

    public Node(String value, HashMap<Character, Node> next, boolean terminal) {
      this.value = value;
      this.next = next;
      this.terminal = terminal;
    }

    public Node(String value) {
      this(value, new HashMap<>(), false);
    }
  }
}
