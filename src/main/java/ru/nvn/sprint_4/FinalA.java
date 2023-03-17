package ru.nvn.sprint_4;

import java.util.*;

public class FinalA {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt(); // количество документов
    scanner.nextLine();

    Map<String, List<Integer>> index = new HashMap<>(); // поисковый индекс
    for (int i = 1; i <= n; i++) {
      String document = scanner.nextLine();
      String[] words = document.split(" ");

      for (String word : words) {
        List<Integer> documents = index.getOrDefault(word, new ArrayList<>());
        documents.add(i);
        index.put(word, documents);
      }
    }
    int m = scanner.nextInt(); // количество запросов
    scanner.nextLine();

    for (int i = 0; i < m; i++) {
      String query = scanner.nextLine();
      String[] words = query.split(" ");
      Map<Integer, Integer> relevance = new HashMap<>(); // релевантность документов
      HashSet<String> uniqWords = new HashSet<>();
      for (String word : words) {
        if (index.containsKey(word) && !uniqWords.contains(word)) {
          for (Integer document : index.get(word)) {
            int score = relevance.getOrDefault(document, 0);
            relevance.put(document, score + 1);
          }
        }
        uniqWords.add(word);
      }
      List<Integer> docIds = new ArrayList<>(relevance.keySet());
      docIds.sort(
          (a, b) -> {
            int scoreDiff = relevance.get(b) - relevance.get(a);
            return scoreDiff == 0 ? a - b : scoreDiff;
          });
      List<Integer> topDocIds = docIds.subList(0, Math.min(5, docIds.size()));
      StringBuilder result = new StringBuilder();
      for (int docId : topDocIds) {
        result.append(docId).append(" ");
      }
      System.out.println(result.toString().trim());
    }
  }
}
