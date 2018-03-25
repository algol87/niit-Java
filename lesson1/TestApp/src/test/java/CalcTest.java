import static org.junit.Assert.*;

public class CalcTest {

    @org.junit.Test
    public void add() {
        assertEquals(11,Calc.add(5,6));
    }

    @org.junit.Test
    public void sub() {
        assertEquals(-1,Calc.sub(5,6));
    }

    @org.junit.Test
    public void mul() {
        assertEquals(30,Calc.mul(5,6));
    }

    @org.junit.Test
    public void div() {
        assertEquals(0,Calc.div(5,6));
    }
    @org.junit.Test(expected=ArithmeticException.class)
    public void div0() {
        assertEquals(0,Calc.div(5,0));
    }

    @org.junit.Test(timeout = 100)
    public void time() {
        for(long i=0;i<100000000;i++);
    }

}