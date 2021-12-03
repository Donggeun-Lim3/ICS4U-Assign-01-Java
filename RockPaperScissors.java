/*
* This program gets user's choice, converts the choice to integer in enum,
* generate random number between 0 to 2, matches with these two numbers
* and show the converted random choice and result.
*
* @author  Donggeun Lim
* @version 1.0
* @since   2021-12-03
*/

import java.util.Random;
import java.util.Scanner;

/**
* This is the rock paper sissors game program.
*/
public final class RockPaperScissors {
    // constant
    /** Rock, paper and scissors. */
    static final int CHOICES = 3;

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private RockPaperScissors() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Rock paper sissors game process.
    */
    public enum Choice {
        /** Rock : 0, Paper : 1, Scissors : 2. */
        ROCK(0), PAPER(1), SCISSORS(2);

        /** Integer value of rock, paper scissors. */
        private final int value;

        /**
        * This method uses num = value.
        *
        * @param num - positive integer
        */
        Choice(final int num) {
            value = num;
        }

        /**
        * This method returns choice as integer.
        *
        * @return value
        */
        private int choiceNumber() {
            return value;
        }
    }

    /**
    * This method gets gets user's choice, converts the choice to integer,
    * matches with random number and shows the random choice and result.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        final Scanner myObj = new Scanner(System.in);
        final Random random = new Random();
        final Choice userChoice;
        String computerChoice;
        String result = "";

        // Input
        System.out.print("Rock, Paper, Scissors?\nYOU: ");
        final String userInput = myObj.nextLine();

        // Generate random number for computer's choice
        final int randomChoice = random.nextInt(CHOICES);

        try {
            userChoice = Choice.valueOf(userInput.toUpperCase());

            // Check win, lose or tie
            if (userChoice.choiceNumber() == randomChoice) {
                result = "tie!";
            }
            else if (userChoice.choiceNumber()
                                == (randomChoice + 1) % CHOICES) {
                result = "win!";
            }
            else {
                result = "lose!";
            }
            // Convert computer's choice to String ex: ROCK => Rock
            computerChoice = Choice.values()[randomChoice].name();
            computerChoice = computerChoice.substring(0, 1)
                             + computerChoice.substring(1).toLowerCase();

            // Output
            System.out.println("COM: " + computerChoice);
            System.out.println("You " + result);

        }
        catch (IOException exception) {
            System.err.print("Invalid input.\n");
        }

        System.out.println("\nDone.");
    }
}
