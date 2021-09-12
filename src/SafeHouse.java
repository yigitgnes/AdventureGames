public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz...\nCanınız Yenilendi...");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealt());
        return true;
    }

}
