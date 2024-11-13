import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eventHandling {

    public static void main(String[] args) {

       JFrame frame = new JFrame("clicker game");
       JLabel showCLicks = new JLabel("0");
       JLabel showCLicks0 = new JLabel(" ");
       JButton clickButton = new JButton("click me");
       JButton clickButton1 = new JButton("don't click me");
       JButton resetButton = new JButton("reset");


       frame.setLayout(new GridLayout(3,2));
       frame.setSize(300,300);
       frame.add(showCLicks);
       frame.add(showCLicks0);
       frame.add(clickButton);
       frame.add(clickButton1);
       frame.add(resetButton);

       frame.setVisible(true);

       clickButton.addActionListener(new ActionListener(){

           public void actionPerformed(ActionEvent e){
               int counter = Integer.parseInt(showCLicks.getText());
               counter++;
               showCLicks.setText(String.valueOf(counter));
           }
       });

       clickButton1.addActionListener(new ActionListener(){

           public void actionPerformed(ActionEvent e){
               int counter = Integer.parseInt(showCLicks.getText());
               counter--;
               showCLicks.setText(String.valueOf(counter));
           }
       });
        resetButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                showCLicks.setText("0");
            }
        });

    }
}
