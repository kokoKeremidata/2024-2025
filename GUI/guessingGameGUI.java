import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guessingGameGUI {
    private static int randomNumber;

    public static void main(String[] args) {
        //UI
        //Panel 1
        JFrame frame = new JFrame("Guessing game");
        JPanel dialogue = new JPanel(new FlowLayout());
        JLabel dialogueText = new JLabel("Welcome to the guessing game!\nGuess a number between 1 and 100");
        //Panel 2
        JPanel inputP = new JPanel();
        JTextField userInput = new JTextField(5);
        JButton guessB = new JButton("Guess");
        //Panel 3
        JPanel control = new JPanel();
        JButton quit = new JButton("Quit");
        JButton newGame = new JButton("New Game");
        //Frame
        frame.setLayout(new GridLayout(3,1));
        frame.setSize(500,500);

        frame.add(dialogue);
        dialogue.add(dialogueText);
        frame.add(inputP);
        inputP.add(userInput);
        inputP.add(guessB);
        frame.add(control);
        control.add(quit);
        control.add(newGame);

        setStyleL(dialogueText);
        setStyleT(userInput);
        setStyleB(guessB);
        setStyleB(quit);
        setStyleB(newGame);

        frame.setVisible(true);

        //CODE
        Random rand = new Random();
        randomNumber = rand.nextInt(1,101);

        dialogueText.setText("Take a guess!");

        guessB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean guessed = false;
                int attempts = 0;
                try {
                    int num1 = Integer.parseInt(userInput.getText());
                    if(num1 == randomNumber){
                        dialogueText.setText("Congratulations! You guessed the number!");
                        guessed=true;
                    }else if (num1>100 || num1<1) {
                        dialogueText.setText("Please enter a number between 1 and 100!");
                    }else if(num1<randomNumber){
                        dialogueText.setText("Guess higher!");
                    }else if(num1>randomNumber){
                        dialogueText.setText("Guess lower!");
                    }
                    attempts++;
                }
                catch (NumberFormatException a) {
                    dialogueText.setText("Invalid input");
                }
            }
        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                randomNumber = rand.nextInt(1,101);
                dialogueText.setText("Take a guess!");
                userInput.setText("");
            }
        });

    }
    public static void setStyleB(JButton button){
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    }
    public static void setStyleL(JLabel button){
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    }
    public static void setStyleT(JTextField button){
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    }
}
