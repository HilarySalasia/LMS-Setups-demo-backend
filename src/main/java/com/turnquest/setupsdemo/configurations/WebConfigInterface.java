package com.turnquest.setupsdemo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * This interface provides configuration for web-related settings in a Spring Boot application.
 * It is annotated with @Configuration to indicate that it provides @Bean definitions.
 */
@Configuration
public interface WebConfigInterface {

    /**
     * This method is expected to provide a ViewResolver bean.
     * A ViewResolver is responsible for mapping view names to actual view objects in Spring MVC.
     *
     * @return a ViewResolver object
     */
    @Bean
    ViewResolver getViewResolver();

    /**
     * This method is used to configure default servlet handling.
     * The DefaultServletHandlerConfigurer is a callback interface to be implemented by @{@link org.springframework.web.servlet.config.annotation.WebMvcConfigurer} types that wish to configure the HandlerMapping used to serve static resources such as images, css files and others through Spring MVC's DispathcherServlet.
     *
     * @param configurer a DefaultServletHandlerConfigurer object
     */
    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);

    /**
     * This method is used to add resource handlers for serving static resources.
     * It maps "/swagger-ui.html**" and "/webjars/**" URL paths to their corresponding locations in the classpath.
     *
     * @param registry a ResourceHandlerRegistry object
     */
    default void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html**")
                .addResourceLocations("classpath:/resources/swagger-ui.html");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/resources/webjars/");
    }
}