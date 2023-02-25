package edu.craptocraft.itemsTest;

import edu.craptocraft.items.Sizes;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SizesTest {

    private Sizes firstSize;
    private Sizes lastSize;

    @Before
    public void setUp() {
        firstSize = Sizes.TREINTAYNUEVE;
        lastSize = Sizes.CUARENTAYUNO;
    }

    @Test
    public void testGetSizes() {
        List<Sizes> sizes = Sizes.getSizes(firstSize, lastSize);
        assertEquals(4, sizes.size());
        assertEquals(Sizes.TREINTAYNUEVE, sizes.get(0));
        assertEquals(Sizes.CUARENTA, sizes.get(1));
        assertEquals(Sizes.CUARENTAYUNO, sizes.get(3));
    }
}
