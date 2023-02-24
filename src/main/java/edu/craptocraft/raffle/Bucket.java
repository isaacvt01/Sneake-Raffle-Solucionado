package edu.craptocraft.raffle;

import java.util.HashSet;
import java.util.Random;

public class Bucket {
    Random rand = new Random();

    // Se utiliza un HashSet porque no deben haber dos entradas iguales.
    HashSet<Entry> entries = new HashSet<>();

    public Bucket() {}

    public void add(Entry entry){
        if (!isDoubleEntry(entry)){
            entries.add(entry);
        }

    }
    public Integer totalEntries(){
        return this.entries.size();
    }

    private Boolean isDoubleEntry(Entry entry){
        for (Entry comparacion : entries){
            if (entry.equals(comparacion)){
                return true;
            }
        }
        return false;
    }

}
