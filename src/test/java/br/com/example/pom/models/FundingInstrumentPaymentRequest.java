package br.com.example.pom.models;

public class FundingInstrumentPaymentRequest {

    private String method;
    private CreditCardPaymentRequest creditCard;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public CreditCardPaymentRequest getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardPaymentRequest creditCard) {
        this.creditCard = creditCard;
    }
}
