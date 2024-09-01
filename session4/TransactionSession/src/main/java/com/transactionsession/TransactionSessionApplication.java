package com.transactionsession;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TransactionSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionSessionApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(JpaBaseInRun jpaBaseInRun) {
        return args -> jpaBaseInRun.sampleRun();
    }

}
