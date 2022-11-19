package recipe.foodbar.usecase.user_example.exception;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException(final String message) {
        super(message);
    }
}
