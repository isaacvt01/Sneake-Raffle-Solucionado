package edu.craptocraft.items;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public enum Sizes {
    TREINTAYNUEVE ("39", "6.5 US" ),
    CUARENTA ("40", "7.0 US" ),
    CUARENTAYMEDIO ("40.5", "7.5 US" ),
    CUARENTAYUNO ("41", "8.0 US" ),
    CUARENTAYDOS ("42", "8.5 US" ),
    CUARENTAYTRES ("43", "9.0 US" );

    private final String EUsize;
    private final String USsize;

    Sizes(String EUSize, String USsize) {
        this.EUsize = EUSize;
        this.USsize = USsize;
    }

    public String getUSsize() {
        return USsize;
    }


   static public List<Sizes> getSizes(Sizes firstSize, Sizes lastSize){

        return new ArrayList<>(EnumSet.range(firstSize, lastSize));
    }
}
