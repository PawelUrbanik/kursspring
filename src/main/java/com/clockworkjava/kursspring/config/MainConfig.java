package com.clockworkjava.kursspring.config;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.repository.DBKnightRepository;
import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class MainConfig {

    @Bean(name = "inMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo()
    {
        InMemoryRepository repository = new InMemoryRepository();
        return repository;
    }

    @Bean(name = "DBKnightRepository")
    @Profile("prod")
    @Primary
    public KnightRepository createDBRepo()
    {
        DBKnightRepository repository = new DBKnightRepository();
        return repository;
    }



}
