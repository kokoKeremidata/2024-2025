import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[5];
        products[0] = new Product(1,"Cola",1.50,10);
        products[1] = new Product(2,"Pepsi",2.50,9);
        products[2] = new Product(3,"Fanta",2.00,7);
        products[3] = new Product(4,"Water",0.50,4);
        products[4] = new Product(5,"Chips",3.50,6);

        System.out.println("#|NAME|PRICE|QUANTITY");
        for(int i = 0; i < products.length; i++){
            System.out.println(products[i].display());
        }
        for(int i = 0; i>=0; i++) {
            System.out.println("Insert item code (0 to exit): ");
            double input = sc.nextInt();
            if (input == 0) {
                System.exit(0);
            }
            for (int j = 0; j < products.length; j++){
                if (input == products[j].code) {
                    System.out.println("Insert " + products[j].price + " for " + products[j].name);
                    int insert = sc.nextInt();
                    if (insert == products[j].price) {
                        System.out.println(products[j].name + " has been dispensed.");
                        products[j].quantity--;
                    } else if (insert > products[j].price) {
                        System.out.println(products[j].name + " has been dispensed. Your change is " + (insert - products[j].price));
                        products[j].quantity--;
                    } else if (insert < products[j].price) {
                        System.out.println("Not enough money inserted.");
                    }
                }
            }
            for(int k = 0; k < products.length; k++){
                System.out.println(products[k].display());
            }
        }
    }
}
class Product{
    int code;
    String name;
    double price;
    int quantity;
    public Product(int code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String display(){
        return "#"+code+"\t"+name+"\t"+price+"\t"+quantity;
    }
}
