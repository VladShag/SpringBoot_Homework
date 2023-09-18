package ru.vladshag.springboot_homework.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vladshag.springboot_homework.profiles.DevProfile;
import ru.vladshag.springboot_homework.profiles.ProductionProfile;
import ru.vladshag.springboot_homework.profiles.SystemProfile;

@Configuration
public class MyAppConfig {
    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }
    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

}
