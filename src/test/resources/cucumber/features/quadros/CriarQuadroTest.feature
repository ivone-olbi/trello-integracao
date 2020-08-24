## Quando usado o {@code DEFAULT}, os valores são recuperados do arquivo application.properties.

@Boards @CriarQuadro
Feature: Create a Board
  Quero poder criar um Quadro.

  @Sucesso
  Scenario Outline: Deve Criar Um Quadro Novo
    Given um "POST" para o servico "1/boards/"
      And uma key "DEFAULT"
      And um token "DEFAULT"
      And o nome do quadro <nome>
     When executo o servico
     Then obtenho um HTTP status 200

   Examples:
      | nome               |
      | "Create a Board"   |
      | "Sensedia + Ivone" |

  @Alternativo
  Scenario: Nao Deve Driar Um Quadro Com Uma Key Invalida
    Given um "POST" para o servico "1/boards/"
      And uma key "invalid key"
      And um token "DEFAULT"
      And o nome do quadro "Sensedia"
     When executo o servico
     Then obtenho um HTTP status 401