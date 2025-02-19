import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] titles = {"Book1", "Book2", "Book3", "Book4", "Book5"};
        double[] prices = {20.59, 19.49, 18.59, 15.69, 19.99};
        int[] quantity = {10, 8, 5, 11, 9};
        for (int i = 0; i >= 0; i++) {
            displayInfo(titles, prices, quantity);
            System.out.println("Type a number to select book or search for a book title (exit to quit)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            try {
                int bookNum = Integer.parseInt(input);
                if(bookNum >= 1 && bookNum <= titles.length) {
                    bookNum--;
                    buy(bookNum, titles, prices, quantity);
                }else{
                    System.out.println("Invalid number");
                }
            } catch (Exception e) {
                search(input, titles, prices, quantity);
            }
        }
    }
    public static void displayInfo(String[] titles, double[] prices, int[] quantity) {
        for (int i = 0; i < titles.length; i++) {
            System.out.println("#" + (i + 1) + " " + titles[i] + "\t" + prices[i] + "\tIn Stock: " + quantity[i]);
        }
    }
    public static void search(String input, String[] titles, double[] prices, int[] quantity) {
        Scanner sc = new Scanner(System.in);
        boolean inStock = false;
        for(int i = 0; i < input.length(); i++) {
            if (input.equalsIgnoreCase(titles[i])) {
                System.out.println("#" + (i + 1) + " " + titles[i] + "\t" + prices[i] + "\tIn Stock: " + quantity[i]);
                buy(i,titles,prices,quantity);
                inStock = true;
                break;
            }
        }
        if(!inStock){
            System.out.println("No result found");
        }
    }
    public static void buy(int input, String[] titles,double[] prices, int[] quantity){
        Scanner sc = new Scanner(System.in);
        if (quantity[input] > 0) {
            System.out.println(titles[input] + " costs " + prices[input] + "\nInput card balance: ");
            int card = sc.nextInt();
            if (card >= prices[input]) {
                System.out.println(titles[input] + "bought successfully.");
                quantity[input]--;
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Not in stock");
        }
    }
}
