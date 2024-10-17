import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("Starting a new game...");

            int dice1 = rollDice(random);
            int dice2 = rollDice(random);
            int sum = dice1 + dice2;

            System.out.println("Initial roll: " + dice1 + " + " + dice2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won.");
            } else {
                int point = sum;
                System.out.println("The point is now: " + point);
                boolean pointAchieved = false;
                boolean rolledSeven = false;

                while (!pointAchieved && !rolledSeven) {
                    dice1 = rollDice(random);
                    dice2 = rollDice(random);
                    sum = dice1 + dice2;

                    System.out.println("Roll: " + dice1 + " + " + dice2 + " = " + sum);

                    if (sum == point) {
                        pointAchieved = true;
                        System.out.println("You made the point and won!");
                    } else if (sum == 7) {
                        rolledSeven = true;
                        System.out.println("You rolled a 7 and lost.");
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            keepPlaying = scanner.nextLine().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
    }

    public static int rollDice(Random random) {
        return random.nextInt(6) + 1;


    }
}