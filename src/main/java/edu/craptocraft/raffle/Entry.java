package edu.craptocraft.raffle;

import edu.craptocraft.items.Sizes;

public class Entry {

    private final String email;
    private String userName;
    private String address;
    private Double total;
    private Sizes size;
    private String payment;
    public Entry(String email) {
        this.email = email;
    }

    public String email(){
        return this.email;
    }

    public void setUserName(String userName) {
        this.userName =userName;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotal(Double price) {
        this.total = price;
    }

    public void payment(String payment) {
        this.payment = payment;
    }

    public String payment(){
        return this.payment;
    }
    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t\t").append("email: ").append(email).append("\n");
        sb.append("\t\t").append("Size: ").append(size).append("\n");
        sb.append("\t\t").append("Address: ").append(address).append("\n");
        sb.append("\t\t").append("Payment: ").append(payment).append("\n");
        sb.append("\t\t").append("Total: ").append(total).append("\n");
        return sb.toString();
    }
}
