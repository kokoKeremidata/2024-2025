import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guessingGameGUI {
    public static void main(String[] args) {
        //UI
        JFrame frame = new JFrame("Guessing game");
        JPanel dialogue = new JPanel(new FlowLayout());
        JLabel dialogueText = new JLabel("Welcome to the guessing game!\nGuess a number between 1 and 100");

        JPanel inputP = new JPanel();
        JTextField userInput = new JTextField(5);
        JButton guessB = new JButton("Guess");

        frame.setLayout(new GridLayout(2,1));
        frame.setSize(500,500);

        frame.add(dialogue);
        dialogue.add(dialogueText);
        frame.add(inputP);
        inputP.add(userInput);
        inputP.add(guessB);
        
        frame.setVisible(true);
        //CODE
        int attempts = 0;
        int guess = 0;
        boolean guessed = false;
        System.out.println("Welcome to the guessing game! Guess a number between 1 and 100!");

        //generate num
        Random rand = new Random();
        int randomNumber = rand.nextInt(1,101);

        Scanner sc = new Scanner(System.in);


        System.out.println("Take a guess!");
        dialogueText.setText("Take a guess!");

        int num1 = Integer.parseInt(userInput.getText());

        while(guessed==false){
            if(sc.hasNextInt()){
                guess = sc.nextInt();
                if(guess==randomNumber){
                    System.out.println("Congratulations! You guessed the number!");
                    dialogueText.setText("Congratulations! You guessed the number!");
                    guessed=true;
                    System.exit(0);
                }else if(guess<randomNumber){
                    System.out.println("Guess higher!");
                    dialogueText.setText("Guess higher!");
                }else if(guess>randomNumber){
                    System.out.println("Guess lower!");
                    dialogueText.setText("Guess lower!");
                }
                attempts++;
            }else if(sc.hasNextDouble()){
                double number = userInput.nextDouble();
                System.out.println("Enter a whole number between 1 and 100!");
                dialogueText.setText("Enter a whole number between 1 and 100!");
            }else if(sc.hasNextLong()){
                long number = sc.nextLong();
                dialogueText.setText("Enter a number between 1 and 100!");
            }else{
                String input = sc.next();
                if (input.equals("Quit")||input.equals("quit")){
                    dialogueText.setText("The number was " + randomNumber + "\nAttempts: " + attempts);
                    System.exit(0);
                }else{
                    dialogueText.setText("Enter a valid statement");
                }
            }
        }

    }
    /*public static void calculate(JTextField guess, boolean guessed, int randomNumber){
       double num1 = Double.parseDouble(numberGuessed.getText());

        while(guessed==false){
            if(sc.hasNextInt()){
                guess = sc.nextInt();
                if(guess==randomNumber){
                    System.out.println("Congratulations! You guessed the number!");
                    dialogueText.setText("Congratulations! You guessed the number!");
                    guessed=true;
                    System.exit(0);
                }else if(guess<randomNumber){
                    System.out.println("Guess higher!");
                    dialogueText.setText("Guess higher!");
                }else if(guess>randomNumber){
                    System.out.println("Guess lower!");
                    dialogueText.setText("Guess lower!");
                }
                attempts++;
            }else if(sc.hasNextDouble()){
                double number = sc.nextDouble();
                System.out.println("Enter a whole number between 1 and 100!");
                dialogueText.setText("Enter a whole number between 1 and 100!");
            }else if(sc.hasNextLong()){
                long number = sc.nextLong();
                dialogueText.setText("Enter a number between 1 and 100!");
            }else{
                String input = sc.next();
                if (input.equals("Quit")||input.equals("quit")){
                    dialogueText.setText("The number was " + randomNumber + "\nAttempts: " + attempts);
                    System.exit(0);
                }else{
                    dialogueText.setText("Enter a valid statement");
                }
            }
        }
       }
    }*/
}
