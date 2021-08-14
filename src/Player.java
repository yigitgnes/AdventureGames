import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private String playerName;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("-----------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("Id: " + gameChar.getId() + "\tKarakter: " + gameChar.getName() + "\t Hasar: " + gameChar.getDamage() + "\t Sağlık: " + gameChar.getHealth() + "\t Para: " + gameChar.getMoney());
        }
        System.out.println("------------------------------");
        System.out.print("Lütfen Bir Karakter ID'si Seçiniz: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                innitPLayer(new Samurai());
                break;
            case 2:
                innitPLayer(new Archer());
                break;
            case 3:
                innitPLayer(new Knight());
                break;
            default:
                innitPLayer(new Samurai());
        }
        /*System.out.println("Karakter: "+ this.getPlayerName()
                + "\tHasar: "
                + this.getDamage()
                +"\tSağlık: "
                +this.getHealth()
                +"\tPara: "
                +this.getMoney());*/
    }

    public void printInfo(){
        System.out.println(
                "Silahınız: "+this.getInventory().getWeapon().getName()
                +"\tHasar: "
                + this.getDamage()
                +"\tSağlık: "
                +this.getHealth()
                +"\tPara: "
                +this.getMoney());
    }

    public void innitPLayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setPlayerName(gameChar.getName());
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
