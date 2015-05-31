import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patrick on 28.05.2015.
 */
public class OurStringContentTest {
    StringContent stringContent;

    @Before
    public void setUp() {this.stringContent = new StringContent();}
    @Test
    public void testGetLength() {
        assertEquals(15, stringContent.match("\"ExampleString\"\n").getLength());
        assertEquals(15, stringContent.match("\"ExampleString\"").getLength());
    }

    @Test
    public void testGetToken() {
        assertNotNull(stringContent.match("\"ExampleString\""));

        assertEquals(null, stringContent.match("\n\"ExampleString\""));
    }

    @Test
    public void testHtmlStart() {
        assertTrue(stringContent.htmlStart().equals("<font color=\"green\">"));

        assertFalse(stringContent.htmlStart().equals(stringContent.htmlEnd()));
        assertFalse(stringContent.htmlStart().equals(stringContent.getHtml()));
        assertFalse(stringContent.htmlStart().equals(stringContent.getContent()));
    }



    @Test
    public void testHtmlEnd() {
        assertTrue(stringContent.htmlEnd().equals("</font>"));

        assertFalse(stringContent.htmlEnd().equals(stringContent.htmlStart()));
        assertFalse(stringContent.htmlEnd().equals(stringContent.getHtml()));
        assertFalse(stringContent.htmlEnd().equals(stringContent.getContent()));

    }

    @Test
    public void testGetContent() {
        this.stringContent = ((StringContent) stringContent.match("\"ExampleString\""));
        assertTrue(stringContent.getContent().equals("\"ExampleString\""));

        assertFalse(stringContent.getContent().equals(stringContent.htmlStart()));
        assertFalse(stringContent.getContent().equals(stringContent.getHtml()));
        assertFalse(stringContent.getContent().equals(stringContent.htmlEnd()));

    }
    @Test
    public void testGetHtml(){
        this.stringContent = ((StringContent) stringContent.match("\"ExampleString\""));
        assertTrue(stringContent.getHtml().equals(stringContent.htmlStart() + "\"ExampleString\"" + stringContent.htmlEnd()));

        assertFalse(stringContent.getHtml().equals(stringContent.htmlStart()));
        assertFalse(stringContent.getHtml().equals(stringContent.getContent()));
        assertFalse(stringContent.getHtml().equals(stringContent.htmlEnd()));

    }

    @Test
    public void testGetPattern() {
        assertTrue(stringContent.getPattern() instanceof java.util.regex.Pattern);
    }
}