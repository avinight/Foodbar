package foodbar.usecase.cuisine.exception;

public class CuisineAlreadyExistsException extends RuntimeException {
    public CuisineAlreadyExistsException(final String message) {
        super(message);
    }
}
