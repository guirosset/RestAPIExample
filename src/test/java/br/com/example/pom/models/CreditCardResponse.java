package br.com.example.pom.models;

public class CreditCardResponse {

    private String id;
    private String brand;
    private String first6;
    private String last4;
    private Boolean store;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFirst6() {
        return first6;
    }

    public void setFirst6(String first6) {
        this.first6 = first6;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public Boolean getStore() {
        return store;
    }

    public void setStore(Boolean store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "CreditCardResponse{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", first6='" + first6 + '\'' +
                ", last4='" + last4 + '\'' +
                ", store=" + store +
                '}';
    }
}
