package br.com.example.pom.models;

import java.util.List;

public class OrderRequest {

    private String ownId;
    private Amount amount;
    private List<Item> items;
    private CustomerOrderRequest customer;

    public CustomerOrderRequest getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerOrderRequest customer) {
        this.customer = customer;
    }

    public String getOwnId() {
        return ownId;
    }

    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
