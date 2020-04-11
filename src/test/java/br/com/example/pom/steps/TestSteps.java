package br.com.example.pom.steps;

import br.com.example.pom.controllers.E2E;
import br.com.example.pom.controllers.ErrorScenarios;
import org.jbehave.core.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestSteps {

    @Autowired
    private E2E e2E;

    @Autowired
    private ErrorScenarios errorScenarios;

    @Given("Cria usuario e cartao")
    public void criaUsuarioCartao() {
        this.e2E.postCreateCustomer();
        this.e2E.postCreateCreditCard();
    }

    @When( "Cria ordem de pedido e pagamento" )
    public void criaOrdemPedidoPagamento(){
        this.e2E.createOrder();
        this.e2E.createPayment();
    }

    @Then( "Simula Pagamento" )
    public void simulaPagamento(){
        this.e2E.forcePayment();
    }

    @Given("O usuario insere CPF invalido")
    public void submitRequestInvalidCpf() {
        this.errorScenarios.validateInvalidCpf();
        this.errorScenarios.validateMaxLengthOwnId();
    }

}