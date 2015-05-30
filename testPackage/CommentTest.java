import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patrick on 28.05.2015.
 */
public class CommentTest {
    Comment comment;

    @Before
    public void setUp() {this.comment = new Comment();}
    @Test
    public void testGetLength() {
        assertEquals(20, ((Comment) comment.match("//here is a comment\n")).getLength());
        assertEquals(19, ((Comment) comment.match("//here is a comment")).getLength());
    }

    @Test
    public void testGetToken() {
        assertNotNull(comment.match("//here is a comment"));

        assertEquals(null, comment.match("\n//here is a comment"));
    }

    @Test
    public void testHtmlStart() {
        assertTrue(comment.htmlStart().equals("<i><font color=\"grey\">"));

        assertFalse(comment.htmlStart().equals(comment.htmlEnd()));
        assertFalse(comment.htmlStart().equals(comment.getHtml()));
        assertFalse(comment.htmlStart().equals(comment.getContent()));
    }



    @Test
    public void testHtmlEnd() {
        assertTrue(comment.htmlEnd().equals("</i></font><br />"));

        assertFalse(comment.htmlEnd().equals(comment.htmlStart()));
        assertFalse(comment.htmlEnd().equals(comment.getHtml()));
        assertFalse(comment.htmlEnd().equals(comment.getContent()));

    }

    @Test
    public void testGetContent() {
        this.comment = ((Comment) comment.match("//here is a comment"));
        assertTrue(comment.getContent().equals("//here is a comment"));

        assertFalse(comment.getContent().equals(comment.htmlStart()));
        assertFalse(comment.getContent().equals(comment.getHtml()));
        assertFalse(comment.getContent().equals(comment.htmlEnd()));

    }
    @Test
    public void testGetHtml(){
        this.comment = ((Comment) comment.match("//here is a comment"));
        assertTrue(comment.getHtml().equals(comment.htmlStart() + "//here is a comment" + comment.htmlEnd()));

        assertFalse(comment.getHtml().equals(comment.htmlStart()));
        assertFalse(comment.getHtml().equals(comment.getContent()));
        assertFalse(comment.getHtml().equals(comment.htmlEnd()));

    }

    @Test
    public void testGetPattern() {
        assertTrue(comment.getPattern() instanceof java.util.regex.Pattern);
    }
}