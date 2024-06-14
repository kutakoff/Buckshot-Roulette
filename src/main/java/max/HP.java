package max;

import java.util.Random;

import static max.Main.dealerHP;
import static max.Main.playerHP;

public class HP {

    public static int getRandomHP() {
        return new Random().nextInt(5) + 2;
    }

    public static void printHPCount() {
        System.out.println("\n-----------------------------");
        System.out.println("Player's HP = " + (playerHP));
        System.out.println("Dealer's HP = " + (dealerHP));
        System.out.println("-----------------------------");
    }
}
