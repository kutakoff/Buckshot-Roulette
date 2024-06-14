package max;

import java.util.ArrayList;
import java.util.Scanner;

import static max.Dealer.checkDealerTurn;
import static max.HP.printHPCount;
import static max.Main.*;

public class Player {

    public static boolean checkPlayerTurn(int bulletCount, ArrayList<Integer> deathBullets, int slotNumber, String playerAction) throws InterruptedException {
        if (deathBullets.contains(slotNumber)) {
            System.out.print("Slot number " + slotNumber + " had a live cartridge.");
            if (playerAction.equalsIgnoreCase(ME)) {
                playerHP--;
                System.out.println(" You shot yourself, you have -1 defibrillator.");
            } else if (playerAction.equalsIgnoreCase(DEALER)) {
                dealerHP--;
                System.out.println(" You shot at the dealer, the dealer has -1 defibrillator.");
            }
            printHPCount();
        } else {
            System.out.println("Slot number " + slotNumber + " had a blank cartridge.");
            if (playerAction.equalsIgnoreCase(ME)) {
                System.out.println("Turn again.");
                return true;
            }
        }
        do {
            if (dealerHP == 0 || playerHP == 0 || bulletCount - slotNumber <= 0) {
                return false;
            }
            Thread.sleep(1500);
            System.out.printf("\nThere are %d/%d bullets left. ", bulletCount - slotNumber, bulletCount);
            slotNumber++;
        } while (checkDealerTurn(slotNumber, deathBullets, new Dealer().getDealerAction()));
        return true;
    }

    public static String getPlayerAction() {
        Scanner scanner = new Scanner(System.in);
        String playerAction;
        do {
            System.out.print("Your turn. Write 'Me' to shoot yourself or 'Dealer' to shoot Dealer: ");
            playerAction = scanner.next();
        } while (!playerAction.equalsIgnoreCase("Me") && !playerAction.equalsIgnoreCase("Dealer"));
        return playerAction;
    }
}