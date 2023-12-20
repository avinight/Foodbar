package foodbar.usecase.cuisine.exception;

public class CuisineValidationException extends RuntimeException {
    public CuisineValidationException(final String message) {
        super(message);
    }
}
