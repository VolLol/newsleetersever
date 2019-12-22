package net.sender.newsleetersever.enterypoints.http.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestHttpException extends RuntimeException {
    public BadRequestHttpException(String message) {
        super(message);
    }
    public BadRequestHttpException (Throwable cause){
        super(cause);
    }

    public BadRequestHttpException(String message, Throwable cause){
        super(message,cause);
    }
}
