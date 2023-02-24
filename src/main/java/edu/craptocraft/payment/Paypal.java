package edu.craptocraft.payment;

import java.util.HashMap;

public class Paypal implements Payment{

    private HashMap<String, Double> users = new HashMap<>();

    public Paypal() {
        users.put("morty@paypal.com", 200.00);
        users.put("birdman@paypal.com", 200.00);
        users.put("squanchy@paypal.com", 200.00);
    }

    @Override
    public boolean autentication(String payment) {
        return users.containsKey(payment);
    }

    @Override
    public Boolean pay(String payment, Double price) {
        Double total = users.get(payment);
        if (total >= price){
            total -= price;
            users.put(payment, total);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Double credit(String payment) {
        return users.get(payment);
    }
}
