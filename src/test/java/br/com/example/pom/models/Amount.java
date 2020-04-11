package br.com.example.pom.models;

public class Amount {

    private String currency;
    private Subtotal subtotals;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Subtotal getSubtotals() {
        return subtotals;
    }

    public void setSubtotals(Subtotal subtotals) {
        this.subtotals = subtotals;
    }
}
