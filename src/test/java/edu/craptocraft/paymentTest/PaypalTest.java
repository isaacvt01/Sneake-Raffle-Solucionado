package edu.craptocraft.paymentTest;

import edu.craptocraft.payment.Paypal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaypalTest {

    private Paypal paypal;

    @Before
    public void setUp() {
        paypal = new Paypal();
    }

    @Test
    public void testAutentication() {
        assertTrue(paypal.autentication("morty@paypal.com"));
        assertTrue(paypal.autentication("birdman@paypal.com"));
        assertTrue(paypal.autentication("squanchy@paypal.com"));
        assertFalse(paypal.autentication("rick@paypal.com"));
    }

    @Test
    public void testPay() {
        assertTrue(paypal.pay("morty@paypal.com", 50.00));
        assertTrue(paypal.pay("birdman@paypal.com", 100.00));
        assertFalse(paypal.pay("squanchy@paypal.com", 300.00));

        assertEquals(150.00, paypal.credit("morty@paypal.com"), 0);
        assertEquals(100.00, paypal.credit("birdman@paypal.com"), 0);
        assertEquals(200.00, paypal.credit("squanchy@paypal.com"), 0);
    }

    @Test
    public void testCredit() {
        assertEquals(200.00, paypal.credit("morty@paypal.com"), 0);
        assertEquals(200.00, paypal.credit("birdman@paypal.com"), 0);
        assertEquals(200.00, paypal.credit("squanchy@paypal.com"), 0);
        assertNull(paypal.credit("rick@paypal.com"));
    }
}
