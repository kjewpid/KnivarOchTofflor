package se.yrgo;

/**
 * Represents a player.
 *
 * @author Josephine Jelkeby Ginguene
 * @version 25
 * @since 25
 */

public class Player {
    private String name;
    private int health;
    private int attack;

    /**
     * Creates a player. If name is null, an IllegalArgumentException is thrown.
     *
     * @param name The player's name
     */
    public Player(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        this.health = 10;
        this.attack = 10;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    /**
     * Increases the Player's health by 5.
     * If adding 5 would exceed the max health of 30,
     * the health is set to 30 and a message is printed
     * to notify the user.
     */
    public void addHealth() {
        if (health + 5 > 30){
            health = 30;
            System.out.println("Max player health reached.");
        } else {
            health += 5;
        }
    }

    public void addAttackDamage() {
        attack += 10;
    }

    /**
     * Reduces the player's health by the specified attack damage.
     * If the player's health reaches 0 or below, a death message
     * is printed.
     * If attackDamage is negative, an IllegalArgumentException is thrown
     *
     * @param attackDamage The damage the player takes from a monster attack
     */
    public void takeDamage(int attackDamage) {
        if (attackDamage < 0) {
            throw new IllegalArgumentException("attackDamage cannot be negative");
        }

        health -= attackDamage;
        if (health <= 0) {
            System.out.printf("%s dies!! opsies%n", name);
        }
    }

    public int attack() {
        return attack;
    }
}
