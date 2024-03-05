package by.bsuir.dc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler({EntityAlreadyExistsException.class})
   public ResponseEntity<ErrorMessage> handleEntityAlreadyExistsException(EntityAlreadyExistsException exception) {
       var message = new ErrorMessage(
               exception.getMessage(),
               40000L
               );
       return ResponseEntity
               .status(HttpStatus.BAD_REQUEST)
               .body(message);
   }

   @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException exception) {
       var message = new ErrorMessage(
               exception.getMessage(),
               40400L
       );
       return ResponseEntity
               .status(HttpStatus.NOT_FOUND)
               .body(message);
   }
}
