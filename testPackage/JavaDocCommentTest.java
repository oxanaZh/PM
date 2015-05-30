import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patrick on 28.05.2015.
 */
public class JavaDocCommentTest {
    JavaDocComment javaDocComment;

    @Before
    public void setUp() {this.javaDocComment = new JavaDocComment();}
    @Test
    public void testGetLength() {
        assertEquals(71, ((JavaDocComment) javaDocComment.match("/**\n*Ich\n *bin\n *ein\n *javadoc\n *kommentar\n *@return Match-Ergebnis\n**/")).getLength());
        assertEquals(71, ((JavaDocComment) javaDocComment.match("/**\n*Ich\n *bin\n *ein\n *javadoc\n *kommentar\n *@return Match-Ergebnis\n**///IchbinkeinJavadocKommentar")).getLength());
    }
    /*
    
     */
    @Test
    public void testGetToken() {
        assertNotNull(javaDocComment.match("/**\n*Ich\n *bin\n *ein\n *javadoc\n *kommentar\n *@return Match-Ergebnis\n**/"));

        assertEquals(null, javaDocComment.match("//here is a fake javadoc"));
    }

    @Test
    public void testHtmlStart() {
        assertTrue(javaDocComment.htmlStart().equals("<font color=\"blue\">"));

        assertFalse(javaDocComment.htmlStart().equals(javaDocComment.htmlEnd()));
        assertFalse(javaDocComment.htmlStart().equals(javaDocComment.getHtml()));
        assertFalse(javaDocComment.htmlStart().equals(javaDocComment.getContent()));
    }



    @Test
    public void testHtmlEnd() {
        assertTrue(javaDocComment.htmlEnd().equals("</font>"));

        assertFalse(javaDocComment.htmlEnd().equals(javaDocComment.htmlStart()));
        assertFalse(javaDocComment.htmlEnd().equals(javaDocComment.getHtml()));
        assertFalse(javaDocComment.htmlEnd().equals(javaDocComment.getContent()));

    }

    @Test
    public void testGetContent() {
        this.javaDocComment = ((JavaDocComment) javaDocComment.match("/**\n*Ich\n *bin\n *ein\n *javadoc\n *kommentar\n *@return Match-Ergebnis\n**/"));
        assertTrue(javaDocComment.getContent().equals("/**\n*Ich\n *bin\n *ein\n *javadoc\n *kommentar\n *@return Match-Ergebnis\n**/"));

        assertFalse(javaDocComment.getContent().equals(javaDocComment.htmlStart()));
        assertFalse(javaDocComment.getContent().equals(javaDocComment.getHtml()));
        assertFalse(javaDocComment.getContent().equals(javaDocComment.htmlEnd()));

    }
    @Test
    public void testGetHtml(){
        this.javaDocComment = ((JavaDocComment) javaDocComment.match("/**\n*Ich\n *bin\n *ein\n *javadoc\n *kommentar\n *@return Match-Ergebnis\n**/"));
        assertTrue(javaDocComment.getHtml().equals(javaDocComment.htmlStart() + "/**\n*Ich\n *bin\n *ein\n *javadoc\n *kommentar\n *@return Match-Ergebnis\n**/" + javaDocComment.htmlEnd()));

        assertFalse(javaDocComment.getHtml().equals(javaDocComment.htmlStart()));
        assertFalse(javaDocComment.getHtml().equals(javaDocComment.getContent()));
        assertFalse(javaDocComment.getHtml().equals(javaDocComment.htmlEnd()));

    }

    @Test
    public void testGetPattern() {
        assertTrue(javaDocComment.getPattern() instanceof java.util.regex.Pattern);
    }
}