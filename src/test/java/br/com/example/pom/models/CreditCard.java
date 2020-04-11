package br.com.example.pom.models;

public class CreditCard {

    private String expirationMonth;
    private String expirationYear;
    private String number;
    private String cvc;
    private Holder holder;

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "expirationMonth='" + expirationMonth + '\'' +
                ", expirationYear='" + expirationYear + '\'' +
                ", number='" + number + '\'' +
                ", cvc='" + cvc + '\'' +
                ", holder=" + holder +
                '}';
    }
}
