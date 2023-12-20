package foodbar.usecase.review.exception;

public class CharLimitException extends RuntimeException {
    public CharLimitException(final String message) {
        super(message);
    }
}
