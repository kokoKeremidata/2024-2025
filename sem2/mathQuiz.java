import java.io.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.nextLine();
        for(int i = 0; i < 5; i++){
            int num1 = randomNumber();
            int num2 = randomNumber();
            String op = "";
            if(Math.random() < 0.5 && num1 > num2)
                op = "-";
            else
                op = "+";
            String q = question(num1,num2,op);
            System.out.print(q);
            for(int j = 0; j < 5; j++) {
                try{
                    int ans = sc.nextInt();
                    fileWriter(name,q);
                    fileWriter(name,Integer.toString(ans));
                    if(op.equals("+")){
                        if(ans == num1+num2)
                            fileWriter(name," true\n");
                        else
                            fileWriter(name," false\n");
                    }else{
                        if(ans == num1-num2)
                            fileWriter(name," true\n");
                        else
                            fileWriter(name," false\n");
                    }
                    break;
                }catch(Exception e){
                    System.out.println("Invalid symbol");
                    sc.next();
                    System.out.print(q);
                }
            }
        }
    }
    public static void fileWriter(String name, String message){
        String path = "/home/dvangelov26/Informatics/" + name + "-answers.txt";
        try(FileWriter fw = new FileWriter(path, true)){
            fw.write(message);
        }catch(IOException e){
            System.out.println("whoops " + e.getMessage());
        }
    }
    public static int randomNumber(){
        int max = 100;
        int min = 1;
        return (int)(Math.random() * (max - min) + min);
    }
    public static String question(int num1, int num2, String op){
        return "question: " + num1 + " " + op + " " + num2 + " = ";
    }
}
