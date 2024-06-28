package com.rcarrier.personalwebsite.portfolio.config;

import com.rcarrier.personalwebsite.portfolio.domain.Item;
import com.rcarrier.personalwebsite.portfolio.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // SpringBoot will run ALL CommandLineRunner beans once the application context is loaded
    // This runner will request a copy of the ItemRepository
    // Using it, it will create two entities and store them
    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepository) {

        return args -> {
            log.info("Preloading " + itemRepository.save(new Item("Bilbo Baggins", "burglar")));
            log.info("Preloading " + itemRepository.save(new Item("Frodo Baggins", "thief")));
        };
    }
}
