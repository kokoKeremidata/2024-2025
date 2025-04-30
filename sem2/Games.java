public class Games{
    public static void main(String[] args) {
        Game[] games = {
                new HackNSlash("God of War","Sony",19.99,20.5),
                new HackNSlash("Devil May Cry 5","Capcom",29.99,17),
                new Metroidvania("Metroid","Retro Studios",17,8),
                new Metroidvania("Hollow Knight", "Cherry Team", 14.99,27),
                new Survival("Terraria","Re-Logic",9.99,52),
                new Roguelikelite("Hades","Supergiant Games",24.99,23)
        };
        for(Game game : games){
            game.displayInfo();
            game.pricePerTime();
            game.what();
            System.out.println();
        }
    }
}
class Game{
    String name;
    String studio;
    double price;
    double expPlaytime;
    public Game(String name, String studio, double price, double expPlaytime){
         this.name = name;
         this.studio = studio;
         this.price = price;
         this.expPlaytime = expPlaytime;
    }
    public void displayInfo(){
        System.out.println("Title: " + name + "\nStudio: " + studio + "\nPrice: " + price + "\nExp Playtime: " + expPlaytime);
    }
    public void pricePerTime(){
        System.out.println("On average (main story): " + String.format("%.2f",price/expPlaytime) + "$/h (You will probably play more which costs less per hour)");
    }
    public void what(){

    }
}
class HackNSlash extends Game{
    public HackNSlash(String name, String studio, double price, double expPlaytime){
        super(name, studio, price, expPlaytime);
    }
    public void what(){
        System.out.println("You do fast-paced melee combat in this game");
    }
}
class Metroidvania extends Game{
    public Metroidvania(String name, String studio, double price, double expPlaytime){
        super(name, studio, price, expPlaytime);
    }
    public void what(){
        System.out.println("You do action-adventure platforming with nonlinear exploration and collecting keys");
    }
}
class Survival extends Game{
    public Survival(String name, String studio, double price, double expPlaytime){
        super(name, studio, price, expPlaytime);
    }
    public void what(){
        System.out.println("You survive in an unknown to you new world");
    }
}
class Roguelikelite extends Game{
    public Roguelikelite(String name, String studio, double price, double expPlaytime){
        super(name, studio, price, expPlaytime);
    }
    public void what(){
        System.out.println("You do runs of the game after which most progress gets reset");
    }
}
