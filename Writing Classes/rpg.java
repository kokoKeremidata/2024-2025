public class rpg {

    public static void main(String[] args){
        Wizard wizard = new Wizard("Merlin",100, 10,4);
        Warrior warrior = new Warrior("Ragnar",100,7,7);
        // Task 5: Create an object/instance of your new character's class.
        Ranger archer = new Ranger("Sasha",100,8,2);

        System.out.println(wizard.getName() + "'s health: " + wizard.getHealth());
        System.out.println(warrior.getName()+"'s health: " + warrior.getHealth());
        System.out.println("Game is starting...");
        wizard.setHealthW(warrior);
        System.out.println( warrior.getName()+" attacks " + wizard.getName() + ". Health updated: " + wizard.getHealth());

        // Task 6: make the wizard attack your new character.
        archer.setHealthWi(wizard);
        System.out.println(wizard.getName()+" attacks " + archer.getName() + ". Health updated: " + archer.getHealth());
        // Task 7: display the new stats
        System.out.println(archer.getName() + "'s health: " + archer.getHealth());


        // CHALLENGE: Update your program for all the characters to be able to attack each other.
    }
}


class Wizard {
    private String name;
    private int health;
    private int darkMagic;
    private int wizardArmor;

    public Wizard(String name, int health, int darkMagic, int wizardArmor){
        this.name = name;
        this.health = health;
        this.darkMagic = darkMagic;
        this.wizardArmor = wizardArmor;
    }

    public String getName() {
        return name;
    }

    public void setHealthW(Warrior attack) {
        health = health - (attack.getSword() - wizardArmor);
    }
    public void setHealthR(Ranger attack){
        health = health - (attack.getBow() - wizardArmor);
    }

    public int getHealth() {
        return health;
    }
    public int getDarkMagic() {
        return darkMagic;
    }

}

class Warrior {
    private String name;
    private int health;
    private int sword;
    private int metalArmor;

    public Warrior(String name, int health, int sword, int metalArmor){
        this.name = name;
        this.health = health;
        this.sword = sword;
        this.metalArmor = metalArmor;
    }

    public String getName() {
        return name;
    }

    public int getSword() {
        return sword;
    }

    public int getHealth() {
        return health;
    }

    public void setHealthW(Wizard attack) {
        health = health - (attack.getDarkMagic() - metalArmor);
    }

    public void setHealthR(Ranger attack) {
        health = health - (attack.getBow() - metalArmor);
    }

}
class Ranger {
    private String name;
    private int health;
    private int bow;
    private int stealthArmor;

    public Ranger(String name, int health, int bow, int stealthArmor){
        this.name = name;
        this.health = health;
        this.bow = bow;
        this.stealthArmor = stealthArmor;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getBow() {
        return bow;
    }

    public void setHealthWi(Wizard attack) {
        health = health - (attack.getDarkMagic() - stealthArmor);
    }

    public void setHealthWa(Warrior attack) {
        health = health - (attack.getSword() - stealthArmor);
    }
}
