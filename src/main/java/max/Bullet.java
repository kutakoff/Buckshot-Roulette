package max;

import java.util.ArrayList;
import java.util.Random;

public class Bullet {

    public static int getBulletsCount() {
        return new Random().nextInt(8) + 2;
    }

    public static ArrayList<Integer> getDeathBullets(int bulletCount) {
        Random random = new Random();
        int deathBulletsCount = random.nextInt(bulletCount / 2) + 1;
        ArrayList<Integer> deathBullets = new ArrayList<>();
        for (int i = 0; i < deathBulletsCount; i++) {
            int randomDigit = random.nextInt(bulletCount) + 1;
            if (!deathBullets.isEmpty()) {
                if (deathBullets.contains(randomDigit)) {
                    i--;
                } else {
                    deathBullets.add(randomDigit);
                }
            } else {
                deathBullets.add(randomDigit);
            }
        }
        return deathBullets;
    }
}
