// https://contest.yandex.ru/contest/22781/run-report/82633763/

package ru.nvn.yandexAlgorithmsCourse.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class finalTaskA {

  /**
   * -- ПРИНЦИП РАБОТЫ --
   *
   * <p>В данной реализации используется кольцевой буфер, который представляет собой примитивный
   * массив, который зациклен, т.е. после последнего элемента массива следует первый элемент. Индекс
   * переменной front указывает на первый элемент дека, а индекс переменной back указывает на
   * следующий свободный элемент в деке. Переменная size хранит текущий размер дека.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
   *
   * <p>Для доказательства корректности работы данной реализации необходимо доказать, что все
   * операции push и pop выполняются корректно и не нарушают инварианты кольцевого буфера и свойства
   * дека. Операции push и pop выполняются корректно и не нарушают инварианты кольцевого буфера и
   * свойства дека, поскольку: Операции pushFront и pushBack добавляют элементы в дек, сдвигая
   * указатели front и back соответственно. Если дек заполнен, будет выброшено исключение. Операции
   * popFront и popBack удаляют элементы из дека, сдвигая указатели front и back соответственно.
   * Если дек пуст, будет выброшено исключение. Инварианты кольцевого буфера сохраняются после
   * каждой операции push и pop, так как указатели front и back сдвигаются по кольцевому буферу
   * вправо и влево, а значения переменных front и back всегда остаются в пределах длины буфера.
   * Свойства дека сохраняются после каждой операции push и pop, так как элементы дека упорядочены и
   * добавляются в конец или начало дека в зависимости от выбранной операции. Также дек может
   * содержать произвольное количество элементов в пределах максимального размера, заданного при
   * инициализации.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
   *
   * <p>Временная сложность алгоритма для всех операций push и pop в данной реализации равна O(1),
   * так как все операции выполняются за постоянное время, независимо от количества элементов в
   * деке. Операции push и pop выполняются за константное время, поскольку индексы front и back
   * обновляются по кольцевому буферу, и не требуют перемещения элементов в массиве.
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
   *
   * <p>Пространственная сложность алгоритма реализации дека с использованием кольцевого буфера и
   * примитивного массива составляет O(N), где N - максимальный размер буфера. Данный размер буфера
   * задается при создании экземпляра класса и занимает фиксированное количество памяти. При
   * добавлении или удалении элементов из дека не создается новых объектов, поэтому дополнительная
   * память не выделяется. Таким образом, пространственная сложность зависит только от размера
   * массива-буфера и не зависит от количества элементов в деке.
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
        cb.pushBack(Integer.parseInt(sp[1]));
      }
      if (command.contains("push_front")) {
        String[] sp = command.split(" ");
        cb.pushFront(Integer.parseInt(sp[1]));
      }
      if (command.contains("pop_front")) {
        printPopOperation(cb.popFront());
      }
      if (command.contains("pop_back")) {
        printPopOperation(cb.popBack());
      }
    }
  }

  public static void printPopOperation(int value) {
    if (value != -1) {
      System.out.println(value);
    }
  }

  public static class Deque {

    int[] dq;
    int head = -1;
    int tail = -1;
    int size = 0;

    public Deque(int k) {
      dq = new int[k];
    }

    /** Adds an item at the front of Deque. Return 'error' if deque is overflow. */
    public void pushFront(int value) {
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

    /** Adds an item at the rear of Deque. Return 'error' if deque is overflow. */
    public void pushBack(int value) {
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

    /** Deletes an item from the front of Deque. Return 'error' if deque is empty. */
    public int popFront() {
      if (isEmpty()) {
        System.out.println("error");
        return -1;
      }
      int returnObject = dq[head];
      head = (head + 1) % dq.length;
      size--;
      if (isEmpty()) {
        head = -1;
        tail = -1;
      }
      return returnObject;
    }

    /** Deletes an item from the rear of Deque. Return 'error' if deque is empty. */
    public int popBack() {
      if (isEmpty()) {
        System.out.println("error");
        return -1;
      }
      int returnObject = dq[tail];
      tail = (tail + dq.length - 1) % dq.length;
      size--;
      if (isEmpty()) {
        head = -1;
        tail = -1;
      }
      return returnObject;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
      return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
      return size == dq.length;
    }
  }
}
