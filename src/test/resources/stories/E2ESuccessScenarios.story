Feature: calculation

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: 1 compra de produto
Given Cria usuario e cartao
When Cria ordem de pedido e pagamento
Then Simula Pagamento
