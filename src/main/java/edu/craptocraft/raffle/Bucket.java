package edu.craptocraft.raffle;

import java.util.*;

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


    public String listEntries() {
        return  entries.stream()
                .map(Entry::email)
                .toList()
                .toString();

    }

    public void delete(Entry entry) {
        entries.remove(entry);
    }

    public Optional<Entry> draw() {
        int posicion = rand.nextInt(entries.size());
        List<Entry> entriesList = entries.stream().toList();
        Optional<Entry> ganador = entriesList.stream()
                .filter(entry -> entriesList.indexOf(entry) == posicion)
                .findAny();
        return Optional.of(ganador.get());
    }

    public List<Entry> entries() {
        return this.entries.stream().toList();
    }
}
