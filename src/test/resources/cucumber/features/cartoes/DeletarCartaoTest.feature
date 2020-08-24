## Quando usado o {@code DEFAULT}, os valores são recuperados do arquivo application.properties.

@Cards @DeletarCartao
Feature: Delete a Card
  Quero poder atualizar um Cartao existente em um quadro.

  Background:
    # Cria um quadro novo com nome de "Delete a Card". 
    Given um "POST" para o servico "1/boards/"
      And uma key "DEFAULT"
      And um token "DEFAULT"
      And o nome do quadro "Delete a Card"
     When executo o servico
     Then obtenho um ID

    # Cria um cartao novo.
    Given um "POST" para o servico "1/cards"
      And uma key "DEFAULT"
      And um token "DEFAULT"
      And e uma lista para criacao do Cartao
     When executo o servico
     Then obtenho um ID

  @Sucesso
  Scenario: Deve Deletar Um Cartao
    Given um "DELETE" para o servico "1/cards/{id}"
      And uma key "DEFAULT"
      And um token "DEFAULT"
      And passo um ID
     When executo o servico
     Then obtenho um HTTP status 200