//https://contest.yandex.ru/contest/22781/run-report/82540159/

package ru.nvn.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Deque {

  /**
   * Кольцевой буфер - это способ реализации очереди на основе примитивного массива, в котором
   * элементы сохраняются последовательно, но когда очередь достигает конца массива, она
   * переписывается в начало массива. Это позволяет нам эффективно использовать память и избежать
   * переполнения массива
   * <p>
   * Мы создаем массив buffer фиксированного размера k для хранения элементов, head и tail - индексы
   * начала и конца очереди, а size - максимальный размер очереди.
   * <p>
   * <p>
   * Реализация дека на основе кольцевого буфера имеет следующую оценку времени выполнения:
   * <p>
   * push_front, push_back, pop_front, pop_back - O(1) Таким образом, все операции вставки и
   * удаления элементов в дек выполняются за постоянное время O(1), что делает эту реализацию
   * эффективной для большинства задач, где необходимо использовать дек.
   * <p>
   * Однако стоит заметить, что фактический размер буфера всегда равен size - 1, потому что мы
   * всегда оставляем один элемент пустым, чтобы отличить пустую очередь от полной. Кроме того,
   * использование массива фиксированного размера может привести к переполнению при попытке вставить
   * больше элементов, чем было задано при создании дека. Поэтому перед использованием этой
   * реализации необходимо оценить максимальный размер очереди и убедиться, что этот размер не будет
   * превышен в процессе выполнения программы.
   */

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int commandsNumber = readInt(reader);
      int dequeSize = readInt(reader);
      List<String> commandsList = readList(reader, commandsNumber);
      printDeque(commandsList, dequeSize);
    }
  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

  private static List<String> readList(BufferedReader reader, int commandsNumber)
      throws IOException {
    List<String> output = new ArrayList<>();
    for (int i = 0; i < commandsNumber; i++) {
      String lineArray = reader.readLine();
      output.add(lineArray);
    }
    return output;
  }

  public static void printDeque(List<String> queue, int dequeSize) {
    Deque cb = new Deque(dequeSize);
    for (String command : queue) {
      if (command.contains("push_back")) {
        String[] sp = command.split(" ");
        cb.push_back(Integer.parseInt(sp[1]));
      }
      if (command.contains("push_front")) {
        String[] sp = command.split(" ");
        cb.push_front(Integer.parseInt(sp[1]));
      }
      if (command.contains("pop_front")) {
        cb.pop_front();
      }
      if (command.contains("pop_back")) {
        cb.pop_back();
      }
    }
  }

  int[] dq;
  int head = -1;
  int tail = -1;
  int size = 0;


  public Deque(int k) {
    dq = new int[k];
  }

  /**
   * Adds an item at the front of Deque. Return 'error' if deque is overflow.
   */
  public void push_front(int value) {
    if (isFull()) {
      System.out.println("error");
      return;
    }
    if (head == -1) {
      tail = (tail + 1) % dq.length;
      head = 1;
    }
    head = (head + dq.length - 1) % dq.length;
    dq[head] = value;
    size++;
  }

  /**
   * Adds an item at the rear of Deque. Return 'error' if deque is overflow.
   */
  public void push_back(int value) {
    if (isFull()) {
      System.out.println("error");
      return;
    }
    if (head == -1) {
      head = 0;
    }
    tail = (tail + 1) % dq.length;
    dq[tail] = value;
    size++;
  }

  /**
   * Deletes an item from the front of Deque.  Return 'error' if deque is empty.
   */
  public void pop_front() {
    if (isEmpty()) {
      System.out.println("error");
      return;
    }
    System.out.println(dq[head]);
    head = (head + 1) % dq.length;
    size--;
    if (isEmpty()) {
      head = -1;
      tail = -1;
    }
  }

  /**
   * Deletes an item from the rear of Deque. Return 'error' if deque is empty.
   */
  public void pop_back() {
    if (isEmpty()) {
      System.out.println("error");
      return;
    }
    System.out.println(dq[tail]);
    tail = (tail + dq.length - 1) % dq.length;
    size--;
    if (isEmpty()) {
      head = -1;
      tail = -1;
    }
  }


  /**
   * Checks whether the circular deque is empty or not.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Checks whether the circular deque is full or not.
   */
  public boolean isFull() {
    return size == dq.length;
  }


}
