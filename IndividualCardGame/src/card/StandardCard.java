//Tiffany Ferderer
// 10/1/2020
//card game standard card class
//StandardCard.java
package card;

/**
 * This class represents a Standard Card
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class StandardCard extends Card{
    //fields
    private String rank;
    private String suit;

    //methods

    /**
     * Constructs the Standard Card object
     * @param rank The card's rank
     * @param suit The suit of the card
     */
    public StandardCard(String rank, String suit) {
        super();
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Grabs the rank of the card
     * @return Rank of the card
     */
    public String getRank() {
        return rank;
    }

    /**
     * Grabs the suit of the card
     * @return Suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * A string representation of a standard card
     * @return The rank and suit
     */
    @Override
    public String toString() {
        //The toString() in SetCard and StandardCard should be
        // reusing the code in the Card class with a call to
        // super.toString() or getCardText()
        return super.toString() + getRank() + " of " + getSuit();
    }
}
