package com.cydeo.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component//runner class
public class QueryDemo implements CommandLineRunner {
    private final AccountRepository accountRepository;

    public QueryDemo(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public void run(String... args) throws Exception {
     //   System.out.println(" findByCountry: " +  AccountRepository.findByCountry("United States"));

    }
}