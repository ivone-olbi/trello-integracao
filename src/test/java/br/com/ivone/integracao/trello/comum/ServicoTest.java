package br.com.ivone.integracao.trello.comum;

import static br.com.ivone.integracao.trello.servicos.Propriedades.propriedade;

import br.com.ivone.integracao.trello.injecao.RestAssured;
import br.com.ivone.integracao.trello.modelo.Trello;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicoTest {

    // Injetado via PicoContainer.
    private final RestAssured assured;

    // Injetado via PicoContainer.
    private final Trello trello;

 
    private String metodo, servico;


    @Given("um {string} para o servico {string}")
    public void um_request_para_o_servico(String metodo, String servico) {
        this.metodo = metodo;
        this.servico = servico;
    }

    @When("executo o servico")
    public void executo_o_servico() {
        assured.contentType(ContentType.JSON).when().baseUri(propriedade("trello.url")).basePath(servico);
    }

    @And("passo um ID")
    public void passo_um_ID() {
        assured.pathParam("id", trello.getCurrentId());
    }

    @Then("obtenho um HTTP status {int}")
    public void obtenho_um_HTTP_status(int httpStatus) {
        assured.request(metodo).then().statusCode(httpStatus);
    }

    @Then("obtenho um ID")
    public void um_ID() {
        trello.setCurrentId(assured.request(metodo).then().extract().jsonPath().get("id"));
    }

}