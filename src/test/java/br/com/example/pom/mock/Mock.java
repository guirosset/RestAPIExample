package br.com.example.pom.mock;

import br.com.example.pom.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Mock {

    public static CustomerRequest customerRequestMock() {
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setOwnId( UUID.randomUUID().toString() );
        customerRequest.setFullname( "Guilherme Rosset" );
        customerRequest.setEmail( "guilherme.rosset@wirecard.com" );
        customerRequest.setBirthDate( "1980-10-22" );
        customerRequest.setTaxDocument( new TaxDocument( "CPF", "10013390023" ) );
        customerRequest.setPhone( new Phone( "55", "11", "22226842" ) );
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCity( "Rio de Janeiro" );
        shippingAddress.setDistrict( "Ipanema" );
        shippingAddress.setStreet( "Avenida Atlantica" );
        shippingAddress.setStreetNumber( "60" );
        shippingAddress.setZipCode( "02446000" );
        shippingAddress.setState( "RJ" );
        shippingAddress.setCountry( "BRA" );
        customerRequest.setShippingAddress( shippingAddress );
        FundingInstrument fundingInstrument = new FundingInstrument();
        fundingInstrument.setMethod( "CREDIT_CARD" );
        CreditCard creditCard = new CreditCard();
        creditCard.setExpirationMonth( "06" );
        creditCard.setExpirationYear( "22" );
        creditCard.setNumber( "5555666677778884" );
        creditCard.setCvc( "123" );
        Holder holder = new Holder();
        holder.setFullname( "Guilherme Rosset" );
        holder.setBirthdate( "1980-10-22" );
        TaxDocument taxDocument = new TaxDocument();
        taxDocument.setType( "CPF" );
        taxDocument.setNumber( "10013390023" );
        holder.setTaxDocument( taxDocument );
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCity( "Rio de Janeiro" );
        billingAddress.setDistrict( "Copacabana" );
        billingAddress.setStreet( "Rua Raimundo Corrêa" );
        billingAddress.setStreetNumber( "1200" );
        billingAddress.setZipCode( "02446000" );
        billingAddress.setState( "RJ" );
        billingAddress.setCountry( "BRA" );
        holder.setBillingAddress( billingAddress );
        holder.setPhone( new Phone( "55", "11", "22226842" ) );
        creditCard.setHolder( holder );
        fundingInstrument.setCreditCard( creditCard );
        customerRequest.setFundingInstrument( fundingInstrument );

        return customerRequest;
    }

    public static FundingInstrument fundingInstrumentMock() {
        FundingInstrument fundingInstrument = new FundingInstrument();
        fundingInstrument.setMethod( "CREDIT_CARD" );
        CreditCard creditCard = new CreditCard();
        creditCard.setExpirationMonth( "06" );
        creditCard.setExpirationYear( "22" );
        creditCard.setNumber( "5555666677778884" );
        creditCard.setCvc( "123" );
        Holder holder = new Holder();
        holder.setFullname( "Guilherme Rosset" );
        holder.setBirthdate( "1980-10-22" );
        TaxDocument taxDocument = new TaxDocument();
        taxDocument.setType( "CPF" );
        taxDocument.setNumber( "10013390023" );
        holder.setTaxDocument( taxDocument );
        holder.setPhone( new Phone( "55", "11", "22226842" ) );
        creditCard.setHolder( holder );
        fundingInstrument.setCreditCard( creditCard );

        return fundingInstrument;
    }

    public static OrderRequest orderRequestMock(String customerOwnId, String customerId) {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOwnId( customerOwnId );
        Amount amount = new Amount();
        amount.setCurrency( "BRL" );
        Subtotal subtotal = new Subtotal();
        subtotal.setShipping( 1500 );
        amount.setSubtotals( subtotal );
        orderRequest.setAmount( amount );
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setProduct( "Descrição do pedido" );
        item.setCategory( "CLOTHING" );
        item.setQuantity( 1 );
        item.setDetail( "Camiseta estampada branca" );
        item.setPrice( 1500 );
        items.add( item );
        orderRequest.setItems( items );
        CustomerOrderRequest customerOrderRequest = new CustomerOrderRequest();
        customerOrderRequest.setId( customerId );
        orderRequest.setCustomer( customerOrderRequest );

        return orderRequest;
    }

    public static PaymentRequest paymentRequestMock(String creditCardHash) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setInstallmentCount( 1 );
        paymentRequest.setStatementDescriptor( "minhaLoja.com" );
        FundingInstrumentPaymentRequest fundingInstrumentPaymentRequest = new FundingInstrumentPaymentRequest();
        fundingInstrumentPaymentRequest.setMethod( "CREDIT_CARD" );
        CreditCardPaymentRequest creditCardPaymentRequest = new CreditCardPaymentRequest();
        creditCardPaymentRequest.setHash( creditCardHash );
        creditCardPaymentRequest.setStore( true );
        HolderPaymentRequest holderPaymentRequest = new HolderPaymentRequest();
        holderPaymentRequest.setFullname( "Guilherme Rosset" );
        holderPaymentRequest.setBirthdate( "1980-10-22" );
        TaxDocument taxDocument = new TaxDocument();
        taxDocument.setType( "CPF" );
        taxDocument.setNumber( "10013390023" );
        holderPaymentRequest.setTaxDocument( taxDocument );
        holderPaymentRequest.setPhone( new Phone( "55", "11", "22226842" ) );
        creditCardPaymentRequest.setHolder( holderPaymentRequest );
        fundingInstrumentPaymentRequest.setCreditCard( creditCardPaymentRequest );
        paymentRequest.setFundingInstrument( fundingInstrumentPaymentRequest );
        Device device = new Device();
        device.setIp( "127.0.0.1" );
        device.setGeolocation( new Geolocation( -33.867, 151.206 ) );
        device.setUserAgent( "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36" );
        device.setFingerprint( "QAZXswedCVGrtgBNHyujMKIkolpQAZXswedCVGrtgBNHyujMKIkolpQAZXswedCVGrtgBNHyujMKIkolpQAZXswedCVGrtgBNHyujMKIkolp" );
        paymentRequest.setDevice( device );

        return paymentRequest;
    }
}
