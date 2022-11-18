package recipe.foodbar.usecase.user_example.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(final String email) {
        super(email);
    }
}
