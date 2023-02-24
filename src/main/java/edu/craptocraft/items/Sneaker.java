package edu.craptocraft.items;

import edu.craptocraft.raffle.Bucket;
import edu.craptocraft.raffle.Entry;
import edu.craptocraft.raffle.Raffle;

import java.util.Arrays;

public class Sneaker implements Raffle {
    private final String style;
    private final String name;
    private final Double price;
    private String[] sizes;

    private Bucket bucket = new Bucket();

    public Sneaker(String name, String style, Double price){
        this.style = style;
        this.name = name;
        this.price = price;
    }

    @Override
    public Double price(){
        return price;
    }

    @Override
    public void register(Entry... entry) {
        Arrays.stream(entry).forEach(o -> bucket.add(o));

    }

    @Override
    public Integer totalEntries() {
        return bucket.totalEntries();
    }

    @Override
    public String listEntries() {
        return bucket.listEntries();
    }

    @Override
    public void cancel(Entry entry) {
        bucket.delete(entry);
    }

    @Override
    public void sizesRun(Sizes firsSize, Sizes lastSize){
       sizes = Sizes.getSizes(firsSize, lastSize).stream()
                .toList()
                    .stream()
                    .map(Sizes::getUSsize)
                    .toArray(String[]::new);
    }

    public String[] sizes(){
        return sizes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name).append('\n');
        sb.append("\t\t").append(style).append('\n');
        sb.append("\t\t").append(price);
        sb.append("\t\t").append(Arrays.toString(sizes));
        sb.append('\n');
        return sb.toString();
    }
}
