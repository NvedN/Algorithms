package ru.nvn.yandex.backend.season_20024_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Task_440 {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int d = Integer.parseInt(input[3]);


        int[] players = {a, b, c, d};
        int sum = a + b + c + d;
        int realQueens = 4;

        int minLieCount = Integer.MAX_VALUE;


        for (int queensInDiscard = 0; queensInDiscard <= 2; queensInDiscard++) {
            int availableQueens = realQueens - queensInDiscard;
            if (sum <= availableQueens) {
                minLieCount = 0;
                break;
            }

            Arrays.sort(players);

            int lieCount = 0;
            int currentSum = sum;


            for (int i = players.length - 1; i >= 0; i--) {
                currentSum -= players[i];
                lieCount++;
                if (currentSum <= availableQueens) {
                    break;
                }
            }
            minLieCount = Math.min(minLieCount, lieCount);
        }


        writer.write(minLieCount + "\n");
        writer.flush();

    }
}
