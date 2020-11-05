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
     * Method that returns an integer value for the rank of the card
     * @return an integer value
     */
    public int getRankValue() {
        int currentRank = 11;
        String[] numberRanks = { "2","3", "4", "5", "6", "7", "8", "9", "10"};
        String[] royalRanks = {"Jack", "Queen", "King"};
        for (int i = 0; i < numberRanks.length ; i++) {
            if (getRank().contains(numberRanks[i])) {
                currentRank = Integer.parseInt(getRank());
            }
        }
        for (int i = 0; i <royalRanks.length ; i++) {
            if(getRank().contains(royalRanks[i])) {
                currentRank = 10;
            }
        }
        return currentRank;
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
