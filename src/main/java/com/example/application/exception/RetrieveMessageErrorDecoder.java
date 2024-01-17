package com.example.application.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class RetrieveMessageErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        com.example.application.dto.CustomerResponse message = null;
        try (InputStream bodyIs = response.body()
                .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, com.example.application.dto.CustomerResponse.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        return new AuthenticationException(message);
    }
}


