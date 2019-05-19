package com.frankmoley.starter.dse;

import java.io.IOException;

import com.datastax.dse.driver.api.core.DseSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * The base configuration for a DataStax Constellation based Spring Boot Starter
 * @author Frank Moley
 */
@Configuration
@EnableConfigurationProperties(DseConfigurationProperties.class)
public class SpringBootStarterDseConfiguration {

    private final DseConfigurationProperties properties;

    @Autowired
    public SpringBootStarterDseConfiguration(DseConfigurationProperties properties){
        super();
        this.properties = properties;
    }
    @Bean
    public DseSession dseSession(){
        try{
            ClassPathResource resource = new ClassPathResource(properties.getCredentialsFile());
            String filepath = resource.getFile().getAbsolutePath();
            return DseSession.builder().forClusterConfig(filepath).build();
        } catch(IOException e){
            throw new RuntimeException("error capturing credential file");
        }
    }

}
