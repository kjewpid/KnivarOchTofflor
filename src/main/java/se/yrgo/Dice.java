
package se.yrgo;

import java.util.Random;

public class Dice {
    private final Random random = new Random();


    public int rollCombat() {
        return random.nextInt(4) + 1; // 1–3
    }


    public int roll(String input) {
        String command = input.toLowerCase();

        if (command.equals("roll"))
            return rollCombat();


        return -1;
    }

}