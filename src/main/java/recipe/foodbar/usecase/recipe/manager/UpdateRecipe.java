package recipe.foodbar.usecase.recipe.manager;

import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.usecase.recipe.exception.RecipeValidationException;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.recipe.validator.RecipeValidator;
import recipe.foodbar.usecase.user_example.port.IdGenerator;

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
                .author(recipe.getAuthor())
                .instructions(recipe.getInstructions())
                .cuisineId(recipe.getCuisineId())
                .portionSize(recipe.getPortionSize())
                .dietaryRestrictions(recipe.getDietaryRestrictions())
                .dateCreated(recipe.getDateCreated())
                .ingredients(recipe.getIngredients())
                .reviews(recipe.getReviews())
                .createRecipe();

        return repository.create(recipeToSave);
    }
}
