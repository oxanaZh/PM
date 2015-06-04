package b06.refactoring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patrick on 03.06.2015.
 */
public class CustomerTest {
    String name;
    Customer customer;
    @Before
    public void setUp() throws Exception {
        this.name = "testCustomer";
        this.customer = new Customer(name);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(name, customer.getName());
        assertNotEquals(name+"a",customer.getName());
    }

    @Test
    public void testAddRental() throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",5),5));
        assertNotNull(customer.generateStatement());

    }

    @Test
    public void testStatement() throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",5),5));
        String outputString ="Rental record for testCustomer\n"+"\ttestMovie\t0.0\n"+ "Amount owned is 0.0\n" + "You earned 1 frequent renter points";
        assertEquals(outputString,customer.generateStatement());
        assertNotEquals(outputString,customer.generateHtmlStatement());
    }

    @Test
    public void testHtmlStatement() throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",5),5));
        String outputString ="<h1>Rental record for <b>testCustomer</b></h1>\n"+"<p>testMovie\t0.0</p>\n"+ "<p>Amount owned is <b>0.0</b></p>\n" + "<p>You earned <b>1 frequent renter points</b></p>";
        assertEquals(outputString, customer.generateHtmlStatement());
        assertNotEquals(outputString, customer.generateStatement());


    }
}