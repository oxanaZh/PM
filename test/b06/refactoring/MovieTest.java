package b06.refactoring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Patrick on 03.06.2015.
 */
public class MovieTest {
    String title;
    int priceCode;
    Movie testMovie;
    @Before
    public void setUp() throws Exception {
        this.title = "TestTitle";
        this.priceCode = 5;
        this.testMovie = new Movie(title,priceCode);
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals(title, testMovie.getTitle());
        assertNotEquals("Harry Potter", testMovie.getTitle());
    }

    @Test
    public void testGetPriceCode() throws Exception {
        assertEquals(priceCode,testMovie.getPriceCode());
        assertNotEquals(priceCode+1,testMovie.getPriceCode());
    }
}