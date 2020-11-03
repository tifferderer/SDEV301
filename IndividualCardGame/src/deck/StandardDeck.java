//Tiffany Ferderer
// 10/1/2020
//card game standard deck class
//StandardDeck.java
package deck;

import card.StandardCard;

/**
 * This class represents a deck of Standard cards
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class StandardDeck extends Deck{

    /**
     * Creates a Standard Deck object with 52 cards based on ranks and shapes.
     */
    public StandardDeck() {
        super();
        String[] shape = {"diamonds", "clubs",
                "spades", "hearts"};
        String[] ranks = {"Ace", "Jack", "Queen", "King"};
        int options = 4;
        int minCardNumber = 2;
        int maxCardNumber = 10;

        for (int i =minCardNumber; i <=maxCardNumber ; i++) {
            for (int j = 0; j < options ; j++) {
                addCard(new StandardCard(String.valueOf(i) , shape[j]));
            }
        }
        for (String cardRank:ranks) {
            for (int i = 0; i < options; i++) {
                addCard(new StandardCard(cardRank , shape[i]));
            }
        }
    }

    // Inside the StandardDeck Class
    /**
     * Remove the top card from the dealer pile and place it into the discard pile
     * @return The removed card
     */
    public StandardCard dealTopCard()   {
        // use the super keyword to call the Deck's topDealCard() method, if you omit the keyword super you will start infinite recursion
        // The super.dealTopCard() method is returning a Card object and you want to cast it to a StandardCard object

        return (StandardCard) super.dealTopCard();

    }

}
