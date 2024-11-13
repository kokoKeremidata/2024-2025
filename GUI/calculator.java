import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator {

    public static void main(String[] args) {

       JFrame frame = new JFrame("calc short for calculator");
       JPanel textboxes = new JPanel(new FlowLayout());
       JTextField textbox1 = new JTextField(10);
       JTextField textbox2 = new JTextField(10);

       JPanel buttonspanel = new JPanel(new FlowLayout());
       JButton add = new JButton("+");
       JButton subs = new JButton("-");
       JButton div = new JButton("/");
       JButton mul = new JButton("*");

       JPanel resultpanel = new JPanel(new FlowLayout());
       JLabel result = new JLabel("0");

       frame.setLayout(new GridLayout(3,1));
       frame.setSize(500,500);

       frame.add(textboxes);
       textboxes.add(textbox1);
       textboxes.add(textbox2);

       frame.add(buttonspanel);
       buttonspanel.add(add);
       buttonspanel.add(subs);
       buttonspanel.add(div);
       buttonspanel.add(mul);
       setStyle(add);
       setStyle(subs);
       setStyle(div);
       setStyle(mul);

       frame.add(resultpanel);
       resultpanel.add(result);

       add.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              calculate('+',textbox1,textbox2,result);
           }
       });
       subs.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              calculate('-',textbox1,textbox2,result);
           }
       });
       div.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              calculate('/',textbox1,textbox2,result);
           }
       });
       mul.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              calculate('*',textbox1,textbox2,result);
           }
       });

       frame.setVisible(true);

    }
    public static void setStyle(JButton button){
       button.setFont(new Font("Arial", Font.BOLD, 45));

    }
    public static void calculate(char operator, JTextField textbox1, JTextField textbox2, JLabel result){
       double num1 = Double.parseDouble(textbox1.getText());
       double num2 = Double.parseDouble(textbox2.getText());

       switch (operator){
          case '+':
             result.setText(String.valueOf(num1+num2));
             break;
          case '-':
             result.setText(String.valueOf(num1-num2));
             break;
          case '*':
             result.setText(String.valueOf(num1*num2));
             break;
          case '/':
             if(num2==0){
                result.setText("Can't divide by 0!");
             }else {
                result.setText(String.valueOf(num1 / num2));
             }
             break;
       }
    }
}
