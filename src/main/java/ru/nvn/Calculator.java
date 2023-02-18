package ru.nvn;

import java.util.*;

import java.util.Stack;

public class Calculator {

  public static int calculate(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if (isOperand(token)) {
        stack.push(Integer.parseInt(token));
      } else {
        int num2 = stack.pop();
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
        stack.push(result);
      }
    }
    return stack.pop();
  }

  private static boolean isOperand(String token) {
    return token.matches("-?\\d+");
  }

  public static void main(String[] args) {
    String[] tokens = {"-4", "3", "*", "3", "-", "-5", "-", "/",
        "-7", "-1", "-", "-8", "-10", "-", "+", "*"};
    int result = calculate(tokens);
    System.out.println(result);
  }
}
