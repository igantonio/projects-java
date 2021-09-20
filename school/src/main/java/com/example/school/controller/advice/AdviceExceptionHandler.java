package com.example.school.controller.advice;

import com.example.school.exception.AlreadyResourceRegisterException;
import com.example.school.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@ControllerAdvice
@Slf4j
public class AdviceExceptionHandler {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    @ExceptionHandler(AlreadyResourceRegisterException.class)
    public ResponseEntity<StandardError> alreadyResourceRegisterException(final AlreadyResourceRegisterException e,
                                                               final HttpServletRequest httpRequest){
        log.error("c={}, m={}, message={}", "AdviceExceptionHandler", "alreadyResourceRegisterException", e.getMessage());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .body(newStandardError(
                        status,
                        "Recurso já cadastrado",
                        e,
                        httpRequest));

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(final EntityNotFoundException e,
                                                                          final HttpServletRequest httpRequest){
        log.error("c={}, m={}, message={}", "AdviceExceptionHandler", "entityNotFoundException", e.getMessage());
        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity
                .status(status)
                .body(newStandardError(
                        status,
                        "Recurso não cadastrado",
                        e,
                        httpRequest));

    }

    private StandardError newStandardError(HttpStatus status, String titleError, RuntimeException e, HttpServletRequest request){
        return new StandardError(
                formatter.format(System.currentTimeMillis()),
                status.value(),
                titleError,
                e.getMessage(),
                request.getRequestURI());
    }

}
