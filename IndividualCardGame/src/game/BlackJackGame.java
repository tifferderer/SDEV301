/**
 *The driver for a BlackJack game
 * @author Tiffany Ferderer
 * @version 1.0
 */
package game;

import card.StandardCard;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *This class is a driver for a BlackJack game
 */
public class BlackJackGame {

    private static final int MAX_WIN = 21;

    /**
     * The entry point to run game program
     * @param args command line arguments
     */
    public static void main(String[] args) {

        BlackJack cardsGame = new BlackJack();
        Scanner console = new Scanner(System.in);
        boolean continueGame = true;

        while (continueGame) {
            //start the game with empty total values
            setTotalsToZero(cardsGame);
            playerBegin(cardsGame);

            //If you get 2 aces automatically, reset.
            doubleAceDeath(cardsGame);

            boolean playerChoice = playerHit(cardsGame);
            boolean playerContinue = true;

            //if the player chooses to grab another card
            while (playerChoice) {
                StandardCard theCard = cardsGame.dealOneCard();
                playersTotal(cardsGame, theCard);

                //if the next rank value puts you over 21, you lose
                if (cardsGame.getPlayerTotal() > MAX_WIN) {
                    System.out.println();
                    System.out.println("You went bust, you lose.");
                    playerContinue = false;
                    playerChoice = false;
                }
                //do you wish for another card?
                else {
                playerChoice = playerHit(cardsGame);}
            }

            //the player has chosen to hold- dealer's turn for cards
            if(playerContinue) {
                while (cardsGame.getDealerTotal() < MAX_WIN) {
                    //dealer pulls one card at a time...
                    StandardCard dealers = cardsGame.dealOneCard();
                    int gameTotal = cardsGame.getDealerTotal();

                    cardsGame.setDealerTotal(gameTotal + dealers.getRankValue());
                    System.out.println("dealer is dealt a " + dealers.toString());
                }
                System.out.println();

                //results based on the dealer's values
                if (cardsGame.getDealerTotal() > MAX_WIN) {
                    System.out.println("Dealer went bust, you win!");
                }
                if (cardsGame.getDealerTotal() == MAX_WIN) {
                    if (cardsGame.getPlayerTotal() == MAX_WIN) {
                        System.out.println("Tie game.");
                    } else {
                        System.out.println("Dealer wins!");
                    }
                }
            }
            //Ask to play again
            System.out.println("Play another hand? (true/false): ");
            continueGame = console.nextBoolean();
            }

        System.out.println("Thanks for playing!");
    }

    private static void playerBegin(BlackJack game) {
        //deal two cards and put into stream
        Stream<StandardCard> player = game.dealTwoCards();
        //stream to list
        List<StandardCard> playerCount = player.collect(Collectors.toList());
        //for each Standard card... do...(Lambda expression here)
        playerCount.forEach(c -> playersTotal(game, c));
    }

    private static void playersTotal(BlackJack game, StandardCard c) {
        //grab the player total into a variable
        int gameTotal = game.getPlayerTotal();
        //add the rank value to the playerTotal
        game.setPlayerTotal(gameTotal + c.getRankValue());
        //print the cards
        System.out.println("You were dealt a " + c.toString());
    }

    private static void setTotalsToZero(BlackJack game) {
        game.setDealerTotal(0);
        game.setPlayerTotal(0);
    }
    
    private static boolean playerHit(BlackJack game) {
        Scanner console = new Scanner(System.in);
        System.out.println("Your total is " + game.getPlayerTotal() + ", hit?");
        return console.nextBoolean();
    }

    private static void doubleAceDeath(BlackJack game) {
        while(game.getPlayerTotal() > 21) {
            System.out.println("Double Aces- Let's try again");
            setTotalsToZero(game);
            playerBegin(game);
        }
    }
}

