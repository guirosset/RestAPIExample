package br.com.example.pom.models;

public class Holder {

    private String fullname;
    private String birthdate;
    private TaxDocument taxDocument;
    private BillingAddress billingAddress;
    private Phone phone;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public TaxDocument getTaxDocument() {
        return taxDocument;
    }

    public void setTaxDocument(TaxDocument taxDocument) {
        this.taxDocument = taxDocument;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Holder{" +
                "fullname='" + fullname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", taxDocument=" + taxDocument +
                ", billingAddress=" + billingAddress +
                ", phone=" + phone +
                '}';
    }
}
