package ru.nvn.sprint_8;
import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passportName = scanner.nextLine();
        String databaseName = scanner.nextLine();
        scanner.close();

        if (passportName.equals(databaseName)) {
            System.out.println("OK");
            return;
        }

        if (Math.abs(passportName.length() - databaseName.length()) > 1) {
            System.out.println("FAIL");
            return;
        }

        String shortStr = passportName.length() < databaseName.length() ? passportName : databaseName;
        String longStr = passportName.length() < databaseName.length() ? databaseName : passportName;

        int i = 0, j = 0;
        boolean foundDifference = false;

        while (i < shortStr.length() && j < longStr.length()) {
            if (shortStr.charAt(i) != longStr.charAt(j)) {
                if (foundDifference) {
                    System.out.println("FAIL");
                    return;
                }
                foundDifference = true;
                if (shortStr.length() == longStr.length()) {
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }

        System.out.println("OK");
    }

}
