// https://contest.yandex.ru/contest/22450/run-report/82336432/

package ru.nvn.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Task1Final {


  /**
   * Method to find the nearest zero in array for each element
   *
   * @param input {@code int[]} int array with home numbers
   * @author NVN
   * @since sprint 1
   */
  public static void findNearestZero(int[] input) {

    int[] result = new int[input.length];
    int counter = input.length;
    for (int i = 0; i < result.length; i++) {
      if (input[i] == 0) {
        counter = 0;
      }
      result[i] = counter;
      counter++;
    }
    counter = input.length;
    for (int i = input.length - 1; i >= 0; i--) {
      if (input[i] == 0) {
        counter = 0;
      }
      result[i] = Math.min(result[i], counter);
      counter++;
    }
    System.out.print(Arrays.toString(result).replaceAll(",", "")
        .replace("[", "")
        .replace("]", ""));
  }

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
      int streetLength = readInt(reader);
      int[] b = readArray(reader, streetLength);
      findNearestZero(b);
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
   * Method to read input stream and return int array
   *
   * @param reader {@code BufferedReader} Reads text from a character-input stream
   * @return int array from input stream
   * @throws IOException if something went wrong
   * @author NVN
   * @since sprint 1
   */
  private static int[] readArray(BufferedReader reader, int streetLength) throws IOException {
    int[] output = new int[streetLength];
    List<String> lineArray = List.of(reader.readLine().trim().split("\\s+"));
    for (int i = 0; i < lineArray.size() && i < streetLength; i++) {
      output[i] = Integer.parseInt(lineArray.get(i));
    }
    return output;
  }
}
