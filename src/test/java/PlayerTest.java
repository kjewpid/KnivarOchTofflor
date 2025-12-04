import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.yrgo.Player;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void createValidUser(){
        try {
            Player player = new Player("Tulipe");
        } catch (IllegalArgumentException e){
            fail("No IllegalArgumentException should be thrown because user is valid");
        }
    }

    @Test
    public void createInvalidUser(){
        try{
            Player player = new Player(null);
            fail("Expected IllegalArgumentException because name is null");
        } catch (IllegalArgumentException e){
            System.out.println("Name cannot be null");
        }
    }

    @Test
    public void addHealth(){
        Player player = new Player("Tulipe");
        player.addHealth();
        assertEquals(20, player.getHealth());
    }

    @Test
    public void addAttackDamage(){
        Player player = new Player("Tulipe");
        player.addAttackDamage();
        assertEquals(20, player.attack());
    }

    @Test
    public void testTakeDamageException(){
        Player player = new Player("Tulipe");
        assertThrows(IllegalArgumentException.class, () -> player.takeDamage(-1));
    }
}
