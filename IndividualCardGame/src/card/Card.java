//Tiffany Ferderer
// 10/1/2020
//card game card class
//Card.java
package card;

/**
 * This class represents a card in a deck
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class Card {
    //fields
    private static String cardText;

    //methods
    /**
     * Constructs a card object
     * @param cardText the card details
     */
    public Card(String cardText) {
        this.cardText = cardText;
    }

    /**
     * Constructs a default card(no details)
     */
    public Card() {
        this.cardText = "";
    }

    /**
     * Gives the text of the card
     * @return card details
     */
    public static String getCardText() {
        return cardText;
    }

    /**
     * The card text in string form
     * @returncard text in string form
     */
    @Override
    public String toString() {
        return cardText;
    }
}
