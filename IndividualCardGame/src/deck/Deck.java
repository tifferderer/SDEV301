//Tiffany Ferderer
// 10/1/2020
//card game deck class
//Deck.java
package deck;

import card.Card;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a deck object, containing a discard
 * pile and a dealer pile to contain card objects
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class Deck{

    //fields
    private ArrayList<Card> dealerPile;
    private ArrayList<Card> discardPile;

    //methods
    /**
     * Creates a new Deck object
     */
    public Deck() {
        this.dealerPile = new ArrayList<>();
        this.discardPile = new ArrayList<>();
    }

    /**
     * Adds a card to the dealer pile
     * @param card A card object
     */
    public void addCard(Card card){
            dealerPile.add(card);
    }

    /**
     * Moves all cards from the discard pile to the dealer pile.
     * Then randomizes the position of all cards in the dealer pile
     */
    public void shuffle() {
        //moves all cards from the discard pile to the dealer pile.
        int index = 0;
        while (index < discardPile.size()) {
            dealerPile.add(discardPile.get(index));
            discardPile.remove(index);
        }
        Random generator = new Random();
        //randomizes the position of all cards in the dealer pile.
        for (int i = 0; i < dealerPile.size() - 1; i++) {
            int n = generator.nextInt(dealerPile.size() - 1);
            int m = generator.nextInt(dealerPile.size() - 1);

            while (n == m) {
                m = generator.nextInt(dealerPile.size() - 1);
            }
            dealerPile.add(n, dealerPile.remove(m));
            dealerPile.add(m, dealerPile.remove(n + 1));
        }
    }

    /**
     * Removes the "top" card from the dealer pile and places
     * it in the discard pile
     */
    public Card dealTopCard() {
            Card top =dealerPile.remove(0);
            discardPile.add(top);
            return top;
    }

    /**
     * The number of cards in the dealer pile
     * @return The number of cards in the dealer pile
     */
    public int cardCount() {
        return dealerPile.size();
    }

    private String cardResults(ArrayList<Card> pileOption) {
        String cardResults = "";
        if (pileOption.size() != 0) {
            for (int i = 0; i < pileOption.size(); i++) {
                cardResults = cardResults + " \n" + (pileOption.get(i)).toString();
            }
        }
        return cardResults;
    }

    /**
     * A string representation of the deck
     * @return The deck
     */
    @Override
    public String toString() {
            return cardCount() + " cards in play. \n **************\n" +cardResults(dealerPile) + "\n \n" +
                    discardPile.size() + " cards in discard pile. \n **************\n" + cardResults(discardPile);
    }
}
