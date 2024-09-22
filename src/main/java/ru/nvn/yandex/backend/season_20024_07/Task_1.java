package ru.nvn.yandex.backend.season_20024_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Task_1 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int solvedTaskTeamA = Integer.parseInt(reader.readLine());
    int solvedTaskTeamB = Integer.parseInt(reader.readLine());
    int maxTaskPerUser = Integer.parseInt(reader.readLine());
    int taskPerUserTeamB = solvedTaskTeamB / maxTaskPerUser + (solvedTaskTeamB % maxTaskPerUser != 0 ? 1 : 0);
    if (solvedTaskTeamA > taskPerUserTeamB) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    reader.close();
    writer.close();
  }
}
