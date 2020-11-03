//Tiffany Ferderer
// 10/1/2020
//JUnit testing
//CardTest.java
package card;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is a test class for a card object
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class CardTest {

    /**
     * Tests the card constructor
     */
    @Test
    public void testConstructor() {
        //construct a card
        //use getter to assure fields were set properly
        Card starter = new Card("Ace of clubs");

        //verify the card was constructed correctly
        //error, value expected, getter method call, delta
        assertEquals("The card should be ace of clubs", "Ace of clubs", starter.getCardText());
    }

    //Just missing the toString() test which would be easier to test if you make the fix noted above
    @Test
    public void testToString() {
        //construct a card
        Card start = new Card("Ace of clubs");

        assertEquals("The string should say Ace of clubs", "Ace of clubs", start.toString());
    }
}