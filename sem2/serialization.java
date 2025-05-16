import java.io.*;
import java.util.Random;
import java.text.DecimalFormat;
public class Main {
    public static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        String path = "/home/dvangelov26/Informatics/serialization.txt";
        Employee emp = new Employee("dani",18,1000);
        emp.write(path);
        emp.read(path);
    }
}
class Employee implements Serializable{
    String name;
    int age;
    int salary;
    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public void write(String path){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(this);
        }catch(IOException e){
            e.getMessage();
        }
    }
    public void read(String path){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            try{
                while(true){
                    Employee employee = (Employee)ois.readObject();
                    System.out.println(employee.name + " " + employee.age + " " + employee.salary);
                }
            }catch(EOFException e){}
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
