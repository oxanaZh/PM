import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Patrick on 28.05.2015.
 */
public class OurLexerTest {
    Lexer lexer;
    Exception noTokenException, noCatchAllException;
    @Before
    public void setUp() {this.lexer = new Lexer();}

    @Test
    public void testRegisterToken(){
        lexer.registerToken(new Annotation());
        try {
            lexer.tokenize("@Override");
        } catch (Lexer.NoTokenException tokenException){
            this.noTokenException = tokenException;
        } catch (Lexer.NoCatchAllException catchAllException) {
            this.noCatchAllException =catchAllException;
        }
        assertEquals(null, this.noTokenException);
        assertNotNull(this.noCatchAllException);
    }

    @Test
    public void testRegisterCatchAll(){
        lexer.registerToken(new CatchAll());
        try {
            lexer.tokenize("@Override");
        } catch (Lexer.NoTokenException tokenException){
            this.noTokenException = tokenException;
        } catch (Lexer.NoCatchAllException catchAllException) {
            this.noCatchAllException =catchAllException;
        }
        assertEquals(null, this.noCatchAllException);
        assertEquals(null, this.noTokenException);
    }

    @Test
    public void testTokenize() throws Lexer.NoTokenException, Lexer.NoCatchAllException {
        lexer.registerToken(new Annotation());
        lexer.registerCatchAll(new CatchAll());
        assertNotNull(lexer.tokenize("@Override"));
        assertNotNull(lexer.tokenize(""));
        assertNotNull(lexer.tokenize("asddfasdgfasdfas@Override"));
    }

   @Test (expected = Lexer.NoCatchAllException.class)
   public void testHasCatchAll() throws Lexer.NoCatchAllException, Lexer.NoTokenException {
       lexer.registerToken(new Annotation());
        lexer.tokenize("hi");
    }
    @Test (expected = Lexer.NoTokenException.class)
    public void testHasToken() throws Lexer.NoCatchAllException, Lexer.NoTokenException {
    lexer.tokenize("Hi");
    }
}