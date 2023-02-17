//package ru.nvn.sprint_2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Deque {
//
//  public static void main(String[] args) throws IOException {
//
//    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//      int commandsNumber = readInt(reader);
//      int dequeSize = readInt(reader);
//      List<String> commandsList = readList(reader, commandsNumber);
//      printDeque(commandsList, dequeSize);
//    }
//  }
//
//  private static int readInt(BufferedReader reader) throws IOException {
//    return Integer.parseInt(reader.readLine());
//  }
//
//  private static List<String> readList(BufferedReader reader, int commandsNumber)
//      throws IOException {
//    List<String> output = new ArrayList<>();
//    for (int i = 0; i < commandsNumber; i++) {
//      String lineArray = reader.readLine();
//      output.add(lineArray);
//    }
//    return output;
//  }
//
//  public static void printDeque(List<String> queue, int dequeSize) {
//    Deque deque = new Deque(dequeSize);
//    for (String command : queue) {
//      System.out.println("----------command = " + command);
//      if (command.contains("push_back")) {
//        String[] sp = command.split(" ");
//        deque.push_back(Integer.parseInt(sp[1]), dequeSize);
//      }
//      if (command.contains("push_front")) {
//        String[] sp = command.split(" ");
//        deque.push_front(Integer.parseInt(sp[1]), dequeSize);
//      }
//      if (command.contains("pop_front")) {
//        deque.pop_front(dequeSize);
//      }
//      if (command.contains("pop_back")) {
//        deque.pop_back(dequeSize);
//      }
//      deque.printArray();
//    }
//
//  }
//
//  public void push_back(int x, int dequeSize) {
//    if (arr.length == dequeSize - 1) {
//      System.out.println("error");
//    } else {
//      int[] newArr = new int[arr.length + 1];
//      for (int i = 0; i < arr.length; i++) {
//        newArr[i] = arr[i];
//      }
//      newArr[arr.length] = x;
//      arr = newArr;
//    }
//  }
//
//  public void push_front(int x, int dequeSize) {
//    System.out.println("----------x = " + x);
//    if (arr.length == dequeSize - 1) {
//      System.out.println("error");
//    } else {
//      int[] newArr = new int[arr.length + 1];
//      System.out.println("----------arr = " + Arrays.toString(arr));
//      System.out.println("----------arr = " + arr.length);
//
//      newArr[0] = x;
//      for (int i = 0; i < arr.length; i++) {
//        System.out.println("----------i = " + i);
//        newArr[i + 1] = arr[i];
//        System.out.println("----------newArr = " + Arrays.toString(newArr));
//      }
//      System.out.println("----------newArr = " + Arrays.toString(newArr));
//      arr = newArr;
//    }
//  }
//
//  public void pop_front(int dequeSize) {
////    System.out.println("----POP FRONT");
//    if (arr.length == dequeSize - 1 || arr.length == 0) {
//      System.out.println("error");
//    } else {
////      System.out.println("----------arr = " + Arrays.toString(arr));
////      System.out.println("----------arr = " + arr.length);
//      int[] newArr = arr.length < 1 ? new int[1] : new int[arr.length - 1];
//      System.out.println(arr[0]);
////      System.out.println("----------newArr = " + newArr.length);
////      System.out.println("----------newArr = " + Arrays.toString(newArr));
//      for (int i = 0; i < newArr.length; i++) {
////        System.out.println("----------i = " + i);
//        newArr[i] = arr[i + 1];
////        System.out.println("----------newArr = " + Arrays.toString(newArr));
//      }
////      System.out.println("----------newArr = " + Arrays.toString(newArr));
//      arr = newArr;
//    }
////    System.out.println("------------");
//  }
//
//
//  public void pop_back(int dequeSize) {
////    System.out.println("--pop back ");
//    if (arr.length == dequeSize - 1 || arr.length == 0) {
//      System.out.println("error");
//    } else {
//      int[] newArr = new int[arr.length - 1];
//      System.out.println(arr[arr.length - 1]);
////      System.out.println("----------arr = " + arr.length);
////      System.out.println("----------arr = " + Arrays.toString(arr));
//      for (int i = 0; i < arr.length - 1; i++) {
//        newArr[i] = arr[i];
////        System.out.println("----------newArr = " + Arrays.toString(newArr));
//      }
//      arr = newArr;
//    }
//  }
//
//
//}
