package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());
    List<Interval> intervals = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] timeTokens = reader.readLine().split(" ");
      int start = readTime(timeTokens[0]);
      int end = readTime(timeTokens[1]);
      intervals.add(new Interval(start, end));
    }
    Collections.sort(intervals);
    List<Interval> schedule = new ArrayList<>();
    int lastEnd = 0;
    for (Interval interval : intervals) {
      if (interval.getStart() >= lastEnd) {
        schedule.add(interval);
        lastEnd = interval.getEnd();
      }
    }

    writer.write(schedule.size() + "\n");
    for (Interval interval : schedule) {
      writer.write(formatTime(interval.getStart()) + " " + formatTime(interval.getEnd()) + "\n");
    }

    // Don't forget to close the BufferedWriter
    writer.close();
  }

  private static int readTime(String s) {
    String[] parts = s.split("\\.");
    int h = Integer.parseInt(parts[0]);
    int m = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
    return h * 60 + m;
  }

  private static String formatTime(int t) {
    int h = t / 60;
    int m = t % 60;
    return h + (m == 0 ? "" : "." + m);
  }

  static class Interval implements Comparable<Interval> {
    private final int start;
    private final int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    @Override
    public int compareTo(Interval other) {
      // First, compare by end
      int endComparison = Integer.compare(this.end, other.end);
      if (endComparison != 0) {
        return endComparison;
      }

      // If end values are equal, compare by start
      return Integer.compare(this.start, other.start);
    }
  }
}
