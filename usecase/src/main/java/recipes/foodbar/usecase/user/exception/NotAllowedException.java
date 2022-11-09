package recipes.foodbar.usecase.user.exception;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException(final String message) {
        super(message);
    }
}
