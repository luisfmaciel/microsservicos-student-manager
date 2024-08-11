package br.edu.infnet.disciplinaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DisciplinaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisciplinaServiceApplication.class, args);
    }

}
