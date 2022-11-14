package recipes.foodbar.usecase.user.validator;

import recipes.foodbar.entities.Recipe;
import recipes.foodbar.usecase.user.exception.RecipeValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;


public class RecipeValidator {

    public static void validateCreateRecipe(final Recipe recipe) {
        if (recipe == null) throw new RecipeValidationException("Recipe should not be null.");
        if (isBlank(recipe.getTitle())) throw new RecipeValidationException("Title should not be null.");
        if (isBlank(recipe.getAuthor().getId())) throw new RecipeValidationException("Author should not be blank.");
        if (recipe.getPortionSize() <= 0) throw new RecipeValidationException("Portion Size should be a positive value.");
        if (recipe.getInstructions().length == 0) throw new RecipeValidationException("There should be at least one instruction.");
        if (isBlank(recipe.getCuisine())) throw new RecipeValidationException("Cuisine should not be null.");
    }

    private RecipeValidator() {

    }
}
