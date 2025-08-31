package com.lab.quick.start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuickStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickStartApplication.class, args);
	}


    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("cmd app is running");
        };
    }

}
