package ru.nvn;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlgoUtils {

    public static int readInt(BufferedReader reader) throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static List<Integer> readIntList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().strip().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> readStringLists(BufferedReader reader, int commandsNumber)
            throws IOException {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < commandsNumber; i++) {
            String lineArray = reader.readLine();
            output.add(lineArray);
        }
        return output;
    }

    public static List<List<Integer>> readMatrix(BufferedReader reader) throws IOException {
        String[] sizes = reader.readLine().strip().split(" ");
        int n = Integer.parseInt(sizes[0]);
        List<List<Integer>> matrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            matrix.add(readIntList(reader));
        }
        return matrix;
    }

    public static int[] readIntArray(BufferedReader reader) throws IOException {
        List<String> lineArray = List.of(reader.readLine().trim().split("\\s+"));
        int[] output = new int[lineArray.size()];
        for (int i = 0; i < lineArray.size(); i++) {
            output[i] = Integer.parseInt(lineArray.get(i));
        }
        return output;
    }

    public static String[] readStringArray(BufferedReader reader) throws IOException {
        return reader.readLine().split(" ");
    }
}
