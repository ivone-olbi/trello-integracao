package br.com.ivone.integracao.trello.cartoes;

import static br.com.ivone.integracao.trello.servicos.Propriedades.propriedade;
import static io.restassured.RestAssured.given;

import br.com.ivone.integracao.trello.injecao.RestAssured;
import br.com.ivone.integracao.trello.modelo.Trello;
import io.cucumber.java.en.And;
import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor
public class CriarCartaoTest {

    // Injetado via PicoContainer.
    private final RestAssured assured;

    // Injetado via PicoContainer.
    private final Trello trello;

    @And("e uma lista para criacao do Cartao")
    public void e_uma_lista_para_criacao_do_Cartao() {

        val id = given()
                    .queryParam("key",   propriedade("trello.key"))
                    .queryParam("token", propriedade("trello.token"))
                    .contentType(ContentType.JSON)
                 .when()
                    .get(propriedade("trello.url") + "1/boards/{id}/lists", trello.getCurrentId())
                 .then()
                    .extract().body().jsonPath().getList("id", String.class).get(0);

        assured.queryParam("idList", id);

    }

}