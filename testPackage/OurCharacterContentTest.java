import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patrick on 28.05.2015.
 */
public class OurCharacterContentTest {
    CharacterContent characterContent;

    @Before
    public void setUp() {this.characterContent = new CharacterContent();}
    @Test
    public void testGetLength() {
        assertEquals(3, characterContent.match("'A'\n").getLength());
        assertEquals(3, characterContent.match("'A'").getLength());
    }

    @Test
    public void testGetToken() {
        assertNotNull(characterContent.match("'A'"));

        assertEquals(null, characterContent.match("\n'A'"));
    }

    @Test
    public void testHtmlStart() {
        assertTrue(characterContent.htmlStart().equals("<font color=\"green\">"));

        assertFalse(characterContent.htmlStart().equals(characterContent.htmlEnd()));
        assertFalse(characterContent.htmlStart().equals(characterContent.getHtml()));
        assertFalse(characterContent.htmlStart().equals(characterContent.getContent()));
    }



    @Test
    public void testHtmlEnd() {
        assertTrue(characterContent.htmlEnd().equals("</font>"));

        assertFalse(characterContent.htmlEnd().equals(characterContent.htmlStart()));
        assertFalse(characterContent.htmlEnd().equals(characterContent.getHtml()));
        assertFalse(characterContent.htmlEnd().equals(characterContent.getContent()));

    }

    @Test
    public void testGetContent() {
        this.characterContent = ((CharacterContent) characterContent.match("'A'"));
        assertTrue(characterContent.getContent().equals("'A'"));

        assertFalse(characterContent.getContent().equals(characterContent.htmlStart()));
        assertFalse(characterContent.getContent().equals(characterContent.getHtml()));
        assertFalse(characterContent.getContent().equals(characterContent.htmlEnd()));

    }
    @Test
    public void testGetHtml(){
        this.characterContent = ((CharacterContent) characterContent.match("'A'"));
        assertTrue(characterContent.getHtml().equals(characterContent.htmlStart() + "'A'" + characterContent.htmlEnd()));

        assertFalse(characterContent.getHtml().equals(characterContent.htmlStart()));
        assertFalse(characterContent.getHtml().equals(characterContent.getContent()));
        assertFalse(characterContent.getHtml().equals(characterContent.htmlEnd()));

    }

    @Test
    public void testGetPattern() {
        assertTrue(characterContent.getPattern() instanceof java.util.regex.Pattern);
    }
}