package max;

import java.util.Scanner;

import static max.Main.playerHP;

public class InfoPrint {

    public static void printWelcomeText(Scanner scanner) throws InterruptedException {
        String s1 = "Welcome to the Russian roulette! Write something to start: ";
        for (int i = 0; i < s1.length(); i++) {
            System.out.print(s1.charAt(i));
            Thread.sleep(30);
        }
        scanner.nextLine();
        String s2 = "The rules: there are 2 players: Dealer and you. \nAlso choose the action: shoot yourself or shoot the Dealer. \nBy shooting yourself you are saving your turn to shoot. \nBut be careful! Each of you have only 2 defibrillators to back yourself to life. \nDealer have no mercy!";
        for (int i = 0; i < s2.length(); i++) {
            System.out.print(s2.charAt(i));
            Thread.sleep(20);
        }
        String s3 = "\nWrite something to start the game: ";
        for (int i = 0; i < s3.length(); i++) {
            System.out.print(s3.charAt(i));
            Thread.sleep(20);
        }
        scanner.nextLine();
    }

    public static void printResult() {
        System.out.println("\n-----------------------------");
        if (playerHP == 0) {
            System.out.println("You lose. Keep careful next time.");
        } else {
            System.out.println("You win. Good job.");
        }
        System.out.println("-----------------------------");
    }
}
