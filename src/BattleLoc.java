import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstavleNumber();
        System.out.println("Şuan Buradasınız: " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + obsNumber + " Adet " + this.getObstacle().getName() + " Yaşıyor!");
        System.out.println("<S>avaş veya <K>aç");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S")) {
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz !");
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String selecCombat = input.nextLine().toUpperCase();
                if (selecCombat.equals("V")) {
                    System.out.println("----------------");
                    System.out.println("Siz Vurdunuz !");
                    this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println("------------------");
                        System.out.println("Canavar Size Vurdu !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }

            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı Yendiniz !");
                System.out.println(this.getObstacle().getAward() + " para kazandınız!");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("GÜncel Paranız: " + this.getPlayer().getMoney());
            }
        }

        return false;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("-----------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("-----------------");
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("----------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());

    }

    public int randomObstavleNumber() {
        Random r = new Random();
        return r.nextInt(getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
