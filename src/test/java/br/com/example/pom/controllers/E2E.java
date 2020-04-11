package br.com.example.pom.controllers;

import br.com.example.pom.mock.Mock;
import br.com.example.pom.models.*;
import com.google.gson.Gson;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.given;

@Component
public class E2E {

    @Value( "${sandbox.user.api}" )
    private String user;

    @Value( "${sandbox.hash.api}" )
    private String hash;

    @Value( "${sandbox.token.api}" )
    private String token;

    private static final String URL = "https://sandbox.moip.com.br/";

    private String customerId;
    private String customerOwnId;
    private String orderId;
    private String paymentId;


    /**
     * Este método realiza uma chamada no recurso customers
     * Para fazer a chamada precisa passar as chaves de acesso no método auth
     * A execução do método com sucesso deve retornar statuscode 201 created
     * A classe Mock tem representação dos recursos para o Post request
     */
    public void postCreateCustomer() {

        CustomerRequest customerRequest = Mock.customerRequestMock();

        String jsonInString = new Gson().toJson( customerRequest );

        CustomerResponse response = given()
                .baseUri( URL )
                .contentType( "application/json" )
                .auth().preemptive().basic( user, token )
                .body( jsonInString )
                .when()
                .post( "v2/customers" )
                .then().assertThat().statusCode( 201 )
                .and()
                .extract()
                .as( CustomerResponse.class );

        this.customerId = response.getId();
        this.customerOwnId = response.getOwnId();
    }

    /**
     * Este método realiza chamada para o recurso fundinginstruments
     * Este método deve receber por pathParam o id do customer
     */
    public void postCreateCreditCard() {

        FundingInstrument fundingInstrument = Mock.fundingInstrumentMock();

        String jsonInString = new Gson().toJson( fundingInstrument );

        FundingInstrumentResponse response = given()
                .baseUri( URL )
                .pathParam( "customerId", customerId)
                .contentType( "application/json" )
                .auth().preemptive().basic( user, token )
                .body( jsonInString )
                .when()
                .post( "v2/customers/{customerId}/fundinginstruments" )
                .then().assertThat().statusCode( 201 )
                .and()
                .extract().as( FundingInstrumentResponse.class );
    }

    /**
     *  A classe Mock tem representação dos recursos para o Post request
     *  Esta classe cria um pedido recuperando as variaveis customerOwnId e customerId e passadas por parametro no método orderRequestMock
     *  Em caso de sucesso o statuscode 201 created é esperado
     */
    public void createOrder() {

        OrderRequest orderRequest = Mock.orderRequestMock( customerOwnId, customerId );

        String jsonInString = new Gson().toJson( orderRequest );

        OrderResponse response = given()
                .baseUri( URL )
                .contentType( "application/json" )
                .auth().preemptive().basic( user, token )
                .body( jsonInString )
                .when()
                .post( "v2/orders" )
                .then().assertThat().statusCode( 201 )
                .and()
                .extract().as( OrderResponse.class );

        this.orderId = response.getId();

    }

    /**
     * Este método faz um Post no recurso orders/orderId/payments e o orderId deve ser passado no pathParam
     * O statuscode 201 created é esperado
     */
    public void createPayment() {

        PaymentRequest paymentRequest = Mock.paymentRequestMock( hash );

        String jsonInString = new Gson().toJson( paymentRequest );

        PaymentResponse response = given()
                .baseUri( URL )
                .pathParam( "orderId", orderId )
                .contentType( "application/json" )
                .auth().preemptive().basic( user, token )
                .body( jsonInString )
                .when()
                .post( "v2/orders/{orderId}/payments" )
                .then().assertThat().statusCode( 201 )
                .and()
                .extract().as( PaymentResponse.class );

        this.paymentId = response.getId();

    }


    /**
     * Este método simula um pagamento com o respectivo paymentId passado por queryParam
     * O StatusCode 200 é esperado com BodyResponse vazio
     */
    public void forcePayment(){

        given().baseUri( URL )
                .queryParam( "payment_id", paymentId )
                .auth().preemptive().basic( user, token )
                .when()
                .get( "simulador/authorize" )
                .then()
                .assertThat()
                .statusCode( 200 );

    }

}
