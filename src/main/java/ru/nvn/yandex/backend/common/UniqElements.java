package ru.nvn.yandex.backend.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class UniqElements {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] array = reader.readLine().split(" ");
        Set<String> uniqueElements = new HashSet<>();
        Set<String> notUniqueElements = new HashSet<>();
        for (String element : array) {
            if (uniqueElements.contains(element) || notUniqueElements.contains(element)) {
                uniqueElements.remove(element);
                notUniqueElements.add(element);
            } else {
                uniqueElements.add(element);
            }
        }
        writer.write(String.valueOf(uniqueElements.size()));
        writer.flush();


    }
}
