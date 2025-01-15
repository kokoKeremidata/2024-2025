import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        //components
        JFrame frame = new JFrame("Temperature Converter"); //i dont know why when i run the code, the window is missing this title
        JTextField inputField = new JTextField(10);
        JComboBox<String> fromUnitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        JComboBox<String> toUnitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        JLabel resultLabel = new JLabel("Result: ");
        JButton convertButton = new JButton("Convert");
        Font font = new Font("Arial", Font.PLAIN, 30);
        //frame setup
        frame.setSize(350, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set fonts
        inputField.setFont(font);
        fromUnitComboBox.setFont(font);
        toUnitComboBox.setFont(font);
        convertButton.setFont(font);
        resultLabel.setFont(font);
        //add components to frame
        frame.add(new JLabel("Enter Temperature:"){{setFont(font);}});
        frame.add(inputField);
        frame.add(new JLabel("From Unit:"){{setFont(font);}});
        frame.add(fromUnitComboBox);
        frame.add(new JLabel("To Unit:"){{setFont(font);}});
        frame.add(toUnitComboBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setVisible(true);
        //convert button
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Input in = new Input(Double.parseDouble(inputField.getText()),fromUnitComboBox.getSelectedItem().toString(),toUnitComboBox.getSelectedItem().toString());
                    resultLabel.setText("Result: " + in.conversion());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });
    }
}
class Input{
    //variables
    private double input;
    private String from;
    private String to;
    //constructor
    public Input(double input, String from, String to) {
        this.input = input;
        this.from = from;
        this.to = to;
    }
    //getters
    public double getInput() {
        return input;
    }
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    //conversion method
    public double conversion(){
        //converting from celsius
        if(from.equals("Celsius")){
            if(to.equals("Fahrenheit")){
                input = input*1.8+32;
            }
            else if(to.equals("Kelvin")){
                input += 273.15;
            }
        }
        //converting from fahrenheit
        else if(from.equals("Fahrenheit")){
            if(to.equals("Celsius")){
                input = (input-32)/1.8;
            }
            if(to.equals("Kelvin")){
                input = (input-32)/1.8 + 273.15;
            }
        }
        //converting from kelvin
        else if(from.equals("Kelvin")){
            if(to.equals("Celsius")){
                input = input-273.15;
            }
            if(to.equals("Fahrenheit")){
                input = (input-273.15)*1.8+32;
            }
        }
        return input;
    }
}
