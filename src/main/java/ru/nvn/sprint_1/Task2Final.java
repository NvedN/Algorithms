// ID успешной посылки 82027135

package ru.nvn.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
      int rowsCount = readInt(reader);
      List<List<String>> matrix = readMatrix(reader);
      System.out.println(trainer(rowsCount, matrix));
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

    String line = reader.readLine();
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
   * @param number {@code BufferedReader}
   * @param matrix {@code BufferedReader}
   * @return returns int value that indicates the score in the game
   * @author NVN
   * @since sprint 1
   */
  public static Integer trainer(Integer number, List<List<String>> matrix) {

    int scores = 0;
    Map<String, Integer> numbers = new HashMap<>();
    for (int KeyNum = 1; KeyNum < 10; KeyNum++) {
      numbers.put(String.valueOf(KeyNum), 0);
    }
    for (int matrixLineNum = 0; matrixLineNum < 4; matrixLineNum++) {
      List<String> matrixValues = matrix.get(matrixLineNum);
      for (String matrixValueNum : matrixValues) {
        if (matrixValueNum.equals(".")) {
          continue;
        }
        int tmpValue = numbers.get(matrixValueNum);
        tmpValue++;
        numbers.replace(matrixValueNum, tmpValue);
      }
    }
    for (String key : numbers.keySet()) {
      Integer value = numbers.get(key);
      if (value > 0 && value <= number * 2) {
        scores += 1;
      }
    }
    return scores;
  }

}
