package br.com.example.pom.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.Date;

public class CustomerRequest {

    @JsonIgnoreProperties
    private String ownId;
    @JsonIgnore
    private String fullname;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String birthDate;
    @JsonIgnore
    private TaxDocument taxDocument;
    @JsonIgnore
    private Phone phone;
    @JsonIgnore
    private ShippingAddress shippingAddress;
    @JsonIgnore
    private FundingInstrument fundingInstrument;

    public FundingInstrument getFundingInstrument() {
        return fundingInstrument;
    }

    public void setFundingInstrument(FundingInstrument fundingInstrument) {
        this.fundingInstrument = fundingInstrument;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getOwnId() {
        return ownId;
    }

    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public TaxDocument getTaxDocument() {
        return taxDocument;
    }

    public void setTaxDocument(TaxDocument taxDocument) {
        this.taxDocument = taxDocument;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "ownId='" + ownId + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", taxDocument=" + taxDocument +
                ", phone=" + phone +
                ", shippingAddress=" + shippingAddress +
                ", fundingInstrument=" + fundingInstrument +
                '}';
    }
}
