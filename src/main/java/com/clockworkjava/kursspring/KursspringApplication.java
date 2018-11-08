package com.clockworkjava.kursspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@ComponentScan("com.clockworkjava.component")
//@ImportResource("classpath:config\\spring-config.xml")
@PropertySource("classpath:knightRepository.properties")
@PropertySource("classpath:application.properties")
@EnableScheduling
public class KursspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(KursspringApplication.class, args);
	}
}
