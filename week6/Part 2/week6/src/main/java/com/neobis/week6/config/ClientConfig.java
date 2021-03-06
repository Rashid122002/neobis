package com.neobis.week6.config;

import com.neobis.week6.entity.Client;
import com.neobis.week6.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository) {
        return args -> {
            Client alex = new Client(
                    "Alex",
                    "King",
                    "089809797457",
                    "jdfkhkghdsfjhgkdhs"
            );
            Client adilet = new Client(
                    "Adilet",
                    "Kuttubaev",
                    "98008583458",
                    "jhlgkdgfjhkdasgfkhjgf"
            );
            repository.saveAll(List.of(alex, adilet));
        };
    }
}
