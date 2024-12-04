public class zoo {
    public static void main(String[] args){
        Zoo zoo = new Zoo();
        Habitat h1 = new Habitat("Savannah",1000,30);
        Habitat h2 = new Habitat("Rainforest",1500,28);
        Habitat h3 = new Habitat("Forest",2000,24);
        Habitat h4 = new Habitat("Arctic",1000,-15);
        //composition
        zoo.addAnimal1("Gregory","giraffe",15,h1);
        zoo.addAnimal2("Zeke","monkey",9,h2);
        zoo.addAnimal3("Frederick","brown bear",8,h3);
        zoo.addAnimal4("PenPen","penguin",5,h4);

        Staff s1 = new Staff("Sashko","Feeder",h1);
        Staff s2 = new Staff("Peshko","Maintenance",h2);
        Staff s3 = new Staff("Levi","Cleaner",h3);
        Staff s4 = new Staff("Tedo","manure cleaner",h4);

        s1.assignStaff(h1);
        s2.assignStaff(h2);
        s3.assignStaff(h3);
        s4.assignStaff(h4);
    }
}
class Animal {
    private String name;
    private String species;
    private int age;
    //association
    private Habitat habitat;

    public Animal(String name, String species, int age, Habitat habitat) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.habitat = habitat;
    }
}
class Habitat{
    private String type;
    private int size;
    private int temperature;

    public Habitat(String type, int size, int temperature) {
        this.type = type;
        this.size = size;
        this.temperature = temperature;
    }
    public String getType() {
        return type;
    }
}
class Zoo {
    private Animal a1;
    private Animal a2;
    private Animal a3;
    private Animal a4;
    //composition
    public void addAnimal1(String name, String species, int age, Habitat habitat){
        a1 = new Animal(name,species,age,habitat);
    }
    public void addAnimal2(String name, String species, int age, Habitat habitat){
        a2 = new Animal(name,species,age,habitat);
    }
    public void addAnimal3(String name, String species, int age, Habitat habitat){
        a3 = new Animal(name,species,age,habitat);
    }
    public void addAnimal4(String name, String species, int age, Habitat habitat){
        a4 = new Animal(name,species,age,habitat);
    }
}
class Staff {
    private String name;
    private String role;
    //association
    private Habitat assignedHabitat;

    public Staff(String name, String role, Habitat assignedHabitat) {
        this.name = name;
        this.role = role;
        this.assignedHabitat = assignedHabitat;
    }
    //association
    public void assignStaff(Habitat habitat){
        assignedHabitat = habitat;
        System.out.println(name + " is assigned as " + role + " to " + habitat.getType() + " habitat.");
    }
    public String getName() {
        return name;
    }
}
