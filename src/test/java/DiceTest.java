import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.yrgo.Dice;

class DiceTest {

    @Test
    void rollCombatReturnsValueBetween1And4() {
        Dice dice = new Dice();

        for (int i = 0; i < 100; i++) {
            int result = dice.rollCombat();
            assertTrue(result >= 1 && result <= 4);
        }
    }

    @Test
    void rollIsCaseInsensitive() {
        Dice dice = new Dice();
        int result = dice.roll("RoLl");
        assertTrue(result >= 1 && result <= 4);
    }

    @Test
    void rollWithInvalidCommandReturnsMinusOne() {
        Dice dice = new Dice();
        assertEquals(-1, dice.roll("något annat"));
    }
}
