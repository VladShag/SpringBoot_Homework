package ru.vladshag.springboot_homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.vladshag.springboot_homework.handlers.UserResolver;
import ru.vladshag.springboot_homework.repository.UserRepository;
import ru.vladshag.springboot_homework.service.AuthorizationService;

import java.util.List;

@Configuration
public class MyAppConfig implements WebMvcConfigurer {

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolverList){
        argumentResolverList.add(new UserResolver());
    }
    @Bean
    public UserRepository repository() {
        return new UserRepository();
    }
    @Bean
    public AuthorizationService service() {
        return new AuthorizationService();
    }

}
