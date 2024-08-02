package ru.nvn.yandex.backend.season_20024_07;

import ru.nvn.AlgoUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> lineArray = List.of(reader.readLine().trim().split("\\s+"));

        int[] a = AlgoUtils.readIntArray(reader);
        int[] stops = AlgoUtils.readIntArray(reader);
        int[] requests = AlgoUtils.readIntArray(reader);

        int stopsCount = a[0]; // Количество остановок
        int requestsCount = a[1]; // Количество запросов
        for (int requestNum = 0; requestNum < requestsCount; requestNum++) {
            int x = requests[requestNum];
            int minDist = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int stopNum = 0; stopNum < stopsCount; stopNum++) {
                int dist = Math.abs(stops[stopNum] - x);
                if (dist < minDist) {
                    minDist = dist;
                    minIndex = stopNum;
                }
            }
            System.out.println(minIndex + 1);
        }

        reader.close();
        writer.close();
    }
}


