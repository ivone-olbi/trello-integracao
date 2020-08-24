package br.com.ivone.integracao.trello.servicos;

import java.util.Properties;

import lombok.SneakyThrows;

/**
 * <p>Responsavel pela leitura do arquivo {@linkplain /application.properties}.
 */
public final class Propriedades {

    private static final Properties PROPERTIES = inicializarPropriedades();


    /** Use {@code "DEFAULT"} para ler do arquivo de propriedades. */
    private static final String DEFAULT = "DEFAULT";


    /**
     * <p>Retorna o valor da propriedade.</p>
     *
     * @param nome propriedade
     */
    public static String propriedade(String nome) {
        return PROPERTIES.getProperty(nome);
    }
    
    /**
     * <p>Recupera o valor por usuario passando {@code "DEFAULT"} e o nome da propriedade OU simplemente retorna o valor informado.</p>
     *
     * @param valor {@code "DEFAULT"} ou valor
     * @param propriedade nome da propriedade informada
     *
     * @return {@code valor} informado ou "valor" da {@code propriedade}
     */
    public static String  valorOuDefaultPropriedade(String valor, String propriedade) {
        return DEFAULT.equals(valor) ? propriedade(propriedade) : valor;
    }


    // Le o arquivo de propriedades e carrega a variavel {@code PROPERTIES}.
    @SneakyThrows
    private static Properties inicializarPropriedades() {

        var properties = new Properties();
        properties.load(Propriedades.class.getResourceAsStream("/application.properties"));

        return properties;

    }

}