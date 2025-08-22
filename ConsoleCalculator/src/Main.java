import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Console Calculator!");

        boolean continueCalculating = true;

        while (continueCalculating) {
            double num1 = getNumberInput("Enter the first number: ");
            double num2 = getNumberInput("Enter the second number: ");
            char operation = getOperationInput();

            double result;

            switch (operation) {
                case '+':
                    result = add(num1, num2);
                    System.out.printf("Result: %.2f + %.2f = %.2f%n", num1, num2, result);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    System.out.printf("Result: %.2f - %.2f = %.2f%n", num1, num2, result);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    System.out.printf("Result: %.2f * %.2f = %.2f%n", num1, num2, result);
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                    } else {
                        result = divide(num1, num2);
                        System.out.printf("Result: %.2f / %.2f = %.2f%n", num1, num2, result);
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operation. Please try again.");
                    break;
            }

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                continueCalculating = false;
            }
        }

        System.out.println("Thank you for using the Console Calculator. Goodbye!");
        scanner.close();
    }

    private static double getNumberInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    private static char getOperationInput() {
        while (true) {
            System.out.print("Enter an operation (+, -, *, /): ");
            String input = scanner.next();
            if (input.length() == 1) {
                char operation = input.charAt(0);
                if (operation == '+' || operation == '-' || operation == '*' || operation == '/') {
                    return operation;
                }
            }
            System.out.println("Invalid operation. Please enter +, -, *, or /.");
        }
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        return a / b;
    }
}
