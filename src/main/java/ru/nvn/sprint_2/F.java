package ru.nvn.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F {


  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int commandsNumber = readInt(reader);
      List<String> commandsList = readList(reader, commandsNumber);
      printQueue(commandsList);
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

  public static void printQueue(List<String> queue) {
    F stackMax = new F();
    for (String command : queue) {
      if (command.equals("pop")) {
        stackMax.pop();
      }
      if (command.equals("get_max")) {
        System.out.println(stackMax.get_max());
      }
      if (command.contains("push")) {
        String[] sp = command.split(" ");
        stackMax.push(Integer.parseInt(sp[1]));
      }
    }

  }

  // arr is the array which stores
  // our ArrayList elements
  private int arr[] = new int[0];


  public F() {
//    arr = new int[0];
  }

  public void push(int x) {
    int newArr[] = new int[arr.length + 1];
    for (int i = 0; i < arr.length; i++) {
      newArr[i] = arr[i];
    }
    newArr[arr.length] = x;
    arr = newArr;
  }

  public void pop() {
    if (arr.length == 0) {
      System.out.println("error");
    } else {
      int[] arr_new = new int[arr.length - 1];
      int j = arr.length - 1;
      for (int i = 0, k = 0; i < arr.length; i++) {
        if (i != j) {
          arr_new[k] = arr[i];
          k++;
        }
      }
      arr = arr_new;
    }
  }

  public String get_max() {
    if (arr.length == 0) {
      return "None";
    } else {
      int max = arr[0];
      for (int i = 1; i < arr.length; i++){
        if (arr[i] > max){
          max = arr[i];
        }
      }
      return String.valueOf(max);
    }
  }


}
