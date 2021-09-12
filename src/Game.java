import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {

        System.out.println("Macera Oyununa Hoşgeldiniz !");

        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);

        System.out.println("Sayın " + player.getName() + ",\nMaceraya Hoşgeldiniz! Bu Macera Sizi Hiç Olmadığınız Biri Yapabilir!!");

        System.out.println("Lütfen Oyuna Başlamak İçin Bir Karakter Seçiniz: ");

        player.selectChar();

        Location location = null;

        while (true) {
            player.printInfo();
            System.out.println("######Bölgeler#######\n ");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");
            System.out.println("3 - Mağara ---> Canavarlı Bölge");
            System.out.println("4 - Orman ---> Canavarlı Bölge");
            System.out.println("5 - Nehir ---> Canavarlı Bölge");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz: ");

            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 0:
                    location=null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (!location.onLocation()){
                System.out.println("GAME OVER!!");
                break;
            }

        }

    }

}
