package ru.nvn.sprint_2;

import java.util.Stack;

public class RpnCalculator {

  public static int calculate(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if (token.matches("-?\\d+")) { // проверяем, является ли токен операндом
        stack.push(Integer.parseInt(token)); // помещаем операнд на вершину стека
      } else { // иначе токен является оператором
        int num2 = stack.pop(); // извлекаем два последних операнда со стека
        int num1 = stack.pop();
        int result;
        switch (token) {
          case "+":
            result = num1 + num2;
            break;
          case "-":
            result = num1 - num2;
            break;
          case "*":
            result = num1 * num2;
            break;
          case "/":
            result = num1 / num2;
            break;
          default:
            throw new IllegalArgumentException("Invalid operator: " + token);
        }
        stack.push(result); // помещаем результат вычисления на вершину стека
      }
    }
    return stack.pop(); // результат вычисления находится на вершине стека
  }

  public static void main(String[] args) {
    System.out.println("-start");
    // пример использования
    String[] tokens = {"-4", "3", "*", "3", "-", "-5", "-", "/",
        "-7", "-1", "-", "-8", "-10", "-", "+", "*"};
    int result = calculate(tokens);
    System.out.println(result); // должно вывести 8
  }
}
