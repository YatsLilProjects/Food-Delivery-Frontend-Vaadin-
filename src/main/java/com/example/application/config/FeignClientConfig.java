package com.example.application.config;

import com.example.application.exception.RetrieveMessageErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Bean
    public ErrorDecoder errorDecoder()
    {
        return new RetrieveMessageErrorDecoder();
    }

}
