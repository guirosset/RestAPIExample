package br.com.example.pom.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingInstrumentResponse {

    private CreditCardResponse creditCard;
    private CardResponse card;
    private boolean isPresential;
    private String method;

    public CreditCardResponse getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardResponse creditCard) {
        this.creditCard = creditCard;
    }

    public CardResponse getCard() {
        return card;
    }

    public void setCard(CardResponse card) {
        this.card = card;
    }

    public boolean isPresential() {
        return isPresential;
    }

    public void setPresential(boolean presential) {
        isPresential = presential;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "FundingInstrumentResponse{" +
                "creditCard=" + creditCard +
                ", card=" + card +
                ", isPresential=" + isPresential +
                ", method='" + method + '\'' +
                '}';
    }
}
