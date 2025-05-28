package br.com.uj.livrariaapi;

import br.com.uj.livrariaapi.model.entities.UsuarioModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LivrariaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivrariaApiApplication.class, args);
    }

}
