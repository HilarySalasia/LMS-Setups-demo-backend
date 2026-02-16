package com.turnquest.setupsdemo.configurations;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * This is a component class named ErrorManager.
 * It is responsible for raising errors with specific error codes and messages.
 * The messages are internationalized and can be parameterized.
 *
 * @Component makes this class as a Bean in Spring Application Context.
 */
@Component
public class ErrorManager {

    /**
     * MessageSource is an interface used in Spring for resolving messages, with support for parameterization and internationalization.
     */
    private final MessageSource messageSource;

    /**
     * Constructor for the ErrorManager class.
     * It initializes the MessageSource.
     *
     * @param messageSource the MessageSource to use for resolving messages
     */
    public ErrorManager(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * This method is used to raise an error with a specific error code.
     * It retrieves the error message corresponding to the error code from the MessageSource, and throws an exception with the error code and message.
     *
     * @param errorCode the error code
     * @param locale the locale to use for message resolution
     * @throws Exception with the error code and message
     */
    public void raiseError(int errorCode, Locale locale) throws Exception {
        String message = messageSource.getMessage("error." + errorCode, null, locale);
        throw new Exception("Error Code: " + errorCode + ", Message: " + message);
    }

    /**
     * This method is used to raise an error with a specific error code and arguments.
     * It retrieves the error message corresponding to the error code from the MessageSource, and throws an exception with the error code and message.
     * The error message can be parameterized with the provided arguments.
     *
     * @param errorCode the error code
     * @param locale the locale to use for message resolution
     * @param args the arguments to use for message parameterization
     * @throws Exception with the error code and message
     */
    public void raiseError(int errorCode, Locale locale, Object... args) throws Exception {
        String message = messageSource.getMessage("error." + errorCode, args, locale);
        throw new Exception("Error Code: " + errorCode + ", Message: " + message);
    }
}