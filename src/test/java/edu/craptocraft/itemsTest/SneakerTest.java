package edu.craptocraft.itemsTest;

import edu.craptocraft.items.Sneaker;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import edu.craptocraft.items.Sizes;

public class SneakerTest {
    private Sneaker sneaker;
    @Before
    public void setUp() {
        sneaker = new Sneaker("Nike Craft General Purpose", "Brown", 109.99);
        sneaker.sizesRun(Sizes.CUARENTA, Sizes.CUARENTAYDOS);
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
}
