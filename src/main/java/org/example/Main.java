package org.example;

import java.util.Scanner;

public class Main {

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Scientific Calculator Menu ===");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number for square root: ");
                    double number = scanner.nextDouble();
                    if (number < 0) {
                        System.out.println("Error: Cannot compute square root of a negative number.");
                    } else {
                        System.out.println("Square root of " + number + " is " + Math.sqrt(number));
                    }
                    break;

                case 2:
                    System.out.print("Enter a non-negative integer for factorial: ");
                    int n = scanner.nextInt();
                    if (n < 0) {
                        System.out.println("Error: Factorial is not defined for negative numbers.");
                    } else {
                        System.out.println("Factorial of " + n + " is " + factorial(n));
                    }
                    break;

                case 3:
                    System.out.print("Enter a positive number for natural logarithm: ");
                    double value = scanner.nextDouble();
                    if (value <= 0) {
                        System.out.println("Error: Natural logarithm is defined for positive numbers only.");
                    } else {
                        System.out.println("Natural logarithm of " + value + " is " + Math.log(value));
                    }
                    break;

                case 4:
                    System.out.print("Enter the base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the exponent: ");
                    double exponent = scanner.nextDouble();
                    System.out.println(base + " raised to the power " + exponent + " is " + Math.pow(base, exponent));
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting calculator. Goodbye!");
                    break;
  //assas
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-5).");
            }
            System.out.println();
        }

        scanner.close();
    }
}
