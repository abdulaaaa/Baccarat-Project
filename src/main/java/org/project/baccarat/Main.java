package org.project.baccarat;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        boolean validInput = false;
        int option = 0;
        int betAmount = 0;


        System.out.println("Welcome to baccarat!");

        Scanner scanner = new Scanner(System.in);
        while (!validInput) {
            try {
                System.out.print("Who do you want to bet on Player(1), Tie(2), Banker(3): ");
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (option >= 1 && option <= 3) {
                    validInput = true; // Set validInput to true only if the input is within the valid range
                } else {
                    System.out.println("Please enter a valid option (1, 2, or 3).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter how much you want to bet: ");
                betAmount = scanner.nextInt();
                scanner.nextLine();

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        validInput = false;


        Game game = new Game(option, betAmount);

        game.setRatioForBankerPlayerTie(option);

        game.initializePlayerAndBanker();

        game.updateAmountOfMoney();

        scanner.close();

    }
}