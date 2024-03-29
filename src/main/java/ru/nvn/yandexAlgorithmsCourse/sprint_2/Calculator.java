// https://contest.yandex.ru/contest/22781/run-report/82543317/
package ru.nvn.yandexAlgorithmsCourse.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator {


  /**
   * -- ПРИНЦИП РАБОТЫ --
   * <p>
   * Принцип работы данного алгоритма заключается в использовании стека для хранения операндов и
   * вычисления значения выражения. Алгоритм последовательно проходит по массиву токенов, и для
   * каждого токена выполняет следующие действия: Если токен является операндом, он помещается в
   * стек. Если токен является оператором, из стека извлекаются два операнда, над которыми
   * выполняется операция, и результат помещается в стек. После обработки всех токенов, результат
   * вычисления находится на вершине стека.
   * <p>
   * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
   * <p>
   * Корректность работы алгоритма следует из того, что обратная польская нотация является
   * постфиксной записью выражения, в которой операторы следуют за своими операндами. Это позволяет
   * использовать стек для хранения операндов и выполнения операций в правильном порядке. Также
   * алгоритм использует только базовые арифметические операции и не допускает деления на ноль.
   * <p>
   * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
   * <p>
   * Временная сложность данного алгоритма составляет O(n), где n - количество токенов в выражении.
   * Это связано с тем, что каждый токен обрабатывается только один раз, и каждое извлечение или
   * добавление элемента в стек выполняется за постоянное время.
   * <p>
   * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
   * <p>
   * Пространственная сложность данного алгоритма также составляет O(n), где n - количество токенов
   * в выражении. Это связано с тем, что используется стек для хранения операндов, и его размер
   * может увеличиваться в зависимости от количества операндов в выражении.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    System.out.println(evaluateExpression(input));
  }

  public static int evaluateExpression(String expression) {
    Stack<Integer> stack = new Stack<>();

    // Проходимся по всем элементам в обратной польской нотации
    for (String token : expression.split("\\s")) {
      if (token.matches("[+\\-*/]")) {
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        // Если символ является оператором, выполняем соответствующую операцию
        switch (token) {
          case "+":
            stack.push(operand1 + operand2);
            break;
          case "-":
            stack.push(operand1 - operand2);
            break;
          case "*":
            stack.push(operand1 * operand2);
            break;
          case "/":
            //Сначала приводим делимое к типу double,
            //а затем выполняем деление с помощью оператора /.
            // Результат сохраняется в переменной quotient, которая содержит дробную часть.
            // Затем мы округляем эту дробную часть вниз с помощью метода Math.floor()
            // и приводим результат обратно к типу int.
            double quotient = (double) operand1 / operand2;
            int result = (int) Math.floor(quotient);
            stack.push(result);
            break;
        }
      } else {
        stack.push(Integer.parseInt(token));
      }
    }

    return stack.pop();
  }
}
