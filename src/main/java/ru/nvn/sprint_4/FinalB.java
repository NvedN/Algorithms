package ru.nvn.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FinalB {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    HashTable hashTable = new HashTable(1_000_000);
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
            System.out.println("None");
          } else {
            System.out.println(returnGetValue);
          }
          break;
        case "delete":
          int returnDeleteValue = hashTable.delete(key);
          if (returnDeleteValue == -1) {
            System.out.println("None");
          } else {
            System.out.println(returnDeleteValue);
          }
          break;
      }
    }
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

    HashTable(int size) {
      this.size = size;
      table = new ArrayList[size];
    }

    private int hash(int key) {
      return Math.abs(key) % size;
    }

    void put(int key, int value) {
      int h = hash(key);
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
      int h = hash(key);
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
      int h = hash(key);
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