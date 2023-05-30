package edu.group5.petshelterbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@EnableScheduling
public class PetShelterBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetShelterBotApplication.class, args);
    }

}
