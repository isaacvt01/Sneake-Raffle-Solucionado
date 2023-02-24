package edu.craptocraft.raffle;

import edu.craptocraft.items.Sizes;
import edu.craptocraft.items.Sneaker;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class BucketTest {
    private Bucket bucket;
    private Entry entry;
    private Sneaker sneaker;
    @Before
    public void setUp() throws Exception {
        sneaker = new Sneaker("Nike Craft General Purpose", "Brown", 109.99);
        sneaker.sizesRun(Sizes.CUARENTA, Sizes.CUARENTAYDOS);

        entry = new Entry("squanchy@closet.in");
        entry.setUserName("Squanchy");
        entry.setSize(Sizes.CUARENTA);
        entry.setAddress("Nearest closet s/n, 90210, Jerry's House, Via Lactea");
        entry.setTotal(sneaker.price());
        entry.payment("squanchy@paypal.com");

        bucket = new Bucket();
        bucket.add(entry);

    }



    @Test
    public void totalEntriesTest() {
        Integer numEsperado = 1;
        assertEquals(numEsperado, bucket.totalEntries());
    }
}