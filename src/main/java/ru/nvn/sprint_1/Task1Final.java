// ID успешной посылки 82027234

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
   * @return an array with each element counted up to the nearest zero
   * @author NVN
   * @since sprint 1
   */
  public static int[] findZero(int[] input) {
    int[] zeroBefore = new int[input.length];
    int[] zeroAfter = new int[input.length];
    int[] result = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      zeroBefore[i] = input[i] == 0 ? 0 : input.length;
      zeroAfter[i] = input[i] == 0 ? 0 : input.length;
    }
    for (int i = 1; i < input.length; i++) {
      zeroBefore[i] = input[i] == 0 ? 0 : zeroBefore[i - 1] + 1;
    }
    for (int i = input.length - 2; i >= 0; i--) {
      zeroAfter[i] = input[i] == 0 ? 0 : zeroAfter[i + 1] + 1;
    }
    for (int i = 0; i < input.length; i++) {
      result[i] = Math.min(zeroBefore[i], zeroAfter[i]);
    }
    return result;
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
      int[] b = readListArray(reader, streetLength);
      System.out.println(Arrays.toString(findZero(b)).replace(",", "")
          .replace("[", "")
          .replace("]", ""));
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
  private static int[] readListArray(BufferedReader reader, int streetLength) throws IOException {
    int[] a = new int[streetLength];
    List<String> lineArray = List.of(reader.readLine().trim().split("\\s+"));
    for (int i = 0; i < lineArray.size() && i < streetLength; i++) {
      a[i] = Integer.parseInt(lineArray.get(i));
    }
    return a;
  }
}
