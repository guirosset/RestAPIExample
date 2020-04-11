package br.com.example.pom.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingInstrument {

    private String method;
    private CreditCard creditCard;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "FundingInstrument{" +
                "method='" + method + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }
}
