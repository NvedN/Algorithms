package ru.nvn;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;

// Аннотация, используемая для пометки методов, подлежащих проверке
@Retention(
    RetentionPolicy
        .RUNTIME) // Указывает, что аннотация будет доступна во время выполнения программы
@Target(ElementType.METHOD)
@interface CorrectImplementation {
  // Ожидаемый возвращаемый тип метода
  Class<?> expectedReturnType() default void.class;

  // Ожидаемые типы параметров метода
  Class<?>[] expectedParameterTypes() default {};
}

public class AnnotationValidator {

  // Метод для валидации
  public static void validateMethods(Object instance) {
    // Получаем класс объекта
    Class<?> clazz = instance.getClass();

    // Итерируем по методам класса
    for (Method method : clazz.getMethods()) {
      // Проверяем наличие аннотации
      if (method.isAnnotationPresent(CorrectImplementation.class)) {
        // Получаем аннотацию
        CorrectImplementation annotation = method.getAnnotation(CorrectImplementation.class);

        // Получаем ожидаемый возвращаемый тип и типы параметров из аннотации
        Class<?> expectedReturnType = annotation.expectedReturnType();
        Class<?>[] expectedParameterTypes = annotation.expectedParameterTypes();

        // Проверяем, соответствует ли фактический возвращаемый тип ожидаемому
        if (!method.getReturnType().equals(expectedReturnType)) {
          // Выводим сообщение об ошибке
          System.out.println(
              "Error: Method "
                  + method.getName()
                  + " has incorrect return type. Expected: "
                  + expectedReturnType.getSimpleName());
          // Ничего не возвращаем, так как мы не ожидаем результата валидации
          return;
        }

        // Получаем фактические типы параметров
        Class<?>[] actualParameterTypes = method.getParameterTypes();

        // Проверяем, соответствуют ли фактические типы параметров ожидаемым
        if (!Arrays.equals(expectedParameterTypes, actualParameterTypes)) {
          // Выводим сообщение об ошибке
          System.out.println(
              "Error: Method "
                  + method.getName()
                  + " has incorrect parameter types. Expected: "
                  + Arrays.toString(expectedParameterTypes));
          // Ничего не возвращаем, так как мы не ожидаем результата валидации
          return;
        }
      }
    }

    // Выводим сообщение об успешной валидации
    System.out.println("All methods are correctly implemented.");
    // Ничего не возвращаем, так как мы не ожидаем результата валидации
  }
}

class MathOperations {
  // Метод для сложения
  @CorrectImplementation(
      expectedReturnType = int.class,
      expectedParameterTypes = {int.class, int.class})
  public int add(int a, int b) {
    return a + b;
  }

  // Метод для деления
  @CorrectImplementation(
      expectedReturnType = double.class,
      expectedParameterTypes = {double.class, double.class})
  public double divide(double a, double b) {
    if (b == 0) {
      throw new IllegalArgumentException("Cannot divide by zero");
    }
    return a / b;
  }

  // Метод для умножения
  @CorrectImplementation(
      expectedReturnType = double.class,
      expectedParameterTypes = {double.class, double.class})
  public double multiply(int a, double b) {
    return a * b;
  }

  public static void main(String[] args) {
    MathOperations mathOperations = new MathOperations();
    // Вызываем метод валидации аннотаций
    AnnotationValidator.validateMethods(mathOperations);
  }
}
