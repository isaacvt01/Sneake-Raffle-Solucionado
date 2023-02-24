package edu.craptocraft.items;

import edu.craptocraft.raffle.Raffle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sneaker implements Raffle {
    private final String style;
    private final String name;
    private final Double price;
    private String[] sizes;

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
