import java.util.Random;
import java.util.Scanner;

public class Task2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;
        int maxRounds = 3;
        int range = 100; 

        System.out.println("Enter the maximum number of attempts per round (default is 5): ");
        maxAttempts = scanner.nextInt();
        
        System.out.println("Enter the total number of rounds (default is 3): ");
        maxRounds = scanner.nextInt();
        
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("You have " + maxRounds + " rounds to guess the number between 1 and " + range + ".");
        System.out.println("Points are given based on how quickly you guess the number.\n");

        for (int round = 1; round <= maxRounds; round++) {
            System.out.println("Round " + round + ":");

            int numberToGuess = random.nextInt(range) + 1;
            boolean guessed = false;
            int attempts = 0;

            while (attempts < maxAttempts && !guessed) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessed = true;
                    totalScore += getPoints(attempts);
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your score after round " + round + " is: " + totalScore + "\n");
        }

        System.out.println("Game over! Your total score is: " + totalScore);
        scanner.close();
    }

    public static int getPoints(int attempts) {
        if (attempts == 1) {
            return 10;
        } else if (attempts == 2) {
            return 7;
        } else if (attempts == 3) {
            return 5;
        } else if (attempts == 4) {
            return 3;
        } else {
            return 1;
        }
    }
}