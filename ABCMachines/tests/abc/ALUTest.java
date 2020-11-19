package abc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ALUTest {

    private short num1 = 1;
    private short num2 = 2;

    @Test
    public void testALU() {
        ALU starter = new ALU();
        assertEquals("The nzp status should default to ZERO", Nzp.ZERO, starter.getStatus());
    }

    @Test
    public void testOperate() {
        ALU starter = new ALU();
        short addNum = starter.operate(num1, Operator.ADD, num2);
        short subNum = starter.operate(num1, Operator.SUB, num2);
        short divNum = starter.operate(num2, Operator.DIV, num1);
        short multNum = starter.operate(num1, Operator.MULT, num2);

        assertEquals(" 1+2 = 3", 3, addNum);
        assertEquals(" 1-2 = -1", -1, subNum);
        assertEquals(" 2/1 = 2", 2, divNum);
        assertEquals(" 1*2 = 2", 2, multNum);
    }

    @Test
    public void testGetStatus() {
        ALU starter = new ALU();
        starter.operate(num1, Operator.SUB, num2);
        assertEquals("The nzp status should set to NEGATIVE", Nzp.NEGATIVE, starter.getStatus());

        starter.operate(num1, Operator.ADD, num2);
        assertEquals("The nzp status should set to POSITIVE", Nzp.POSITIVE, starter.getStatus());

    }

}