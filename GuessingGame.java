import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    public static void main(String[] args) {
        int attempts = 0;
        int guess = 0;
        boolean guessed = false;
        System.out.println("Welcome to the guessing game! Guess a number between 1 and 100!");
        //generate num
        Random rand = new Random();
        int randomNumber = rand.nextInt(1,101);

        Scanner sc = new Scanner(System.in);

        System.out.println("Take a guess!");

        while(guessed==false){
            if(sc.hasNextInt()){
                guess = sc.nextInt();
                if(guess==randomNumber){
                    System.out.println("Congratulations! You guessed the number!");
                    guessed=true;
                    System.exit(0);
                }else if(guess<randomNumber){
                    System.out.println("Guess higher!");
                }else if(guess>randomNumber){
                    System.out.println("Guess lower!");
                }
                attempts++;
            }else if(sc.hasNextDouble()){
                double number = sc.nextDouble();
                System.out.println("Enter a whole number between 1 and 100!");
            }else if(sc.hasNextLong()){
                long number = sc.nextLong();
                System.out.println("Enter a number between 1 and 100!");
            }else{
                String input = sc.next();
                if (input.equals("Quit")||input.equals("quit")){
                    System.out.println("The number was " + randomNumber + "\nAttempts: " + attempts);
                    System.exit(0);
                }else{
                    System.out.println("Enter a valid statement");
                }
            }
        }
        //System.out.println(randomNumber);
    }
}
