package com.example.httpLoggerStarter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.example.http-logger")
@Getter
@Setter
public class ControllerLoggerProperties {

    private boolean enable;
}
