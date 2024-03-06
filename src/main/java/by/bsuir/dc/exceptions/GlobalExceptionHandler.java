package by.bsuir.dc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ErrorMessage handleEntityAlreadyExistsException(EntityAlreadyExistsException exception) {
        return new ErrorMessage(
                exception.getMessage(),
                40000L
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorMessage handleEntityNotFoundException(EntityNotFoundException exception) {
        return new ErrorMessage(
                exception.getMessage(),
                40400L
        );
    }
}
