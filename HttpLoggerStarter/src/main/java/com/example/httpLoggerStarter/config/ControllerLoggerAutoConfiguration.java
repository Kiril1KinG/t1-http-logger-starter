package com.example.httpLoggerStarter.config;

import com.example.httpLoggerStarter.aspect.ControllerLogAspect;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ControllerLoggerProperties.class)
@RequiredArgsConstructor
public class ControllerLoggerAutoConfiguration {

    private final ControllerLoggerProperties properties;

    @Bean
    public ControllerLogAspect getLogAspect() {
        if (properties.isEnable()) {
            return new ControllerLogAspect();
        }
        return null;
    }

}
