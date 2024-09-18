package br.com.jamesmayke.vacancy_management_system.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    
    private final MessageSource messageSource;

    public ExceptionHandlerController(MessageSource message) {
        this.messageSource = message;
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageErrorResponse>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        
        List<MessageErrorResponse> responseErrors = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach( err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());

            MessageErrorResponse errorResponse = new MessageErrorResponse(message, err.getField());
            
            responseErrors.add(errorResponse);
        });

        return new ResponseEntity<>(responseErrors, HttpStatus.valueOf(400));
    }
}
