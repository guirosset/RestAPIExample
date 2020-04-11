package br.com.example.pom.controllers;

import br.com.example.pom.mock.Mock;
import br.com.example.pom.models.CustomerRequest;
import br.com.example.pom.models.CustomerResponse;
import br.com.example.pom.models.ErrorScenarioResponse;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class ErrorScenarios {

    @Value("${sandbox.user.api}")
    private String user;

    @Value("${sandbox.token.api}")
    private String token;

    private static final String URL = "https://sandbox.moip.com.br/";

    private Logger logger = LoggerFactory.getLogger(ErrorScenarios.class);


    /**
     * Esse método realiza a verificação do tratamento de CPF invalido contendo mais digitos que o permitido
     * O statuscode 400 é esperado retornando postivo para o cenário
     */
    public void validateInvalidCpf() {

        CustomerRequest customerRequest = Mock.customerRequestMock();
        customerRequest.getTaxDocument().setNumber( "444444444444444444444444" );

        String jsonInString = new Gson().toJson( customerRequest );

        ErrorScenarioResponse response = given()
                .baseUri( URL )
                .contentType( "application/json" )
                .auth().preemptive().basic( user, token )
                .body( jsonInString )
                .when()
                .post( "v2/customers" )
                .then().assertThat().statusCode( 400 )
                .and()
                .extract()
                .as( ErrorScenarioResponse.class );


        response.getErrors().forEach( error -> {

            Assert.assertEquals( error.getDescription(), "O CPF informado deve ter 11 números" );
            Assert.assertEquals( error.getCode(), "PAY-036" );
            Assert.assertEquals( error.getPath(), "taxDocument.validCpf" );

        } );


    }

    /**
     * Foi identificado um erro inexperado tendo StatusCode 500 em um cenario que era esperado 400
     * O erro ocorre quando é passado uma quantidade especifica de caracteres no atributo ownId
     * É gerado um Log dentro da pasta target/jbehave
     */
    public void validateMaxLengthOwnId() {

        CustomerRequest customerRequest = Mock.customerRequestMock();
        customerRequest.setOwnId( "11111111111111111111111111111111111111111111111111111111" );

        String jsonInString = new Gson().toJson( customerRequest );

        Response response = given()
                .baseUri( URL )
                .contentType( "application/json" )
                .auth().preemptive().basic( user, token )
                .body( jsonInString )
                .when()
                .post( "v2/customers" )
                .then().assertThat().statusCode( 500 ).extract().response();

        logger.error(response.body().print());

    }


}
