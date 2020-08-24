# Quando usado o {@code DEFAULT}, os valores são recuperados do arquivo application.properties.

@Boards @DeletarQuadro
Feature: Delete a Board
  Quero poder excluir um Quadro.

  Background:
    # Cria um Quadro novo com nome de "Delete a Board".
    Given um "POST" para o servico "1/boards/"
      And uma key "DEFAULT"
      And um token "DEFAULT"
      And o nome do quadro "Delete a Board"
     When executo o servico
     Then obtenho um ID

  @Sucesso
  Scenario: Deve Deletar Um Quadro
    Given um "DELETE" para o servico "1/boards/{id}"
      And uma key "DEFAULT"
      And um token "DEFAULT"
      And passo um ID
     When executo o servico
     Then obtenho um HTTP status 200
     # TODO no futuro realizar uma nova consulta para verificar se o Quadro ainda existe.