public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-----Mağazaya Hoşgeldiniz!!-----");
        boolean selectMenu = true;
        while (selectMenu) {
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            System.out.print("Seçim: ");
            int selectCase = Location.input.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz Değer, Lütfen Geçerli Bir Değer Giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWepon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir Daha Bekleriz...");
                    selectMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("---Silahlar---\n");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getName() + "\t < ID: " + w.getId() + "\tÜcret: " + w.getPrice() + "\t Hasar: " + w.getDamage() + " >");
        }
        System.out.println("0 - Çıkış Yap");

    }

    public void buyWepon() {

        System.out.print("Bir Silah Seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, Lütfen geçerli bir değer giriniz!!");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Paranız Bulunmamaktadır!");
                } else {
                    System.out.println(selectedWeapon.getName() + " Silahı satın alındı!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
        }
    }

    public void printArmor() {
        System.out.println("---Silahlar---\n");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getName() + "\t < ID: " + a.getId() + "\tÜcret: " + a.getPrice() + "\t Savunma: " + a.getBlock() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyArmor() {

        System.out.print("Bir Zırh Seçiniz: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, Lütfen geçerli bir değer giriniz!!");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Paranız Bulunmamaktadır!");
                } else {
                    System.out.println(selectedArmor.getName() + " Zırhı satın alındı!");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);

                }
            }
        }
    }
}
