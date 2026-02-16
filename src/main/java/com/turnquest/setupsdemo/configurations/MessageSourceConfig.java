package com.turnquest.setupsdemo.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * This is a configuration class for the MessageSource bean in a Spring Boot application.
 * The MessageSource is an interface used in Spring for resolving messages, with support for parameterization and internationalization.
 * It is part of Spring’s localization support and is used whenever you need to obtain a localized message.
 *
 * @Configuration indicates that this class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
 */
@Configuration
public class MessageSourceConfig {

    /**
     * This method is used to create and configure a MessageSource bean.
     * The MessageSource is an interface used in Spring for resolving messages, with support for parameterization and internationalization.
     * The ReloadableResourceBundleMessageSource is a concrete implementation that is capable of reloading messages without restarting the application.
     * It uses the basename "classpath:messages" for locating message resources, indicating that messages are located in the classpath.
     * It sets the default encoding to "UTF-8".
     *
     * @return a configured MessageSource bean
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}