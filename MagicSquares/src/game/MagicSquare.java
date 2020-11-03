/**
 * Magic Square object
 * @author Tiffany Ferderer
 * @version 1.0
 */
package game;

/**
 * Creates a magic square object that holds a board of numbers 1-9.
 */
public class MagicSquare {

    private short choices;
    private static final int MIN_CHOICE = 1;
    private static final int MAX_CHOICE = 9;

    /**
     * Constructs an empty magic square.
     */
    public MagicSquare() {
        choices = 0;
    }

    /**
     * Accepts a byte value ranging between 1-9.
     * This will set the bit at the index selection - 1 to "on".
     * @param selection A byte value.
     * @return true if the bit was changed, false if the selection has already been chosen.
     */
    public boolean choose(byte selection) {
        // Exception for a number not between 1 to 9
        if (!( selection <= MAX_CHOICE && selection >= MIN_CHOICE)) {
            throw new IllegalArgumentException(selection + " is not between 1 and 9");
        }
        //Exception for a number already chosen
        if (hasAlreadyChosen(selection)) {
            throw new IllegalArgumentException(selection + " has already been chosen.");
        }
        else { //set bit of interest to 1
            //invert the mask
            short mask = createMask(selection);
            choices = (short)(choices | mask);
            return true;
        }
    }

    /**
     * Checks if the given value has been chosen already.
     * @param selection the byte value.
     * @returntrue if the bit at index selection - 1 is set to the "on" position,
     * or false if the bit is in the "off" position.
     */
    public boolean hasAlreadyChosen(byte selection) {
        short mask = createMask(selection);

        //bitwise AND this mask with the array and save the result
        //short result = (short)(array & mask);
        return(((short)(choices & mask) == mask));
    }

    /**
     * Gets the byte choices.
     * @return the byte choices.
     */
    public short getChoices() {
        return choices;
    }

    /**
     * A String representation of the magic square.
     */
    public void printChoices() {
        //The layout of the magic square
        int board[] = {2,7,6,9,5,1,4,3,8};
        int section = 3;
        int clear = 0;

        for (int i = 0; i < board.length; i++) {
            //if the user chose that position, print the numbered position
            if(hasAlreadyChosen((byte) (board[i]))) {
                        System.out.print(board[i] + " ");
                }
            //not chosen yet
            else {
                System.out.print("_ ");
            }
            //Add spaces to create the square board
            if((i+MIN_CHOICE) % section == clear) {
                System.out.println();
            }
        }
    }

    //helper method
    private short createMask (int index){
        //create a mask
        short mask = MIN_CHOICE; //0000_0000_0000_0001
        //shift mask over index shifts
        return (short) (mask << index - MIN_CHOICE);
    }
}