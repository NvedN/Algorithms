package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> numbers = readList(reader);
            System.out.println(getMaxProfit(numbers));
        }
    }

    public static int getMaxProfit(List<Integer> prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i - 1) < prices.get(i)) {
                maxProfit += prices.get(i) - prices.get(i - 1);
            }
        }
        return maxProfit;
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().strip().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }
}
