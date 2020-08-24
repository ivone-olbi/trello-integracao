## Trello + Sensedia = _Ivone Feliz!!! Muito Obrigada pela oportunidade!_

### 1.0 Instala��o 

#### 1.1 Ferramentas:
Tecnologias necess�rias/usadas:
**_Java 11 - Cucumber, JUnit, Maven, PicoContainer, Postman, Project Lombok, REST Assured._**

#### 1.2 Postman:
Usado para testes de integra��o e documenta��o.
Sua estrutura acompanha a documenta��o da API do Trello.

#### 1.3 Project Lombok:
Para instala��o do plugin do Project Lombok na usa IDE preferida utilize o link: https://projectlombok.org/.
Na op��o "Install" voc� pode encontrar todas as IDEs suportadas.

#### 1.4 Configura��o
Para configurar um usu�rio preencha a "key" e o "token" no arquivo "application.properties".

### 2.0 Arquitetura

#### 2.1 Organiza��o do REST Assured:
Para se adequar as features do Cucumber, foi realizado a seguinte organiza��o:

_Foi separado Rest Assured **DE**:_

```java
given()
   .queryParam("key", propriedade("trello.key"))
   .queryParam("token", propriedade("trello.token"))
   .queryParam("name", "Sensedia2")
   .contentType(ContentType.JSON)
.when()
   .post(propriedade("trello.url") + "1/boards/")
.then()
   .statusCode(HttpStatus.SC_OK)
   .contentType(ContentType.JSON);
```

_**PARA** uma estrutura separada em m�dotos:_

```java
@Given("um token {string}")
public void um_token(String token) {
    dado.queryParam("token", getValorOuPropriedade(token, "trello.token"));
}
```
    
#### Ap�ndice
* _Documenta��o da API do Trello - https://developer.atlassian.com/cloud/trello/rest/api-group-actions/_