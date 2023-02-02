package com.luciuswong.renting.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Component
@Data
@PropertySource("classpath:configuration.properties")
@ConfigurationProperties(prefix="renting")
@Validated
public class CredentialsConfig {
    private Map<String, String> user;
    private Map<String, String> admin;
}
