package se.yrgo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Knivar och Tofflor");
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();

        Player player = new Player(name);
        Dice dice = new Dice();

        System.out.printf("%n%s, prepare for battle!%n", player.getName());
        play(player, dice, sc);
    }

    private static String welcomePlayer(Scanner sc) {
        System.out.println("Welcome to Knivar och Tofflor");
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        return name;
    }

    private static void play(Player player, Dice dice, Scanner sc) {
        int currentLevel = 1;
        boolean gameOver = false;

        while (currentLevel < 4 && !gameOver) {
            Monster monster = Monster.createRandomMonster(currentLevel);
            System.out.printf("%nA %s enters the room%n", monster.getName());

            while (monster.getHealth() > 0) {
                System.out.printf("%nType roll to play%n");
                String input = sc.nextLine();
                while (dice.roll(input) == -1) {
                    System.out.println("Invalid input");
                    input = sc.nextLine();
                }
                dicePlays(dice.roll(input), player, monster);
                if (player.getHealth() <= 0) {
                    System.out.printf("Which means you lost :p%n", player.getName());
                    gameOver = true;
                    return;
                }
                if (monster.getHealth() <= 0) {
                    System.out.printf("%nTHE %s HAS DIED MWUHAHAHA!!%n", monster.getName().toUpperCase());
                }
            }
            currentLevel++;
        }
        System.out.printf("%s survived all the monsters!! Which means you won!%n", player.getName());
    }

    private static void dicePlays(int i, Player player, Monster monster) {
        switch (i) {
            case 1 -> {
                System.out.printf("%n%s attacks %s with their super blessed and holy knife%n",
                        player.getName(), monster.getName());
                monster.monsterTakesDamage(player.attack());
            }
            case 2 -> {
                System.out.printf("%nOh shiii! The %s attacks %s! Ouch!%n",
                        monster.getName(), player.getName());
                player.takeDamage(monster.getAttack());
            }
            case 3 -> {
                System.out.printf("%nThe %s is distracted by a toffla, so %s takes the time to heal up a little%n",
                        monster.getName(), player.getName());
                player.addHealth();
            }
            case 4 -> {
                System.out.printf("%nThe %s gets scared seeing %ss knife, so %s sharpens it even more just to annoy it%n",
                        monster.getName(), player.getName(), player.getName());
                player.addAttackDamage();
            }
        }
    }

}

