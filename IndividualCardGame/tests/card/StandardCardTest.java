//Tiffany Ferderer
// 10/1/2020
//JUnit testing
//StandardCardTest.java
package card;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is a test class for a standard card object
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class StandardCardTest {

    /**
     * Tests the standard card constructor
     */
    @Test
    public void testConstructor() {
        //construct a standard card
        //use getter to assure fields were set properly
        StandardCard starter = new StandardCard("Ace", "Spades");

        //verify the card was constructed correctly
        //error, value expected, getter method call
        assertEquals("The card should be ace of spades", "Ace", starter.getRank());
        assertEquals("The card should be the ace of spades", "Spades", starter.getSuit());
    }

    //Just missing the toString() test which would be easier to test if you make the fix noted above
    @Test
    public void testToString() {
        //construct a card
        StandardCard start = new StandardCard("Ace", "clubs");

        assertEquals("The string should say Ace of clubs", "Ace of clubs", start.toString());
    }

    @Test
    public void testGetRankValue() {
        StandardCard numberRank1 = new StandardCard("2", "diamonds");
        StandardCard numberRank2 = new StandardCard("10", "diamonds");
        StandardCard royalRank = new StandardCard("Queen", "Spades");
        StandardCard aceRank = new StandardCard("Ace", "Diamonds");

        assertEquals("The value should represent a 2", 2, numberRank1.getRankValue());
        assertEquals("The value should represent a 10", 10, numberRank2.getRankValue());
        assertEquals("The value should represent 10", 10, royalRank.getRankValue());
        assertEquals("The value should represent 11", 11, aceRank.getRankValue());

    }
}