package com.postech.auramsclient;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import({TestcontainersConfiguration.class})
@SpringBootTest
class AuraMsClientApplicationTests {

    @Test
    void contextLoads() {
        /*
         * Este é um teste padrão do Spring Boot que verifica se o contexto da aplicação
         * é carregado corretamente. O metodo está vazio intencionalmente, pois o próprio
         * Spring Boot gerencia a validação do carregamento dos beans e componentes.
         * Se houver algum problema na inicialização do contexto, o teste falhará automaticamente.
         */
    }

}
