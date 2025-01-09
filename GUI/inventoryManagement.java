import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String[] args){
        //Create inventory object to access
        Inventory inventory = new Inventory();

        //Create frame
        JFrame frame = new JFrame("Inventory Management");
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(600,400);

        //Make 2 panels and split the top one into two (input on the left, output on the right)
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.setLayout(new GridLayout(1,2));
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout());
        frame.add(panel1);
        frame.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);

        JLabel label = new JLabel("Name:");
        JLabel label2 = new JLabel("Price:");
        JLabel label3 = new JLabel("Quantity:");
        //Create textfields for input
        JTextField eName = new JTextField(20);
        JTextField ePrice = new JTextField(20);
        JTextField eQuantity = new JTextField(20);
        panel3.add(label);
        panel3.add(eName);
        panel3.add(label2);
        panel3.add(ePrice);
        panel3.add(label3);
        panel3.add(eQuantity);

        //Create area to display info
        JTextArea displayDetails = new JTextArea();
        JTextArea output = new JTextArea();
        panel4.add(displayDetails);
        panel4.add(output);

        //Create buttons
        JButton addProduct = new JButton("Add Product");
        JButton updateProduct = new JButton("Update Product");
        JButton display = new JButton("Display Products");
        panel2.add(addProduct);
        panel2.add(updateProduct);
        panel2.add(display);

        //Make buttons work
        addProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Make sure there are values to take
                if(eName.getText().equals("")){
                    output.setText("Invalid product");
                }
                if(ePrice.getText().equals("")){
                    output.setText("Invalid product");
                }
                if(eQuantity.getText().equals("")){
                    output.setText("Invalid product");
                }
                //If the parses fail, stop the program from crashing and just output an error
                try{
                    output.setText( inventory.addProduct(new Product(eName.getText(),Double.parseDouble(ePrice.getText()),Integer.parseInt(eQuantity.getText()))));
                }catch(NumberFormatException nfe){
                    output.setText("Invalid price or quantity");
                }
            }
        });

        updateProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Make sure there are values to take
                if(eName.getText().equals("")){
                    output.setText("Invalid product");
                }
                if(ePrice.getText().equals("")){
                    output.setText("Invalid product");
                }
                if(eQuantity.getText().equals("")){
                    output.setText("Invalid product");
                }
                try{
                    inventory.updateProduct(eName.getText(),Double.parseDouble(ePrice.getText()),Integer.parseInt(eQuantity.getText()));
                    output.setText("Product Updated");
                }catch(NumberFormatException nfe){
                    output.setText("Please choose an existing product\nor enter valid price and quantity");
                }
            }
        });

        display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayDetails.setText(inventory.displayAllProduct());
            }
        });

        frame.setVisible(true);
    }
}
class Product{
    private String name;
    private double price;
    private int quantity;
    //Constructor
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Getters
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
class Inventory{
    private Product[] products;
    private int proCount;

    public Inventory(){
        products = new Product[3];
        proCount = 0;
    }

    public String addProduct(Product product){
        if(product.getPrice()>0 && product.getQuantity()>0) { //check for negative values
            //search for empty slot and add product
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = product;
                    return "Product Added";
                } else if (products[i] != null && i == products.length - 1) {
                    return "Inventory full";
                }
            }
            //stops the same product from being added 3 times from one button press (somehow)
            if (proCount < products.length) {
                products[proCount] = product;
                proCount++;
                return "Product added";
            } else {
                return "Inventory is full";
            }
        }else{
            return "Please enter positive values";
        }
    }

    public void updateProduct(String name, double price, int quantity){
        //search for an existing product with the same name, can only change price and quantity intentionally
        if(price > 0 && quantity>=0) {
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null && products[i].getName().equals(name)) { // Corrected condition
                    products[i].setPrice(price);
                    products[i].setQuantity(quantity);
                }
            }
        }
    }

    public String displayAllProduct(){
        String display = "";
        //find all existing products in the array and add them to the string
        for(int i = 0; i < products.length; i++){
            if (products[i] !=null){
                display += products[i].getName() + "\n" + products[i].getPrice() + "\n" + products[i].getQuantity() + "\n";
            }
        }
        return display;
    }
}
