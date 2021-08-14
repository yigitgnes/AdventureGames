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
            System.out.println("2 - Mağaza\n");
            System.out.print("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz: ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
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
