package br.com.example.pom.models;

public class CreditCardPaymentRequest {

    private String hash;
    private Boolean store;
    private HolderPaymentRequest holder;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Boolean getStore() {
        return store;
    }

    public void setStore(Boolean store) {
        this.store = store;
    }

    public HolderPaymentRequest getHolder() {
        return holder;
    }

    public void setHolder(HolderPaymentRequest holder) {
        this.holder = holder;
    }
}
