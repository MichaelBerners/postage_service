package ru.berners.postage_service.domain.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.berners.postage_service.domain.exception.PostOfficeNotFound;
import ru.berners.postage_service.domain.exception.PostageMovementException;
import ru.berners.postage_service.domain.exception.PostageNotFoundException;

public class PostageControllerAdvice {
    @ExceptionHandler(PostageMovementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(PostageMovementException e) {
        return "the transfer could not be registered";
    }

    @ExceptionHandler(PostageNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(PostageNotFoundException e) {
        return "postage not found";
    }

    @ExceptionHandler(PostOfficeNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(PostOfficeNotFound e) {
        return "post office not found";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(MethodArgumentNotValidException e) {
        return "Not valid";
    }

}
