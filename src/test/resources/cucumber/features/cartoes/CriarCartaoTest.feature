## Quando usado o {@code DEFAULT}, os valores são recuperados do arquivo application.properties.

@Cards @CriarCartao
Feature: Create a new Card
  Quero poder criar um Cartao em um quadro existente.

  Background:
    # Cria um quadro novo com nome de "Create a new Card". 
    Given um "POST" para o servico "1/boards/"
      And uma key "DEFAULT"
      And um token "DEFAULT"
      And o nome do quadro "Create a new Card"
     When executo o servico
     Then obtenho um ID

  @Sucesso
  Scenario: Deve Criar Um Cartao Novo
    Given um "POST" para o servico "1/cards"
      And uma key "DEFAULT"
      And um token "DEFAULT"
      And e uma lista para criacao do Cartao
     When executo o servico
     Then obtenho um HTTP status 200