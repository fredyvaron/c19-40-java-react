package com.example.ProVision_ERP.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ProVision_ERP.Model.Rol;
import com.example.ProVision_ERP.Repository.RolRepository;

@Configuration
public class DataInitializer {
    
    @Autowired
    private RolRepository rolRepository;

    @Bean
    public CommandLineRunner initializeRoles() {
        return args -> {
            if(rolRepository.findAll().isEmpty()) {
                rolRepository.save(new Rol(null, "USER", "USERS"));
                rolRepository.save(new Rol(null, "ADMIN", "ADMINS"));
            }
        };
    }
}
