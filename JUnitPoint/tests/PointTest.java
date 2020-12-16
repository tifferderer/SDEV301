import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testConstructor() {
        //construct a point
        //use getter to assure fields were set prperly
        Point origin = new Point(0,0);

        //verify the point was constructed correctly
        //error, value expected, getter method call, delta
        assertEquals("Point x coordinate incorrect", 0.0, origin.getX(),0.0);
        assertEquals("Point y coordinate incorrect", 0.0, origin.getY(),0.0);
    }

    @Test
    public void testToString() {
        //construct new point
        Point p = new Point(-1,3);
        //error message, expected return, method
        assertEquals("after toString should be Point{x=-1.0, y=3.0}", "Point{x=-1.0, y=3.0}", p.toString());
    }
}