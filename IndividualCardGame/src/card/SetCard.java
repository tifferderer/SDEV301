//Tiffany Ferderer
// 10/1/2020
//card game set card class
//SetCard.java
package card;

/**
 * This class represents a set card object
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class SetCard extends Card{

    //fields
    private String shape;
    private int number;
    private String shading;
    private String color;

    //methods

    /**
     * Creates a Set Card object
     * @param shape The card's shape
     * @param number The card's number
     * @param shading The shade of the card
     * @param color The color of the card
     */
    public SetCard(String shape, int number, String shading, String color) {
        super();
        this.shape = shape;
        this.number = number;
        this.shading = shading;
        this.color = color;
    }

    /**
     * Grabs the shape of the card
     * @return Card's shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * Grabs the number of the card
     * @return Card's number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Grabs the shade of the card
     * @return Card's shade
     */
    public String getShading() {
        return shading;
    }

    /**
     * Grabs the color of the card
     * @return Card's color
     */
    public String getColor() {
        return color;
    }

    /**
     * String representation of set card
     * @return String representation of set card
     */
    @Override
    public String toString() {
        return super.toString() + getShape() + " " + getNumber()+ " " + getShading()+ " " + getColor();
    }
}
