package br.com.ivone.integracao.trello.quadros;

import br.com.ivone.integracao.trello.injecao.RestAssured;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtualizarCartaoTest {

    // Injetado via PicoContainer.
    private final RestAssured assured;

    @And("as informacoes do cartao")
    public void as_informacoes_do_cartao() {
        assured.queryParam("name", "Processo Seletivo")
               .queryParam("desc", "Contratação Sensedia + Ivone!");
    }

}