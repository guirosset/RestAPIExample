package br.com.example.pom.models;

public class PaymentRequest {

    private Integer installmentCount;
    private String statementDescriptor;
    private FundingInstrumentPaymentRequest fundingInstrument;
    private Device device;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Integer getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(Integer installmentCount) {
        this.installmentCount = installmentCount;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public FundingInstrumentPaymentRequest getFundingInstrument() {
        return fundingInstrument;
    }

    public void setFundingInstrument(FundingInstrumentPaymentRequest fundingInstrument) {
        this.fundingInstrument = fundingInstrument;
    }
}
