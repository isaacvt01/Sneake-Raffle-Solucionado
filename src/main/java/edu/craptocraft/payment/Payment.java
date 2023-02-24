package edu.craptocraft.payment;

import edu.craptocraft.raffle.Bucket;

public interface Payment {
    public boolean autentication (String payment);
    public Boolean pay(String payment, Double total);
    public Double credit(String payment);
}
