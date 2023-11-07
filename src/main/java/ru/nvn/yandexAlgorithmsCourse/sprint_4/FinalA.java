// https://contest.yandex.ru/contest/24414/run-report/84199521/

package ru.nvn.yandexAlgorithmsCourse.sprint_4;

import java.io.*;
import java.util.*;

public class FinalA {

  /**
   * -- ПРИНЦИП РАБОТЫ --Данный код реализует простую поисковую систему. Принцип работы состоит из
   * трех основных шагов:
   *
   * <p>Строится обратный индекс - для каждого слова из документов, в котором оно встречается,
   * записывается, в каких документах это слово встречается и сколько раз.
   *
   * <p>При поступлении запроса, он разбивается на слова, для каждого слова ищутся документы, в
   * которых оно встречается, и на основе этой информации определяется релевантность каждого
   * документа.
   *
   * <p>Отобранные документы сортируются по релевантности и выводятся на экран.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- Для каждого слова в обратном индексе хранится список
   * документов, в которых оно встречается. Каждый документ имеет свой уникальный идентификатор. Для
   * каждого документа в релевантности хранится суммарное количество вхождений всех слов из запроса
   * в этот документ. Поэтому, если документ имеет высокую релевантность, то это значит, что он
   * содержит много слов из запроса и они встречаются в нем много раз.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- Временная сложность данного алгоритма зависит от размера входных
   * данных и количества запросов. Построение обратного индекса занимает O(n * d * w) времени, где n
   * - количество документов, d - средняя длина документа и w - среднее количество слов в документе.
   * Обработка запроса занимает O(q * d * w) времени, где q - количество запросов. Сложность
   * сортировки документов по релевантности равна O(d * log(d)), где d - количество документов.
   * Таким образом, общая временная сложность составляет O(n * d * w + q * d * w + d * log(d)).
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- Пространственная сложность алгоритма зависит от размера
   * обратного индекса. В нашем случае он занимает O(n * d * w) памяти.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine()); // количество документов
    Map<String, HashMap<Integer, Integer>> index = buildIndex(n, reader);
    int m = Integer.parseInt(reader.readLine()); // количество запросов
    for (int i = 0; i < m; i++) {
      String query = reader.readLine();
      HashSet<String> uniqWordsFromQuery = new HashSet<>(List.of(query.split(" ")));
      List<Integer> topDocIds = getTopDocuments(uniqWordsFromQuery, index);
      topDocIds.forEach(
          doc -> {
            try {
              writer.write(doc + " ");
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          });
      writer.newLine();
    }
    reader.close();
    writer.close();
  }

  private static Map<String, HashMap<Integer, Integer>> buildIndex(int n, BufferedReader reader)
      throws IOException {
    Map<String, HashMap<Integer, Integer>> index = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      String document = reader.readLine();
      String[] words = document.split(" ");
      for (String word : words) {
        HashMap<Integer, Integer> documentsNew = index.getOrDefault(word, new HashMap<>());
        int count = documentsNew.get(i) != null ? documentsNew.get(i) : 0;
        count++;
        documentsNew.put(i, count);
        index.put(word, documentsNew);
      }
    }

    return index;
  }

  private static List<Integer> getTopDocuments(
      HashSet<String> uniqWordsFromQuery, Map<String, HashMap<Integer, Integer>> index) {
    Map<Integer, Integer> relevance = new HashMap<>();
    for (String word : uniqWordsFromQuery) {
      if (index.containsKey(word)) {
        for (Integer document : index.get(word).keySet()) {
          int score = index.get(word).get(document);

          if (relevance.containsKey(document)) {
            score += relevance.get(document);
          }
          relevance.put(document, score);
        }
      }
    }
    List<Integer> docIds = new ArrayList<>(relevance.keySet());
    docIds.sort(
        (a, b) -> {
          int scoreDiff = Integer.compare(relevance.get(b), relevance.get(a));
          return scoreDiff == 0 ? Integer.compare(a, b) : scoreDiff;
        });
    return docIds.subList(0, Math.min(5, docIds.size()));
  }
}
