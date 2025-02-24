import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Car[] cars = {
            new Car("Toyota", "Camry",2020,25000,false),
            new Car("Honda","Civic",2016,15000,true),
            new Car("Ford","Fusion",2019,20000,false),
            new Car("Subaru","Impreza",2014,19000,false)
        };
        displayAll(cars);
        System.out.println(averagePrice(cars));
        mostExpensive(cars);
        displayAvailable(cars);
        int choice = 0;
            System.out.println("Enter option(0 to quit): ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(!cars[0].isLeased){
                        cars[0].displayInfo();
                        leaseCar(cars, 0);
                    }else{
                        System.out.println("Car leased already");
                    }
                    break;
                case 2:
                    if(!cars[1].isLeased){
                        cars[1].displayInfo();
                        leaseCar(cars, 1);

                    }else{
                        System.out.println("Car leased already");
                    }
                    break;
                case 3:
                    if(!cars[2].isLeased){
                        cars[2].displayInfo();
                        leaseCar(cars, 2);

                    }else{
                        System.out.println("Car leased already");
                    }
                    break;
                case 4:
                    if(!cars[3].isLeased){
                        cars[3].displayInfo();
                        leaseCar(cars, 3);

                    }else{
                        System.out.println("Car leased already");
                    }
                    break;
            }
            if(choice == 0){
                System.exit(0);
            }
    }
    public static void mostExpensive(Car[] car){
        int index = 0;
        double price = car[0].price;
        for(int i = 1; i < car.length; i++){
            if(car[i].price > price){
                index = i;
                price = car[i].price;
            }
        }
        System.out.print("Most expensive: ");
        car[index].displayInfo();
    }
    public static double averagePrice(Car[] car){
        double sum = 0;
        for(int i = 0; i < car.length; i++){
            sum += car[i].price;
        }
        System.out.print("average price: ");
        return sum/car.length;
    }
    public static void displayAll(Car[] cars){
        for(Car c : cars){
            c.displayInfo();
        }
    }
    public static void displayAvailable(Car[] cars){
        System.out.println("Available cars:");
        for(Car c : cars){
            if(!c.isLeased){
                c.displayInfo();
            }
        }
    }
    public static void leaseCar(Car[] car, int leaseChoice){
        System.out.println(car[leaseChoice].make + " " + car[leaseChoice].model +" "+ car[leaseChoice].year + " leased");
        car[leaseChoice].isLeased = true;
    }
}
class Car{
    String make;
    String model;
    int year;
    double price;
    boolean isLeased;
    public Car(String make, String model, int year, double price, boolean isLeased){
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isLeased = isLeased;
    }
    public void displayInfo(){
        System.out.println(make + " " + model + " " + year + " " + price + " " + isLeased);
    }
}
