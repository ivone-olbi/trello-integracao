package br.com.ivone.integracao.trello.comum;

import static br.com.ivone.integracao.trello.servicos.Propriedades.valorOuDefaultPropriedade;

import br.com.ivone.integracao.trello.injecao.RestAssured;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;

/**
 * <p>Responsavel pelos dados de {@code key} e {@code token} de todas as features.</p>
 *
 * <i>#PorUsuario</i>
 */
@RequiredArgsConstructor
public class SegurancaTest {

    // Injetado via PicoContainer.
    private final RestAssured assured;

    /**
     * <p>Passa a {@code key} atraves de "Query Parameter".</p>
     * <i>Cucubmer: And uma key "DEFAULT"</i>
     */
    @And("uma key {string}")
    public void uma_key(String key) {
        assured.queryParam("key", valorOuDefaultPropriedade(key, "trello.key"));
    }

    /**
     * <p>Passa o {@code token} atraves de "Query Parameter".</p>
     * <i>Cucubmer: And um token "DEFAULT"</i>
     */
    @Given("um token {string}")
    public void um_token(String token) {
        assured.queryParam("token", valorOuDefaultPropriedade(token, "trello.token"));
    }

}