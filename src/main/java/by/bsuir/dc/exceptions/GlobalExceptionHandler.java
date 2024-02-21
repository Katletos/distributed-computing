package by.bsuir.dc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler({EntityAlreadyExistsException.class})
   public ResponseEntity<Object> handleEntityAlreadyExistsException(EntityAlreadyExistsException exception) {
       return ResponseEntity
               .status(HttpStatus.BAD_REQUEST)
               .body(exception.getMessage());
   }

   @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
       return ResponseEntity
               .status(HttpStatus.NOT_FOUND)
               .body(exception.getMessage());
   }
}
