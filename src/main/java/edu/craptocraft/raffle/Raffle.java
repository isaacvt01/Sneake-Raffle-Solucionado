package edu.craptocraft.raffle;
import edu.craptocraft.items.Sizes;
import java.util.List;


public interface Raffle {
    public void sizesRun(Sizes firstSize, Sizes lastSize);
    public Double price();

    void register(Entry... entry);

    Integer totalEntries();

    String listEntries();

    void cancel(Entry entry);

    Entry draw();
    public List<Entry> entries();
}
