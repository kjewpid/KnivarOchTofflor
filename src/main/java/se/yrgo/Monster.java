    package se.yrgo;

import java.util.Random;

public class Monster {

    private String monsterName;
    private int monsterHealth;
    private int monsterAttack;

    public Monster(String monsterName, int monsterHealth, int monsterAttack) {
        this.monsterName = monsterName;
        this.monsterHealth = monsterHealth;
        this.monsterAttack = monsterAttack;
    }

    public String getName() {
        return monsterName;
    }

    public int getHealth() {
        return monsterHealth;
    }

    public int getAttack() {
        return monsterAttack;
    }

    // STATIC: Create random monster based on player level
    public static Monster createRandomMonster(int currentLevel) {
        Random rand = new Random();

        String[] names;
        int hpMin, hpMax;
        int atkMin, atkMax;

        switch (currentLevel) {
            case 1 -> {
                names = new String[] { "Slime", "Gnome", "Elf" };
                hpMin = 4;
                hpMax = 8;
                atkMin = 1;
                atkMax = 3;
            }
            case 2 -> {
                names = new String[] { "Troll", "Ogre", "Geist" };
                hpMin = 8;
                hpMax = 14;
                atkMin = 4;
                atkMax = 6;
            }
            case 3 -> {
                names = new String[] { "Dragon", "Demon", "Giant" };
                hpMin = 16;
                hpMax = 22;
                atkMin = 8;
                atkMax = 12;
            }
            default ->
                throw new IllegalArgumentException("Invalid level " + currentLevel);
        }

        String monsterName = names[rand.nextInt(names.length)];
        int monsterHealth = rand.nextInt(hpMin, hpMax + 1);
        int monsterAttack = rand.nextInt(atkMin, atkMax + 1);

        return new Monster(monsterName, monsterHealth, monsterAttack);
    }

    // Monster takes damage
    public void monsterTakesDamage(int playerAttack) {
        monsterHealth -= playerAttack;

        if (monsterHealth <= 0) {
            monsterHealth = 0;
        }

        System.out.println(monsterName + " took " + playerAttack + " damage!");
    }
}