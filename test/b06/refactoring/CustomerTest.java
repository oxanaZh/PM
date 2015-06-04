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
        customer.addRental(new Rental(new Movie("testMovie",2),5));
        assertNotNull(customer.generateStatement());

    }

    @Test
    public void testStatementChildren() throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",2),5));
        String outputString ="Rental record for testCustomer\n"+"\ttestMovie\t4.5\n"+ "Amount owned is 4.5\n" + "You earned 1 frequent renter points";
        assertEquals(outputString,customer.generateStatement());

    }
    @Test
    public void testStatementRegular()  throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",1),5));
        String outputString ="Rental record for testCustomer\n"+"\ttestMovie\t15.0\n"+ "Amount owned is 15.0\n" + "You earned 2 frequent renter points";
        assertEquals(outputString,customer.generateStatement());
    }
    @Test
    public void testStatementNewRelease()  throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",0),5));
        String outputString ="Rental record for testCustomer\n"+"\ttestMovie\t6.5\n"+ "Amount owned is 6.5\n" + "You earned 1 frequent renter points";
        assertEquals(outputString,customer.generateStatement());
    }
    @Test
    public void testStatementMultipleRental()  throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",2),5));
        customer.addRental(new Rental(new Movie("testMovie",1),5));
        customer.addRental(new Rental(new Movie("testMovie",0),5));
        String outputString ="Rental record for testCustomer\n"+"\ttestMovie\t4.5\n"+"\ttestMovie\t15.0\n"+"\ttestMovie\t6.5\n"+ "Amount owned is 26.0\n" + "You earned 4 frequent renter points";
        assertEquals(outputString,customer.generateStatement());
    }



    @Test
    public void testHtmlStatementChildren() throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",2),5));
        String outputString ="<h1>Rental record for <b>testCustomer</b></h1>\n"+"<p>testMovie\t4.5</p>\n"+ "<p>Amount owned is <b>4.5</b></p>\n" + "<p>You earned <b>1 frequent renter points</b></p>";
        assertEquals(outputString, customer.generateHtmlStatement());
    }
    @Test
    public void testHtmlStatementRegular() throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",1),5));
        String outputString ="<h1>Rental record for <b>testCustomer</b></h1>\n"+"<p>testMovie\t15.0</p>\n"+ "<p>Amount owned is <b>15.0</b></p>\n" + "<p>You earned <b>2 frequent renter points</b></p>";
        assertEquals(outputString, customer.generateHtmlStatement());
    }
    @Test
    public void testHtmlStatementNewRelease() throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",0),5));
        String outputString ="<h1>Rental record for <b>testCustomer</b></h1>\n"+"<p>testMovie\t6.5</p>\n"+ "<p>Amount owned is <b>6.5</b></p>\n" + "<p>You earned <b>1 frequent renter points</b></p>";
        assertEquals(outputString, customer.generateHtmlStatement());
    }
    @Test
    public void testHtmlStatementMultipleRental()  throws Exception {
        customer.addRental(new Rental(new Movie("testMovie",2),5));
        customer.addRental(new Rental(new Movie("testMovie",1),5));
        customer.addRental(new Rental(new Movie("testMovie",0),5));
        String outputString ="<h1>Rental record for <b>testCustomer</b></h1>\n"+"<p>testMovie\t4.5</p>\n"+"<p>testMovie\t15.0</p>\n"+"<p>testMovie	6.5</p>\n"+"<p>Amount owned is <b>26.0</b></p>\n" + "<p>You earned <b>4 frequent renter points</b></p>";
        assertEquals(outputString,customer.generateHtmlStatement());
    }
}