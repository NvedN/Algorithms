// https://contest.yandex.ru/contest/22781/run-report/82543317/
package ru.nvn.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator {


  /**
   * Алгоритм решения выражения в обратной польской нотации с использованием стека выглядит
   * следующим образом:
   * <p>
   * Создаем пустой стек для хранения операндов. Разбиваем выражение на отдельные символы. Для
   * каждого символа: Если символ является операндом, добавляем его в стек. Если символ является
   * оператором, извлекаем два последних операнда из стека, выполняем соответствующую операцию, и
   * добавляем результат обратно в стек. После обработки всего выражения результат должен находиться
   * на вершине стека. Извлекаем его из стека и возвращаем как результат.
   * <p>
   * <p>
   * Сложность алгоритма решения выражения в обратной польской нотации с использованием стека
   * зависит от количества символов в выражении. При каждой операции алгоритм вытаскивает из стека
   * два операнда и выполняет над ними операцию, после чего результат помещается в стек. Таким
   * образом, каждый символ в выражении обрабатывается ровно один раз.
   * <p>
   * В худшем случае, когда выражение уже находится в обратной польской нотации и не требует
   * дополнительных преобразований, сложность алгоритма составляет O(n), где n - количество символов
   * в выражении.
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
