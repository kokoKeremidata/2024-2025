import java.io.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String name = sc.nextLine();
        for(int i = 0; i >= 0; i++){
            System.out.println("Add prodcut (type done to exit): ");
            String in = sc.nextLine();
            if(in.equals("done")){
                break;
            }
            fileWriter(name,in);

        }
    }
    public static void fileWriter(String fileName, String message){
        String path = "/home/dvangelov26/Informatics/" + fileName + ".txt";
        try(FileWriter fw = new FileWriter(path, true)){
            fw.write(message+"\n");
            System.out.println("write successful");
        }catch(IOException e){
            System.out.println("whoops " + e.getMessage());
        }
    }
}
