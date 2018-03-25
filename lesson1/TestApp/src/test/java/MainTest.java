import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainTest {
    private final ByteArrayOutputStream outStream=new ByteArrayOutputStream();

    @Before
    public void setup(){
        System.setOut(new PrintStream(outStream));
    }
    @After
    public void clean(){
        System.setOut(null);
    }
    @Test
    public void main() {
        Main.main(new String[]{""});
        assertEquals("Сумма 5 и 6 равна 11",outStream.toString());
    }
}