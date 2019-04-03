package ru.sbt.lab2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}

/**
 * Предоставяем веб-странице доступ к ресурсам другого домена,
 * указывая CORS заголовок для снятия блокировки, иначе Err:
 * "отсутствует заголовок CORS «Access-Control-Allow-Origin»"
 *
 * Подробнее/примеры:
 * 1. https://www.baeldung.com/spring-cors
 * 2. http://spring-projects.ru/guides/rest-service-cors/
 */
