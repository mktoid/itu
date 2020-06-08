package io.github.mktoid.itu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PassportNotUniqueAdvice {
    @ResponseBody
    @ExceptionHandler(PassportNotUniqueException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String passportNotUniqueHandler (PassportNotUniqueException ex) {
        return ex.getMessage();
    }
}

