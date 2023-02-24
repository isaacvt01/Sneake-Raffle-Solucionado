package edu.craptocraft.raffle;

import edu.craptocraft.items.Sizes;

public interface Raffle {
    public void sizesRun(Sizes firstSize, Sizes lastSize);
    public Double price();

    void register(Entry entry);

    Integer totalEntries();
}
