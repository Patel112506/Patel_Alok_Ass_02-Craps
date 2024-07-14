import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Starting a new game of Craps!");
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.printf("You rolled: %d + %d = %d%n", die1, die2, sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.printf("The point is now: %d%n", point);
                boolean pointAchieved = false;

                while (!pointAchieved) {
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.printf("You rolled: %d + %d = %d%n", die1, die2, sum);

                    if (sum == point) {
                        System.out.println("You made your point! You win.");
                        pointAchieved = true;
                    } else if (sum == 7) {
                        System.out.println("Seven out! You lose.");
                        pointAchieved = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Do you want to play again? (Y/N): ");
            String response = scanner.nextLine().trim().toUpperCase();
            playAgain = response.equals("Y");
        }

        scanner.close();
    }
}
