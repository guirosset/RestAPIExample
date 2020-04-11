package br.com.example.pom.models;

public class CardResponse {

    private String brand;
    private Boolean store;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getStore() {
        return store;
    }

    public void setStore(Boolean store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "CardResponse{" +
                "brand='" + brand + '\'' +
                ", store=" + store +
                '}';
    }
}
