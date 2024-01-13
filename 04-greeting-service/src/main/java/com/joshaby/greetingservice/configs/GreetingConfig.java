package com.joshaby.greetingservice.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "greeting-service")
@Getter
@Setter
public class GreetingConfig {

    private String greeting;

    private String defaultValue;
}
