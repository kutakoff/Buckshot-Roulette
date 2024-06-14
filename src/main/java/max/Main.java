package max;

import java.util.ArrayList;
import java.util.Scanner;

import static max.Bullet.getBulletsCount;
import static max.Bullet.getDeathBullets;
import static max.HP.getRandomHP;
import static max.HP.printHPCount;
import static max.InfoPrint.printResult;
import static max.InfoPrint.printWelcomeText;

public class Main {

    public static final String ME = "Me";
    public static final String DEALER = "Dealer";
    public static final String YOU = "You";
    public static final String HIMSELF = "Himself";

    public static int playerHP = getRandomHP();
    public static int dealerHP = playerHP;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        printWelcomeText(scanner);

        printHPCount();
        while (playerHP > 0 && dealerHP > 0) {
            int bulletCount = getBulletsCount();
            int slotNumber = 0;
            ArrayList<Integer> deathBullets = getDeathBullets(bulletCount);
            System.out.println("\nStart's new round");
            System.out.printf("There are %d live cartridge bullets and %d blank cartridge bullets.\n", deathBullets.size(), bulletCount - deathBullets.size());
            do {
                if (dealerHP == 0 || playerHP == 0 || bulletCount - slotNumber <= 0) {
                    break;
                }
                System.out.printf("\nThere are %d/%d bullets left \n", bulletCount - slotNumber, bulletCount);
                slotNumber++;
            } while (Player.checkPlayerTurn(bulletCount, deathBullets, slotNumber, Player.getPlayerAction())); //return true - игра продолжается. return false - dealerHP = 0 || player HP == 0 || кол-во оставшихся патрон = 0
        }
        printResult();
    }
}