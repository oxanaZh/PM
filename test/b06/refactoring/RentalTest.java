package b06.refactoring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Patrick on 03.06.2015.
 */
public class RentalTest {
    Movie testMovie;
    int daysRented;
    Rental rental;


    @Before
    public void setUp() throws Exception {
        this.daysRented = 10;
        this.testMovie = new Movie("Testfilm", 5);
        this.rental = new Rental(testMovie, daysRented);
    }

    @Test
    public void testGetMovie() throws Exception {
        assertEquals(testMovie, rental.getMovie());
        assertNotEquals(new Movie("anderer Fim",5),rental.getMovie());
    }

    @Test
    public void testGetDaysRented() throws Exception {
        assertEquals(10,rental.getDaysRented());
        assertNotEquals(9,rental.getDaysRented());
    }
}