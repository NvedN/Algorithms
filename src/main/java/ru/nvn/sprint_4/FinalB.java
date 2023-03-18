// https://contest.yandex.ru/contest/24414/run-report/84201607/

package ru.nvn.sprint_4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinalB {
  /**
   * -- ПРИНЦИП РАБОТЫ -- Данный код реализует структуру данных хэш-таблица, которая представляет
   * собой массив списков. Каждый элемент хэш-таблицы хранит ключ и значение. Операции добавления,
   * получения и удаления элементов в хэш-таблице выполняются за константное время в среднем случае,
   * благодаря эффективной хэш-функции, которая распределяет ключи элементов по ячейкам массива.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- алгоритма заключается в том, что все операции добавления,
   * поиска и удаления элементов выполняются за константное время в среднем случае, что гарантирует
   * хэш-таблица.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- данного алгоритма в худшем случае равна O(n), где n - количество
   * операций, которые нужно выполнить. Это происходит в случае, когда все операции добавления,
   * поиска и удаления элементов выполняются на одном и том же хэш-бакете, что может произойти при
   * плохом хэшировании. В среднем же время выполнения каждой операции составляет O(1).
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- данного алгоритма равна O(m), где m - количество элементов,
   * которые были добавлены в хэш-таблицу. Это связано с тем, что каждый элемент занимает место в
   * списке, который хранится в соответствующем хэш-бакете.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    HashTable hashTable = new HashTable(n);
    for (int i = 0; i < n; i++) {
      String[] parts = reader.readLine().split("\\s");
      String operation = parts[0];
      int key = Integer.parseInt(parts[1]);
      switch (operation) {
        case "put":
          int value = Integer.parseInt(parts[2]);
          hashTable.put(key, value);
          break;
        case "get":
          int returnGetValue = hashTable.get(key);
          if (returnGetValue == -1) {
            writer.write("None\n");
          } else {
            writer.write(returnGetValue + "\n");
          }
          break;
        case "delete":
          int returnDeleteValue = hashTable.delete(key);
          if (returnDeleteValue == -1) {
            writer.write("None\n");
          } else {
            writer.write(returnDeleteValue + "\n");
          }
          break;
      }
    }
    writer.flush();
    writer.close();
    reader.close();
  }

  public static class HashTable {
    private final int size;
    private final List<HashTable.Node>[] table;

    static class Node {
      final int key;
      int value;

      Node(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }

    HashTable(int capacity) {
      if (capacity <= 10) {
        capacity = 10;
      }
      size = capacity / 10;
      table = new ArrayList[size];
    }

    private int hash(int key) {
      return Integer.hashCode(Math.abs(key));
    }

    private int getBucketIndex(int key) {
      return hash(key) % size;
    }

    void put(int key, int value) {
      int h = getBucketIndex(key);
      if (table[h] == null) {
        table[h] = new ArrayList<>();
      }
      for (HashTable.Node node : table[h]) {
        if (node.key == key) {
          node.value = value;
          return;
        }
      }
      table[h].add(new HashTable.Node(key, value));
    }

    int get(int key) {
      int h = getBucketIndex(key);
      if (table[h] == null) {
        return -1;
      }
      for (HashTable.Node node : table[h]) {
        if (node.key == key) {
          return node.value;
        }
      }
      return -1;
    }

    int delete(int key) {
      int h = getBucketIndex(key);
      if (table[h] == null) {
        return -1;
      }
      for (int i = 0; i < table[h].size(); i++) {
        HashTable.Node node = table[h].get(i);
        if (node.key == key) {
          table[h].remove(i);
          return node.value;
        }
      }
      return -1;
    }
  }
}
