public class Armor {
    private int id;
    private String name;
    private int damage;
    private int price;

    public Armor(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }
    public static Armor[] armors() {
        Armor[] armorlist = new Armor[3];
        armorlist[0] = new Armor(1, "Hafif", 2, 25);
        armorlist[1] = new Armor(2, "Orta", 3, 35);
        armorlist[2] = new Armor(3, "Ağır", 7, 45);
        return armorlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
