import org.junit.jupiter.api.Test;
import se.yrgo.Monster;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonsterTest {

    @Test
    public void CreateValidMonsterLevel1() {
        Monster m = Monster.createRandomMonster(1);
        assertTrue(
                m.getName().equals("Slime") ||
                        m.getName().equals("Gnome") ||
                        m.getName().equals("Elf")
        );
        assertTrue(m.getHealth() >= 4 && m.getHealth() <= 8);
        assertTrue(m.getAttack() >= 1 && m.getAttack() <= 3);
    }

    @Test
    public void CreateValidMonsterLevel2() {
        Monster m = Monster.createRandomMonster(2);
        assertTrue(
                m.getName().equals("Troll") ||
                        m.getName().equals("Ogre") ||
                        m.getName().equals("Geist")
        );
        assertTrue(m.getHealth() >= 8 && m.getHealth() <= 14);
        assertTrue(m.getAttack() >= 4 && m.getAttack() <= 6);
    }

    @Test
    public void CreateValidMonsterLevel3() {
        Monster m = Monster.createRandomMonster(3);
        assertTrue(
                m.getName().equals("Dragon") ||
                        m.getName().equals("Demon") ||
                        m.getName().equals("Giant")
        );
        assertTrue(m.getHealth() >= 16 && m.getHealth() <= 22);
        assertTrue(m.getAttack() >= 8 && m.getAttack() <= 12);
    }

    @Test
    public void MonsterTakesDamageTest() {
        Monster m = new Monster("Test", 20, 5);
        m.monsterTakesDamage(7);
        assertEquals(13, m.getHealth());
    }
}