import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patrick on 28.05.2015.
 */
public class KeyWordTest {
    KeyWord keyWord;

    @Before
    public void setUp() {this.keyWord = new KeyWord();}
    @Test
    public void testGetLength() {
        assertEquals(6, ((KeyWord) keyWord.match("public\n")).getLength());
        assertEquals(6, ((KeyWord) keyWord.match("public")).getLength());
    }

    @Test
    public void testGetToken() {
        assertNotNull(keyWord.match("public"));

        assertEquals(null, keyWord.match("\npublic"));
    }

    @Test
    public void testHtmlStart() {
        assertTrue(keyWord.htmlStart().equals("<font color=\"red\"><b>"));

        assertFalse(keyWord.htmlStart().equals(keyWord.htmlEnd()));
        assertFalse(keyWord.htmlStart().equals(keyWord.getHtml()));
        assertFalse(keyWord.htmlStart().equals(keyWord.getContent()));
    }



    @Test
    public void testHtmlEnd() {
        assertTrue(keyWord.htmlEnd().equals("</b></font>"));

        assertFalse(keyWord.htmlEnd().equals(keyWord.htmlStart()));
        assertFalse(keyWord.htmlEnd().equals(keyWord.getHtml()));
        assertFalse(keyWord.htmlEnd().equals(keyWord.getContent()));

    }

    @Test
    public void testGetContent() {
        this.keyWord = ((KeyWord) keyWord.match("public"));
        assertTrue(keyWord.getContent().equals("public"));

        assertFalse(keyWord.getContent().equals(keyWord.htmlStart()));
        assertFalse(keyWord.getContent().equals(keyWord.getHtml()));
        assertFalse(keyWord.getContent().equals(keyWord.htmlEnd()));

    }
    @Test
    public void testGetHtml(){
        this.keyWord = ((KeyWord) keyWord.match("public"));
        assertTrue(keyWord.getHtml().equals(keyWord.htmlStart() + "public" + keyWord.htmlEnd()));

        assertFalse(keyWord.getHtml().equals(keyWord.htmlStart()));
        assertFalse(keyWord.getHtml().equals(keyWord.getContent()));
        assertFalse(keyWord.getHtml().equals(keyWord.htmlEnd()));

    }

    @Test
    public void testGetPattern() {
        assertTrue(keyWord.getPattern() instanceof java.util.regex.Pattern);
    }
}