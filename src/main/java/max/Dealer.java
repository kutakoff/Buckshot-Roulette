package max;

import java.util.ArrayList;
import java.util.Random;

import static max.HP.printHPCount;
import static max.Main.*;

public class Dealer {

    public static boolean checkDealerTurn(ArrayList<Integer> deathBullets, String dealerAction) {
        if (deathBullets.contains(slotNumber)) {
            System.out.print("Slot number " + slotNumber + " had a live cartridge.");
            if (dealerAction.equalsIgnoreCase(HIMSELF)) {
                dealerHP--;
                System.out.println(" Dealer shot himself, he has -1 defibrillator.");
            } else if (dealerAction.equalsIgnoreCase(YOU)) {
                playerHP--;
                System.out.println(" Dealer shot at you, you have -1 defibrillator.");
            }
            printHPCount();
        } else {
            System.out.println("Slot number " + slotNumber + " had a blank cartridge.");
            if (dealerAction.equalsIgnoreCase(HIMSELF)) {
                System.out.println("Dealer turn again.");
                return true;
            }
        }
        return false;
    }

    public String getDealerAction() {
        Random random = new Random();
        String action = (random.nextBoolean() ? "himself" : "you");
        System.out.println("Dealer decided to shoot " + action);
        return action;
    }
}