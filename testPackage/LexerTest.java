import org.junit.Before;
import org.junit.Test;

/**
 * Created by Patrick on 28.05.2015.
 */
public class LexerTest {
    Lexer lexer;

    @Before
    public void setUp() {this.lexer = new Lexer();}
    @Test
    public void testRegisterToken(){

    }

    @Test
    public void testRegisterCatchAll(){

    }

    @Test
    public void testTokenize() {

    }

    @Test (expected = Lexer.NoCatchAllException.class)
    public void testHasCatchAll() throws Lexer.NoCatchAllException {

    }
}