import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patrick on 28.05.2015.
 */
public class OurMultilineCommentTest {
    MultilineComment multilineComment;

    @Before
    public void setUp() {this.multilineComment = new MultilineComment();}
    @Test
    public void testGetLength() {
        assertEquals(33, multilineComment.match("/*here\n is\n a\n multilineComment*/").getLength());
        assertEquals(33, multilineComment.match("/*here\n is\n a\n multilineComment*///and a Comment").getLength());
    }
/*

 */
    @Test
    public void testGetToken() {
        assertNotNull(multilineComment.match("/*here\n is\n a\n multilineComment*/"));

        assertEquals(null, multilineComment.match("//here is a multilineComment"));
    }

    @Test
    public void testHtmlStart() {
        assertTrue(multilineComment.htmlStart().equals("<i><font color=\"grey\">"));

        assertFalse(multilineComment.htmlStart().equals(multilineComment.htmlEnd()));
        assertFalse(multilineComment.htmlStart().equals(multilineComment.getHtml()));
        assertFalse(multilineComment.htmlStart().equals(multilineComment.getContent()));
    }



    @Test
    public void testHtmlEnd() {
        assertTrue(multilineComment.htmlEnd().equals("</font></i>"));

        assertFalse(multilineComment.htmlEnd().equals(multilineComment.htmlStart()));
        assertFalse(multilineComment.htmlEnd().equals(multilineComment.getHtml()));
        assertFalse(multilineComment.htmlEnd().equals(multilineComment.getContent()));

    }

    @Test
    public void testGetContent() {
        this.multilineComment = ((MultilineComment) multilineComment.match("/*here\n is\n a\n multilineComment*/"));
        assertTrue(multilineComment.getContent().equals("/*here\n is\n a\n multilineComment*/"));

        assertFalse(multilineComment.getContent().equals(multilineComment.htmlStart()));
        assertFalse(multilineComment.getContent().equals(multilineComment.getHtml()));
        assertFalse(multilineComment.getContent().equals(multilineComment.htmlEnd()));

    }
    @Test
    public void testGetHtml(){
        this.multilineComment = ((MultilineComment) multilineComment.match("/*here\n is\n a\n multilineComment*/"));
        assertTrue(multilineComment.getHtml().equals(multilineComment.htmlStart() + "/*here\n is\n a\n multilineComment*/" + multilineComment.htmlEnd()));

        assertFalse(multilineComment.getHtml().equals(multilineComment.htmlStart()));
        assertFalse(multilineComment.getHtml().equals(multilineComment.getContent()));
        assertFalse(multilineComment.getHtml().equals(multilineComment.htmlEnd()));

    }

    @Test
    public void testGetPattern() {
        assertTrue(multilineComment.getPattern() instanceof java.util.regex.Pattern);
    }
}