package hw3;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
// import org.junit.rules.Timeout;

public class PersonalTest {
    @Test 
    public void testPrintTree() {

        // IntTree t1 = new IntTree();
        //
        // assertTrue(t1.isPerfectlyBalanced());
        //
        // t1 = IntTree.fromString("50:");
        // assertTrue(t1.isPerfectlyBalanced());
        // t1 = IntTree.fromString("50: 100:r");
        // assertFalse(t1.isPerfectlyBalanced());
        // t1 = IntTree.fromString("100: 50:l");
        // assertFalse(t1.isPerfectlyBalanced());
        // t1 = IntTree.fromString("100: 50:l 150:r");
        // assertTrue(t1.isPerfectlyBalanced());
        // t1 = IntTree.fromString("50: 100:r 150:rr");
        // assertFalse(t1.isPerfectlyBalanced());
        // t1 = IntTree.fromString("150: 100:l 50:ll");
        // assertFalse(t1.isPerfectlyBalanced());
        // t1 = IntTree.fromString("50: 100:r 75:rl");
        // assertFalse(t1.isPerfectlyBalanced());
        // t1 = IntTree.fromString("100: 50:l 75:lr");
        // assertFalse(t1.isPerfectlyBalanced());
        

        IntTree t2 = new IntTree();
        t2 = IntTree.fromString("100: 50:l 150:r 25:ll");
        t2.prettyPrint();
        assertFalse(t2.isPerfectlyBalanced());
        t2 = IntTree.fromString("100: 50:l 150:r 125:rl");
        t2.prettyPrint();
        assertFalse(t2.isPerfectlyBalanced());

        t2 = IntTree.fromString("100: 50:l 150:r 25:ll 175:rr");
        t2.prettyPrint();

        assertFalse(t2.isPerfectlyBalanced());
        t2 = IntTree.fromString("100: 50:l 150:r 25:ll 75:lr");
        t2.prettyPrint();
        assertFalse(t2.isPerfectlyBalanced());
        t2 = IntTree.fromString("100: 50:l 150:r 125:rl 175:rr");
        t2.prettyPrint();
        assertFalse(t2.isPerfectlyBalanced());
        t2 = IntTree.fromString("50: 25:l 75:r 12:ll 37:lr 62:rl 87:rr");
        t2.prettyPrint();
        assertTrue(t2.isPerfectlyBalanced());
        t2 = IntTree.fromString("50: 25:l 12:ll 37:lr 75:r 62:rl 87:rr");
        t2.prettyPrint();
        assertTrue(t2.isPerfectlyBalanced());
        t2 = IntTree.fromString("50: 75:r 62:rl 87:rr 25:l 12:ll 37:lr");
        t2.prettyPrint();
        assertTrue(t2.isPerfectlyBalanced());
        t2 = IntTree.fromString("50: 25:l 75:r 12:ll 37:lr 62:rl 87:rr 51:rll");
        t2.prettyPrint();
        assertFalse(t2.isPerfectlyBalanced());
        t2 = IntTree.fromString("50: 25:l 75:r 12:ll 22:llr 62:rl 87:rr");
        t2.prettyPrint();
        assertFalse(t2.isPerfectlyBalanced());

    }
    

}


