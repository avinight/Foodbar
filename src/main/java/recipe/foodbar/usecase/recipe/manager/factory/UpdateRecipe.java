package recipe.foodbar.usecase.recipe.manager.factory;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.usecase.recipe.exception.RecipeValidationException;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.recipe.validator.RecipeValidator;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class UpdateRecipe {
    private final RecipeRepository repository;
    private final IdGenerator idGenerator;

    public UpdateRecipe(final RecipeRepository repository, final IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Recipe update(final Recipe recipe) throws RecipeValidationException {
        RecipeValidator.validateCreateRecipe(recipe);
        Recipe recipeToSave = Recipe.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .user(recipe.getUser())
                .instructions(recipe.getInstructions())
                .cuisine(recipe.getCuisine())
                .portionSize(recipe.getPortionSize())
                .dietaryRestrictions(recipe.getDietaryRestrictions())
                .dateCreated(recipe.getDateCreated())
                .ingredients(recipe.getIngredients())
                .reviews(recipe.getReviews())
                .build();

        return repository.create(recipeToSave);
    }
}
