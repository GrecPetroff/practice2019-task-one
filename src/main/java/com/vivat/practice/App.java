package com.vivat.practice;


import com.vivat.practice.exception.UnsupportedValue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to console application:");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the name: ");

            String input = scanner.nextLine();

            if ("quit".equals(input)) {
                System.out.println("You quit...");
                break;
            }

            try {
                System.out.println(String.format("Initials of '%s' are '%s'.", input, getInitials(input)));
            } catch (UnsupportedValue ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("-----------\n");
        }

        scanner.close();
    }

    public static String getInitials(String name) {
        StringBuilder result = new StringBuilder();

        // we do not support blank names or names with digits.
        if (name.length() == 0 || name.matches(".*\\d.*")) {
            throw new UnsupportedValue(String.format("Value '%s' is unsupported", name));
        }

        result.append(Character.toUpperCase(name.charAt(0)));

        for (int i = 1; i < name.length() - 1; i++) {
            if (name.charAt(i) == ' ') {
                result.append(" ").append(Character.toUpperCase(name.charAt(i + 1)));
            }
        }

        return result.toString();
    }

}
