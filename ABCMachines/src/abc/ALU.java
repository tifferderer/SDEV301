package abc;

/**
 *The class will perform
 * all the arithmetic instructions in the operate
 * method and tracks whether the last computation on the ALU
 * resulted in a negative, positive, or zero value.
 *
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class ALU {

    private Nzp status; //holds Nzp.NEGATIVE, Nzp.ZERO, or Nzp.POSITIVE

    /**
     *  Initialize the ALU status to Nzp.ZERO
     */
    public ALU() {
        status = Nzp.ZERO;
    }

    /**
     * This method will perform a math operation on two numbers and set the nzp status
     * appropriately based on whether the math operation resulting in a postive, negative, or zero value
     * @param num1 first number
     * @param operator the math operation
     * @param num2 second number
     * @return A product of the operator (+, -, *, or /)
     */
    public short operate(short num1, Operator operator, short num2) {
        short answer = 0;

        switch(operator) {
            case ADD: // ADD
               answer = (short) (num1 + num2);
                break;
            case SUB:
                answer = (short) (num1 - num2);
                break;

            case MULT:
                answer = (short) (num1 * num2);
                break;

            case DIV:
                answer = (short) (num1 / num2);
                break;
        }
        if(answer > 0) {
            status = Nzp.POSITIVE;
        }
        else if(answer < 0) {
            status = Nzp.NEGATIVE;
        }
        return answer;//answer to ADD, SUB, MULT, DIV
    }

    /**
     * An accessor for the getStatus() method
     * @return Nzp(positive, negative, zero)
     */
    public Nzp getStatus() {
        return status;
    }
}