package recipe.foodbar.usecase.recipe.exception;

public class RecipeValidationException extends RuntimeException{
    public RecipeValidationException(final String message) {
        super(message);
    }
}
