import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String[] args){
        Inventory inventory = new Inventory();
        //frame
        JFrame frame = new JFrame("Inventory Management");
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(600,600);
        //split into 3 panels using 4 panels
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.setLayout(new GridLayout(1,2));
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout());
        frame.add(panel1);
        frame.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        //textfields
        JTextField eName = new JTextField(15);
        JTextField ePrice = new JTextField(15);
        JTextField eQuantity = new JTextField(15);
        panel3.add(eName);
        panel3.add(ePrice);
        panel3.add(eQuantity);
        //display info
        JTextArea displayDetails = new JTextArea();
        JTextArea output = new JTextArea();
        panel4.add(displayDetails);
        panel4.add(output);
        //click click
        JButton addProduct = new JButton("Add Product");
        JButton updateProduct = new JButton("Update Product");
        JButton display = new JButton("Display Products");
        panel2.add(addProduct);
        panel2.add(updateProduct);
        panel2.add(display);

        //
        addProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                    output.setText( inventory.addProduct(new Product(eName.getText(),Double.parseDouble(ePrice.getText()),Integer.parseInt(eQuantity.getText()))));

                }catch(NumberFormatException nfe){
                    output.setText("Invalid product");
                }
            }
        });
        updateProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                    output.setText("Invalid product");
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
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    //getters
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    //setters
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
        for(int i = 0; i < products.length; i++){
            if(products[i] == null){
                products[i] = product;
                return "Product Added";
            }else if (products[i]!=null && i == products.length-1){
                return "Inventory full";
            }
        }
        if(proCount < products.length){
            products[proCount] = product;
            proCount++;
            return "Product added";
        } else {
            return "Inventory is full";
        }
    }
    public String updateProduct(String name, double price, int quantity){
        for (int i = 0; i < proCount; i++){
                products[i].getName().equals(name);
                products[i].setPrice(price);
                products[i].setQuantity(quantity);
                return "Product updated";
        }
        return "Invalid Product";
    }
    public String displayAllProduct(){
        String display = "";
        for(int i = 0; i < products.length; i++){
            if (products[i] !=null){
                display += products[i].getName() + "\n" + products[i].getPrice() + "\n" + products[i].getQuantity() + "\n";
            }
        }
        return display;
    }

}
