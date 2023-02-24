package edu.craptocraft.raffleTest;

import edu.craptocraft.items.Sizes;
import edu.craptocraft.items.Sneaker;
import edu.craptocraft.raffle.Entry;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class EntryTest {
    private Entry entry;
    private Sneaker sneaker;
    @Before
    public void setUp() throws Exception {
        //Creación de sneaker
        sneaker = new Sneaker("Nike Craft General Purpose", "Brown", 109.99);
        sneaker.sizesRun(Sizes.CUARENTA, Sizes.CUARENTAYDOS);

        //Creación de entry
        entry = new Entry("squanchy@closet.in");
        entry.setUserName("Squanchy");
        entry.setSize(Sizes.CUARENTA);
        entry.setAddress("Nearest closet s/n, 90210, Jerry's House, Via Lactea");
        entry.setTotal(sneaker.price());
        entry.payment("squanchy@paypal.com");


    }

    @Test
    public void emailTest() {
        assertEquals("squanchy@closet.in", entry.email());
    }
    @Test
    public void totalTest() {
        assertEquals(109.99, entry.getTotal(), 0);
    }

    @Test
    public void paymentTest() {
        assertEquals("squanchy@paypal.com", entry.payment());
    }

    @Test
    public void toStringTest() {
        String esperado = "\t\temail: squanchy@closet.in\n" +
                "\t\tSize: CUARENTA\n" +
                "\t\tAddress: Nearest closet s/n, 90210, Jerry's House, Via Lactea\n" +
                "\t\tPayment: squanchy@paypal.com\n" +
                "\t\tTotal: 109.99\n";
        assertEquals(esperado, entry.toString());
    }
}