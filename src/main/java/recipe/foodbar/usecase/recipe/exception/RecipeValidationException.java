package recipe.foodbar.usecase.recipe.exception;

public class RecipeValidationException extends RuntimeException {
    /**
     * Exception for error handling when creating a recipe
     * @param message the error message to be returned
     */
    public RecipeValidationException(final String message) {
        super(message);
    }
}
