// https://contest.yandex.ru/contest/22450/run-report/82337022/

package ru.nvn.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task2Final {

  /**
   * Main method to execute program
   *
   * @param args {@code String[]}
   * @throws IOException if something went wrong
   * @author NVN
   * @since sprint 1
   */
  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int keysNumber = readInt(reader);
      List<List<String>> matrix = readMatrix(reader);
      System.out.println(trainer(keysNumber, matrix));
    }
  }

  /**
   * Method to read input stream and return int value
   *
   * @param reader {@code BufferedReader} Reads text from a character-input stream
   * @return int value from input stream
   * @throws IOException if something went wrong
   * @author NVN
   * @since sprint 1
   */
  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

  /**
   * Method to read input stream and return list of strings
   *
   * @param reader {@code BufferedReader} Reads text from a character-input stream
   * @return List of strings
   * @throws IOException if something went wrong
   * @author NVN
   * @since sprint 1
   */
  private static List<String> readList(BufferedReader reader) throws IOException {

    String line = reader.readLine().replace(".", "0");
    return new ArrayList<>(List.of(line.split("")));
  }


  /**
   * Method to construct matrix by input stream
   *
   * @param reader {@code BufferedReader} Reads text from a character-input stream
   * @return matrix
   * @throws IOException if something went wrong
   * @author NVN
   * @since sprint 1
   */
  private static List<List<String>> readMatrix(BufferedReader reader)
      throws IOException {
    List<List<String>> matrix = new ArrayList<>(4);
    for (int i = 0; i < 4; i++) {
      matrix.add(readList(reader));
    }
    return matrix;
  }

  /**
   * Method for Finding a Winner in the Speed Typing Simulator Game
   *
   * @param keysNumber {@code BufferedReader}  Number of keys that can be pressed at one time
   * @param matrix     {@code BufferedReader} Matrix for the Simulator for high-speed typing
   * @return returns int value that indicates the score in the game
   * @author NVN
   * @since sprint 1
   */
  public static Integer trainer(Integer keysNumber, List<List<String>> matrix) {

    int scores = 0;
    int[] numbersArray = new int[10];
    for (int matrixLineNum = 0; matrixLineNum < 4; matrixLineNum++) {
      List<String> matrixValues = matrix.get(matrixLineNum);
      for (String value : matrixValues) {
        numbersArray[Integer.parseInt(value)] += 1;
      }
    }
    for (int arrayNum = 1; arrayNum < numbersArray.length; arrayNum++) {
      int value = numbersArray[arrayNum];
      if (value > 0 && value <= keysNumber * 2) {
        scores += 1;
      }
    }
    return scores;
  }

}