package recipe.foodbar.usecase.user_example.exception;

public class UserValidationException extends RuntimeException {
    public UserValidationException(final String message) {
        super(message);
    }
}
