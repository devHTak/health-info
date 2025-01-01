package com.example.kbhc.framework.input.api.advice;

import com.example.kbhc.framework.dto.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HealthControllerAdvice {

    private final Logger log = LoggerFactory.getLogger(HealthControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseInfo<String> exceptionHandler(Exception e) {
        log.error("Exception: {}", e.getMessage());
        return new ResponseInfo<String>(HttpStatus.INTERNAL_SERVER_ERROR.value()
                , "INTERNAL SERVER ERROR"
                , "INTERNAL SERVER ERROR");
    }

}
