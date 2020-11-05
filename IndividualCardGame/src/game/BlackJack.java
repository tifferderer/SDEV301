/**
 *Represents a BlackJack object
 * @author Tiffany Ferderer
 * @version 1.0
 */

package game;

import card.StandardCard;
import deck.StandardDeck;

import java.util.stream.Stream;

/**
 * Instantiates a BlackJack object that holds
 * a player's card value total and a dealer's
 * card total from a Standard deck
 */
public class BlackJack {

    //fields
    private int playerTotal;
    private int dealerTotal;
    private StandardDeck deck;

    //Methods

    //constructor
    /**
     *Default constructor. It should create/shuffle a
     * Standard Deck and display a welcome message.
     */
    public BlackJack() {
        //create & shuffle deck
        deck = new StandardDeck();

        //set playerTotal and dealerTotal to 0
        playerTotal = 0;
        dealerTotal = 0;

        //display the welcome message
        welcome();

        deck.shuffle();
    }

    //getters
    /**
     * A getter
     * @return the player's hand total
     */
    public int getPlayerTotal() {
        return playerTotal;
    }

    /**
     *A getter
     * @return the dealer's hand total
     */
    public int getDealerTotal() {
        return dealerTotal;
    }

    //setters
    /**
     *Set method
     * @param playerTotal assigns the player's hand total
     */
    public void setPlayerTotal(int playerTotal) {
        this.playerTotal = playerTotal;
    }

    /**
     *Set method
     * @param dealerTotal assigns the dealer's hand total
     */
    public void setDealerTotal(int dealerTotal) {
        this.dealerTotal = dealerTotal;
    }

    /**
     * Two cards are dealt from the deck.
     * @return A Stream of Standard Card Object.
     */
    public Stream<StandardCard> dealTwoCards() {
        if(deck.cardCount() < 2) {
            System.out.println("Shuffle Needed...");
            deck.shuffle();
        }
        Stream<StandardCard> twoCards = Stream.of(deck.dealTopCard(), deck.dealTopCard());
        return twoCards;
    }

    /**
     *One card is dealt from the deck
     * @return Standard Card object
     */
    public StandardCard dealOneCard() {
        if(deck.cardCount()==0) {
            System.out.println("Shuffle Needed...");
            deck.shuffle();
        }
        return deck.dealTopCard();
    }

    /**
     * A welcome message
     */
    public void welcome() {
        System.out.println("Welcome to my Blackjack console program!");
        System.out.println("***************************************");
        System.out.println();
        System.out.println("Generated a new standard deck of cards");
        System.out.println("Shuffling deck...");

    }

    /**
     *String representation of the BlackJack object.
     * @return String representation of blackjack object
     */
    public String toString() {
        return "Player total: " + getPlayerTotal() + ", Dealer total: " +
                getDealerTotal() + ", Deck: " + deck;
    }
}
