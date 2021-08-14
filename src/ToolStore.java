public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-----Mağazaya Hoşgeldiniz!!-----");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış Yap");
        System.out.print("Seçim: ");
        int selectCase = Location.input.nextInt();
        while (selectCase <1 ||selectCase>3){
            System.out.print("Geçersiz Değer, Lütfen Geçerli Bir Değer Giriniz: ");
            selectCase = input.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapon();
                buyWepon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Bir Daha Bekleriz...");
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("---Silahlar---\n");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getName() +  "\t < ID: "+w.getId()+ "\tÜcret: "+w.getPrice()+"\t Hasar: "+ w.getDamage()+" >");
        }


    }
    public void buyWepon(){

        System.out.print("Bir Silah Seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Geçersiz değer, Lütfen geçerli bir değer giriniz!!");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if(selectedWeapon!=null){
            if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                System.out.println("Yeterli Paranız Bulunmamaktadır!");
            }else{
                System.out.println(selectedWeapon.getName()+" Silahı satın alındı!");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paranız: "+this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);

            }
        }
    }

    public void printArmor(){
        System.out.println("Zırhlar");
    }
}
