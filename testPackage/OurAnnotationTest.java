import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patrick on 28.05.2015.
 */
public class OurAnnotationTest {
    Annotation annotation;

    @Before
    public void setUp() {
        this.annotation = new Annotation();
    }

    @Test
    public void testGetLength() {
        assertEquals(9, annotation.match("@Override\n").getLength());
        assertEquals(9, annotation.match("@Override").getLength());
    }

    @Test
    public void testGetToken() {
        assertNotNull(annotation.match("@Override"));

        assertEquals(null, annotation.match("\nOverride"));
        assertEquals(null, annotation.match("\n@Override"));
    }

    @Test
    public void testHtmlStart() {
        assertTrue(annotation.htmlStart().equals("<font color=\"blue\">"));

        assertFalse(annotation.htmlStart().equals(annotation.htmlEnd()));
        assertFalse(annotation.htmlStart().equals(annotation.getHtml()));
        assertFalse(annotation.htmlStart().equals(annotation.getContent()));
    }



    @Test
    public void testHtmlEnd() {
        assertTrue(annotation.htmlEnd().equals("</font>"));

        assertFalse(annotation.htmlEnd().equals(annotation.htmlStart()));
        assertFalse(annotation.htmlEnd().equals(annotation.getHtml()));
        assertFalse(annotation.htmlEnd().equals(annotation.getContent()));

    }

    @Test
    public void testGetContent() {
        this.annotation = ((Annotation) annotation.match("@Override"));
        assertTrue(annotation.getContent().equals("@Override"));

        assertFalse(annotation.getContent().equals(annotation.htmlStart()));
        assertFalse(annotation.getContent().equals(annotation.getHtml()));
        assertFalse(annotation.getContent().equals(annotation.htmlEnd()));

    }
    @Test
    public void testGetHtml(){
        this.annotation = ((Annotation) annotation.match("@Override"));
        assertTrue(annotation.getHtml().equals(annotation.htmlStart() + "@Override" + annotation.htmlEnd()));

        assertFalse(annotation.getHtml().equals(annotation.htmlStart()));
        assertFalse(annotation.getHtml().equals(annotation.getContent()));
        assertFalse(annotation.getHtml().equals(annotation.htmlEnd()));

    }

    @Test
    public void testGetPattern() {
        assertTrue(annotation.getPattern() instanceof java.util.regex.Pattern);
    }
}