package br.com.ivone.integracao.trello;

import static br.com.ivone.integracao.trello.servicos.Propriedades.propriedade;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.http.ContentType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/features")
public class RunCucumberTest {

    @AfterClass
    public static void teardown() {
       // Exclui todos os boards do Trello.
       getQuadros().parallelStream().forEach(RunCucumberTest::deletarQuadro);
    }

    private static List<String> getQuadros() {
       return given()
                 .contentType(ContentType.JSON)
                 .queryParam("key", propriedade("trello.key"))
                 .queryParam("token", propriedade("trello.token"))
                 .pathParam("user", propriedade("trello.user"))
              .get(propriedade("trello.url") + "1/members/{user}/boards")
              .body().jsonPath().getList("id", String.class);
    }

    private static void deletarQuadro(String id) {
       given()
          .contentType(ContentType.JSON)
          .queryParam("key", propriedade("trello.key"))
          .queryParam("token", propriedade("trello.token"))
          .pathParam("idBoard", id)
       .delete(propriedade("trello.url") + "1/boards/{idBoard}");
    }

}