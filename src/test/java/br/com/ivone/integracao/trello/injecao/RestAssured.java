package br.com.ivone.integracao.trello.injecao;

import io.restassured.specification.RequestSpecification;
import lombok.experimental.Delegate;

public class RestAssured {

    @Delegate
    private RequestSpecification requestSpecification = io.restassured.RestAssured.given();

}