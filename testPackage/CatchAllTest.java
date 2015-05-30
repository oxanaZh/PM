import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patrick on 28.05.2015.
 */
public class CatchAllTest {
    CatchAll catchAll;

    @Before
    public void setUp() {this.catchAll = new CatchAll();}
    @Test
    public void testGetLength() {
        assertEquals(1, ((CatchAll) catchAll.match("a\n")).getLength());
        assertEquals(1, ((CatchAll) catchAll.match("a")).getLength());
    }

    @Test
    public void testGetToken() {
        assertNotNull(catchAll.match("a"));

        assertNotNull(catchAll.match("\nOverride"));
    }

    @Test
    public void testHtmlStart() {
        assertTrue(catchAll.htmlStart().equals(""));
        assertFalse(catchAll.htmlStart().matches("<.*>"));

    }



    @Test
    public void testHtmlEnd() {
        assertTrue(catchAll.htmlEnd().equals(""));
        assertFalse(catchAll.htmlEnd().matches("<.*>"));

    }

    @Test
    public void testGetContent() {
        this.catchAll = ((CatchAll) catchAll.match("a"));
        assertTrue(catchAll.getContent().equals("a"));
        assertTrue(catchAll.getContent().equals(catchAll.getHtml()));

        assertFalse(catchAll.getContent().equals(catchAll.htmlStart()));
        assertFalse(catchAll.getContent().equals(catchAll.htmlEnd()));

    }
    @Test
    public void testGetHtml(){
        this.catchAll = ((CatchAll) catchAll.match("a"));
        assertTrue(catchAll.getHtml().equals(catchAll.htmlStart() + "a" + catchAll.htmlEnd()));
        assertTrue(catchAll.getHtml().equals(catchAll.getContent()));

        assertFalse(catchAll.getHtml().equals(catchAll.htmlStart()));
        assertFalse(catchAll.getHtml().equals(catchAll.htmlEnd()));

    }

    @Test
    public void testGetPattern() {
        assertTrue(catchAll.getPattern() instanceof java.util.regex.Pattern);
    }
}