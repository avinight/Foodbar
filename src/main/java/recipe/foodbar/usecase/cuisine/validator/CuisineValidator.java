package recipe.foodbar.usecase.cuisine.validator;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.usecase.cuisine.exception.CuisineValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;


public class CuisineValidator {

    public static void validateCuisineRecipe(final Cuisine cuisine) {
        if (cuisine == null) throw new CuisineValidationException("Cuisine should not be null.");
        if (isBlank(cuisine.getName())) throw new CuisineValidationException("Name should not be null.");
    }
}
