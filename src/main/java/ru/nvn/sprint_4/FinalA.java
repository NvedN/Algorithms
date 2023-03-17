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

      for (String word : words) {
        if (index.containsKey(word)) {
          for (Integer document : index.get(word)) {
            int score = relevance.getOrDefault(document, 0);
            relevance.put(document, score + 1);
          }
        }
      }
      System.out.println("----------relevance = " + relevance);

      List<Map.Entry<Integer, Integer>> relevanceList = new ArrayList<>(relevance.entrySet());
      relevanceList.sort(
          (a, b) -> {
            int cmp = a.getValue().compareTo(b.getValue());
            if (cmp == 0) {
              return b.getKey().compareTo(a.getKey());
            }
            return cmp;
          });

      System.out.println("----------relevanceList = " + relevanceList);

      List<Integer> topDocuments = new ArrayList<>();
      for (int j = 0; j < 5 && j < relevanceList.size(); j++) {
        int document = relevanceList.get(j).getKey();
        int score = relevanceList.get(j).getValue();
        if (score > 0) {
          topDocuments.add(document);
        }
      }

      for (int document : topDocuments) {
        System.out.print(document + " ");
      }
      System.out.println();
    }
  }
}
