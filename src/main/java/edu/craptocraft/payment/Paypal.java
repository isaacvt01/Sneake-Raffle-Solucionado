package edu.craptocraft.payment;

import edu.craptocraft.raffle.Entry;
import edu.craptocraft.raffle.Raffle;

import java.util.HashMap;

public class Paypal implements Payment{

    private HashMap<String, Double> users = new HashMap<>();
    //Se introduce en el constructor el objeto de tipo Raffle para que coja todas las personas dentro y añada su cuenta de Paypal de manera automática
    public Paypal(Raffle item) {
        item.entries().stream()
                .map(Entry::getPayment)
                .forEach(payment -> users.putIfAbsent(payment, 200d));
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
