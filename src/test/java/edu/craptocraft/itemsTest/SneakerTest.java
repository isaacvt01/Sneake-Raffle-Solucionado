package edu.craptocraft.itemsTest;

import edu.craptocraft.items.Sneaker;
import edu.craptocraft.raffle.Entry;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import edu.craptocraft.items.Sizes;

public class SneakerTest {
    private Sneaker sneaker;
    private Entry entry;
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

        sneaker.register(entry);
    }

    @Test
    public void priceTest() {
        assertEquals(109.99, sneaker.price(), 0);
    }

    @Test
    public void sizesTest() {
        assertArrayEquals(new String[]{"7.0 US", "7.5 US", "8.0 US", "8.5 US"}, sneaker.sizes());
    }

    @Test
    public void toStringTest() {
        String esperado = "Nike Craft General Purpose\n" +
                "\t\tBrown\n" +
                "\t\t109.99\t\t[7.0 US, 7.5 US, 8.0 US, 8.5 US]\n";
        assertEquals(esperado, sneaker.toString());
    }



    @Test
    public void totalEntriesTest() {
        Integer esperado = 1;
        assertEquals(esperado, sneaker.totalEntries());
    }
}
