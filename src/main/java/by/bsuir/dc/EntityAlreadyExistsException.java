package by.bsuir.dc;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
