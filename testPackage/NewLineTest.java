
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patrick on 28.05.2015.
 */
public class NewLineTest {
    NewLine newLine;

    @Before
    public void setUp() {this.newLine = new NewLine();}
    @Test
    public void testGetLength() {
        assertEquals(1, ((NewLine) newLine.match("\n\n")).getLength());
        assertEquals(1, ((NewLine) newLine.match("\n")).getLength());
    }

    @Test
    public void testGetToken() {
        assertNotNull(newLine.match("\n"));

        assertNotNull(newLine.match("\n\n"));
    }

    @Test
    public void testHtmlStart() {
        assertTrue(newLine.htmlStart().equals(""));

        assertFalse(newLine.htmlStart().equals(newLine.htmlEnd()));
        assertFalse(newLine.htmlStart().equals(newLine.getHtml()));
        assertFalse(newLine.htmlStart().equals(newLine.getContent()));
    }



    @Test
    public void testHtmlEnd() {
        assertTrue(newLine.htmlEnd().equals("<br />"));

        assertFalse(newLine.htmlEnd().equals(newLine.htmlStart()));
        assertFalse(newLine.htmlEnd().equals(newLine.getHtml()));
        assertFalse(newLine.htmlEnd().equals(newLine.getContent()));

    }

    @Test
    public void testGetContent() {
        this.newLine = ((NewLine) newLine.match("\n"));
        assertTrue(newLine.getContent().equals("\n"));

        assertFalse(newLine.getContent().equals(newLine.htmlStart()));
        assertFalse(newLine.getContent().equals(newLine.getHtml()));
        assertFalse(newLine.getContent().equals(newLine.htmlEnd()));

    }
    @Test
    public void testGetHtml(){
        this.newLine = ((NewLine) newLine.match("\n"));
        assertTrue(newLine.getHtml().equals(newLine.htmlStart() + "\n" + newLine.htmlEnd()));

        assertFalse(newLine.getHtml().equals(newLine.htmlStart()));
        assertFalse(newLine.getHtml().equals(newLine.getContent()));
        assertFalse(newLine.getHtml().equals(newLine.htmlEnd()));

    }

    @Test
    public void testGetPattern() {
        assertTrue(newLine.getPattern() instanceof java.util.regex.Pattern);
    }
}