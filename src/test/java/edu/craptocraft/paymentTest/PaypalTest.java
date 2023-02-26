package edu.craptocraft.paymentTest;

import edu.craptocraft.items.Sizes;
import edu.craptocraft.items.Sneaker;
import edu.craptocraft.payment.Paypal;
import edu.craptocraft.raffle.Entry;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaypalTest {

    private Paypal paypal;
    private Sneaker sneaker;
    private Entry entry;

    private Entry doubleEntry;
    private Entry summer ;
    private Entry morty ;
    private Entry  birdman ;

    @Before
    public void setUp() {
        sneaker = new Sneaker("Nike Craft General Purpose", "Brown", 109.99);
        sneaker.sizesRun(Sizes.CUARENTA, Sizes.CUARENTAYDOS);

        entry = new Entry("squanchy@closet.in");
        entry.setUserName("Squanchy");
        entry.setSize(Sizes.CUARENTA);
        entry.setAddress("Nearest closet s/n, 90210, Jerry's House, Via Lactea");
        entry.setTotal(sneaker.price());
        entry.payment("squanchy@paypal.com");

        doubleEntry = new Entry("squan.chy@closet.in");
        doubleEntry.payment("squanchy@paypal.com");

        sneaker.register(entry);
        sneaker.register(doubleEntry);

        birdman = new Entry("birdman@love.in");
        birdman.setUserName("Birdman");
        birdman.setSize(Sizes.CUARENTA);
        birdman.setAddress("Melrose Place, 90210, Los Angeles");
        birdman.setTotal(sneaker.price());
        birdman.payment("birdman@paypal.com");

        morty = new Entry("morty@business.com");
        morty.setUserName("Morty");
        morty.setSize(Sizes.CUARENTA);
        morty.setAddress("Melrose Place, 90210, Los Angeles");
        morty.setTotal(sneaker.price());
        morty.payment("morty@paypal.com");

        summer = new Entry("summer@business.com");
        summer.setUserName("Summer");
        summer.setSize(Sizes.CUARENTA);
        summer.setAddress("Melrose Place, 90210, Los Angeles");
        summer.setTotal(sneaker.price());
        summer.payment("summer@paypal.com");


        sneaker.register(birdman, morty, summer);
        paypal = new Paypal(sneaker);
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
