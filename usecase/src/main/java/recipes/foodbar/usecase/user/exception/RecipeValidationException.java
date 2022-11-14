package recipes.foodbar.usecase.user.exception;

public class RecipeValidationException extends RuntimeException{
    public RecipeValidationException(final String message) {
        super(message);
    }
}
