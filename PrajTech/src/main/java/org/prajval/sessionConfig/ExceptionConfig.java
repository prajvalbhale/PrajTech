package org.prajval.sessionConfig;

import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ExceptionConfig implements WebMvcConfigurer {

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties exceptionMappings = new Properties();
        exceptionMappings.put("org.springframework.security.web.session.SessionExpiredException", "session-expired");
        exceptionResolver.setExceptionMappings(exceptionMappings);
        exceptionResolvers.add(exceptionResolver);
    }
}