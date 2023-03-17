package ru.nvn.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class D {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int logNum = readInt(reader);
      LinkedHashSet<String> activityNameList = collectUniqActivitiName(reader, logNum);
      activityNameList.forEach(System.out::println);
    }
  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

  private static LinkedHashSet<String> collectUniqActivitiName(
      BufferedReader reader, int commandsNumber) throws IOException {
    LinkedHashSet<String> output = new LinkedHashSet<>();
    for (int i = 0; i < commandsNumber; i++) {
      String lineArray = reader.readLine();
      output.add(lineArray);
    }
    return output;
  }
}
