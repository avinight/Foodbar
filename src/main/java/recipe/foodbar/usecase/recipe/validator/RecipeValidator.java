package recipe.foodbar.usecase.recipe.validator;

import lombok.NoArgsConstructor;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.usecase.recipe.exception.RecipeValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;


@NoArgsConstructor
public class RecipeValidator {

    /**
     * validates recipe by ensuring the data isn't nonsensical.
     * -recipe object cannot be null
     * -title cannot be blank
     * -portion size cannot be 0 or lower
     * -instructions should not be empty
     * -cuisine should not be null
     * @param recipe recipe to be validated
     */
    public static void validateCreateRecipe(final Recipe recipe) {
        if (recipe == null) throw new RecipeValidationException("Recipe should not be null.");
        if (isBlank(recipe.getTitle())) throw new RecipeValidationException("Title should not be null.");
//        if (isBlank(recipe.getAuthor().getId())) throw new RecipeValidationException("Author should not be blank.");
        if (recipe.getPortionSize() <= 0)
            throw new RecipeValidationException("Portion Size should be a positive value.");
        if (recipe.getInstructions().size() == 0)
            throw new RecipeValidationException("There should be at least one instruction.");
        if (recipe.getCuisine() == null) throw new RecipeValidationException("Cuisine should not be null.");
    }
}
