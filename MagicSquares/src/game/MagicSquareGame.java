package game;

/**
 * Magic Square driver to play a game with two players.
 * @author Tiffany Ferderer
 * @version 1.0
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The class creates magic square boards and runs a game
 * with 2 players until there is a draw or winner.
 */
public class MagicSquareGame {

    // the game board with both the players' choices
    private static MagicSquare p3 = new MagicSquare();

    //End game options
    private static final int WIN = 3;
    private static final int DRAW = 2;
    private static final int CONTINUED = 1;

    /**
     * This main method setups the game play and contains the game loop where each player continues to take turns until
     * a player wins or the game is a DRAW
     * @param args not used
     */
    public static void main(String[] args) {

        //store the player's game boards
       MagicSquare p1 = new MagicSquare();
       MagicSquare p2 = new MagicSquare();
       MagicSquare[] boards = {p1,p2};

        //prompt thr directions
        printDirections();

        //store the players' names in variables/array
        String playerOne = getName(1);
        String playerTwo = getName(2);
        String[] players = {playerOne, playerTwo};


        //create a loop to keep getting guesses, leave if draw or win
        while(true)  {
            for (int i = 0; i <= 1; i++) {

                boards[i].choose((byte)(getSelection(players[i])));
                boards[i].printChoices();

                //check if there was a winning selection or a draw
                if(takePlayerTurn(boards[i], p3) == WIN) {
                    System.out.println("You Win!");
                    return;
                }
                else if(takePlayerTurn(boards[i], p3) == DRAW) {
                    System.out.println("It's a Draw!");
                    return;
                }
            }
        }
    }

    /**
     * This takePlayerTurn method will prompt for and display the player's choice of numbers and then determine if the game has been won,
     * is a draw, or the game should continue
     *
     * @param p - the Player
     * @param both - player1 and player 2 choices
     * @return a number indicating the game state(CONTINUE, DRAW, WIN)
     */
    public static int takePlayerTurn(MagicSquare p, MagicSquare both) {

        if (isWin( p)) {
            return WIN;
        }
        if(isDraw(both)) {
            return DRAW;
        }
        else {
            return CONTINUED;
        }
    }

    /**
     * This isDraw method will determine if the game is a draw due to all choices made and no one player had a winning combination
     * @param both - player 1 and player 2 choices
     * @return true if all values have been picked, game is a DRAW, false otherwise
     */
    public static boolean isDraw(MagicSquare both) {
        int fullBoard = 511;
        return (both.getChoices() == fullBoard);
    }

    /**
     * This isWin method determines if a player's magic square choices result in a winning combination
     * @param p the player
     * @return true, if the player has won, false otherwise
     */
    public static boolean isWin(MagicSquare p) {
        short[] winningMatches = {98,273, 140, 266, 84, 161, 146, 56};

        for (int i = 0; i < winningMatches.length ; i++) {
            if ((p.getChoices() & winningMatches[i]) == winningMatches[i]) {
               return true;
            }
        }
        return false;
    }

    /**
     * This getSelection method asks the player for their number selection from 1 - 9.  If the user does not enter a number in this
     * range, they are continually prompted until they do enter a number between 1 and 9.  If the user has already entered
     * a number that has been chosen, they are continually prompted until they enter a number that has not been previously selected.
     * @param p - Player
     * @return the number chosen from 1-9
     *
     */
    public static int getSelection(String p) {
        Scanner console = new Scanner(System.in);
        boolean good = false;
        byte num = 0;
        int minChoice = 1;
        int maxChoice = 9;

        do {
            System.out.print(p + ": ");
            System.out.println("Choose a number in range 1-9:");

            try {
                num = console.nextByte();
                good = p3.choose(num);
            }

            catch (IllegalArgumentException | InputMismatchException ex) {
                System.out.println(ex.getMessage());
                console.nextLine();
                good = false;
            }
        } while (num < minChoice || num > maxChoice || !good);

        return num;
    }

    /**
     * This getName method receives a player's number and prompts that player for their name.
     * @param playerNum the player's number
     * @return the player's name
     */
    public static String getName(int playerNum) {
        Scanner name = new Scanner(System.in);
        System.out.println("Enter a name for player #" + playerNum);
        return name.nextLine();
    }

    /**
     * This printDirections method prints out the game introduction
     */
    public static void printDirections() {
        System.out.println("Welcome to the game of Magic Squares");
        System.out.println("**************************************");
        System.out.println("Rules:");
        System.out.println("2 players play the game.");
        System.out.println("Each player takes turns picking a number from 1-9.");
        System.out.println("No number can be chosen twice.");
        System.out.println("First player to have numbers that sum to 15 wins.");
        System.out.println("2 7 6");
        System.out.println("9 5 1");
        System.out.println("4 3 8");
        System.out.println("*********************************************");
    }
}