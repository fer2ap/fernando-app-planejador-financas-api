package com.fernando.fernando_app_planejador_financas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PlanjejadorFinancasApplication {

  public static void main(String[] args) {
    SpringApplication.run(PlanjejadorFinancasApplication.class, args);
  }

}