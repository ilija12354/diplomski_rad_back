package com.diplomski.obavestavanje.nastavnika.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    /**
     * @TODO probaj da li mogu sve beanovi da se stave ovde
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
