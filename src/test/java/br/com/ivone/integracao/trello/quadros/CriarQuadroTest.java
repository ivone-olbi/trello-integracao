package br.com.ivone.integracao.trello.quadros;

import br.com.ivone.integracao.trello.comum.SegurancaTest;
import br.com.ivone.integracao.trello.comum.ServicoTest;
import br.com.ivone.integracao.trello.injecao.RestAssured;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;

/**
 * <p>Create a Board.</p>
 *
 * <i>../features/quadros/CriarQuadroTest.feature</i>
 *
 * @see SegurancaTest
 * @see ServicoTest
 */
@RequiredArgsConstructor
public class CriarQuadroTest {

    // Injetado via PicoContainer.
    private final RestAssured assured;

    @Given("o nome do quadro {string}")
    public void o_nome_do_quadro(String nomeQuadro) {
        assured.queryParam("name", nomeQuadro);
    }

}