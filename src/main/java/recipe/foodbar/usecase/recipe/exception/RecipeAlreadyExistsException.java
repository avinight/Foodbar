package recipe.foodbar.usecase.recipe.exception;

public class RecipeAlreadyExistsException extends Exception {
    public RecipeAlreadyExistsException(final String message) { super(message);}
}
