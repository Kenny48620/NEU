package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BattleTest {
    
    /**
     * Test Battle. Because the result will be randomly, just
     * test the functionlity can works fine. In Battle, I also
     * provide snerio 1 and senrio 2 for test
     */
    public void testExtraSenrio(){
        System.out.println("Scenario 2 start...");
        List<ArmedGear> gearPool = new ArrayList<>();

        // head 
        gearPool.add(new HeadGear("Golden Helmet", 0, 5));
        gearPool.add(new HeadGear("Copper Helmet", 0, 2));

        // hand
        gearPool.add(new HandGear("Wooden Sword", 3, 0));
        gearPool.add(new HandGear("Iron Sword", 5, 0));
        gearPool.add(new HandGear("Wooden Shield", 2, 0));
        gearPool.add(new HandGear("Vibranium shield", 7, 0));
        // foot 
        gearPool.add(new FootGear("Wooden Boot", 1, 2));
        gearPool.add(new FootGear("Iron Boot", 2, 3));
        gearPool.add(new FootGear("Golden Hoverboard", 3, 4));
        gearPool.add(new FootGear("Golden Hoverboard", 3, 4));

        // shuffle the elements using Collections.shuffle()
        Collections.shuffle(gearPool);
        Character c1 = new Character("Gandalf", 0, 0);
        Character c2 = new Character("Aragorn", 0, 0);

        Battle battle = new Battle(c1, c2, gearPool);
        battle.start();
    }
}
