package ru.nvn.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CircularBuffer {


  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int commandsNumber = readInt(reader);
      int dequeSize = readInt(reader);
      List<String> commandsList = readList(reader, commandsNumber);
      printDeque(commandsList, dequeSize);
    }
  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

  private static List<String> readList(BufferedReader reader, int commandsNumber)
      throws IOException {
    List<String> output = new ArrayList<>();
    for (int i = 0; i < commandsNumber; i++) {
      String lineArray = reader.readLine();
      output.add(lineArray);
    }
    return output;
  }

  public static void printDeque(List<String> queue, int dequeSize) {
    CircularBuffer cb = new CircularBuffer(dequeSize);
    for (String command : queue) {
      if (command.contains("push_back")) {
        String[] sp = command.split(" ");
        cb.push_back(Integer.parseInt(sp[1]));
      }
      if (command.contains("push_front")) {
        String[] sp = command.split(" ");
        cb.push_front(Integer.parseInt(sp[1]));
      }
      if (command.contains("pop_front")) {
        cb.pop_front();
      }
      if (command.contains("pop_back")) {
        cb.pop_back();
      }
    }
  }

  int capacity = 0, back = -2, front = 0;
  int[] array = null;

  boolean isEmpty() {
    return back == -2;
  }

  boolean isFull() {
    return ((front - 1 + capacity) % capacity == back) || ((back + 1) % capacity == front);
  }


  public CircularBuffer(int n) {
    capacity = n;
    array = new int[n];
  }

//  Deque() {
//    delete[] array;
//    cout << "deque deleted\n";
//  }

  boolean push_back(int x) {
    if (isFull()) {
      return false;
    }
    if (back == -2) {
      back = -1;
    }
    back = (back + 1) % capacity;
    array[back] = x;
    return true;
  }

  boolean push_front(int x) {
    if (isFull()) {
      return false;
    }
    if (back == -2) {
      back = 0;
      front = 1;
    }
    front = (front - 1 + capacity) % capacity;
    array[front] = x;
    return true;
  }

  boolean pop_back() {
    if (isEmpty()) {
      System.out.println("error");
      return false;
    }
    int a = array[back];
    if (back == front) {
      front = 0;
      back = -2;
    } else {
      back = (back - 1 + capacity) % capacity;
    }
    System.out.println(a);
    return true;
  }

  boolean pop_front() {
    if (isEmpty()) {
      System.out.println("error");
      return false;
    }
    int a = array[front];
    if (back == front) {
      front = 0;
      back = -2;
    } else {
      front = (front + 1) % capacity;
    }
    System.out.println(a);
    return true;
  }

}
