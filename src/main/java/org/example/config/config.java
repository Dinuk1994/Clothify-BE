package org.example.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class config {
    @Bean
    public ModelMapper setup(){
        return new ModelMapper();
    }
}
