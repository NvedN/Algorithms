package ru.nvn.yandex.backend.season_20024_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task_438 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String text = reader.readLine();
        List<String> words = Arrays.stream(text.split(" ")).toList();

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String pair = word.substring(i, i + 2);
                map.put(pair, map.getOrDefault(pair, 0) + 1);
            }

        }

        String mostFreqPair = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String pair = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount ||
                    (count == maxCount && pair.compareTo(mostFreqPair) > 0)) {
                mostFreqPair = pair;
                maxCount = count;
            }
        }
        System.out.println(mostFreqPair);

    }
}
