package foodbar.usecase.review.exception;

public class ReviewValidationException extends RuntimeException {
    public ReviewValidationException(final String message) {
        super(message);
    }
}
