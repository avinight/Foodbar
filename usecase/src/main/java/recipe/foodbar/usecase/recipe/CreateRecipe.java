package recipe.foodbar.usecase.recipe;

import recipes.foodbar.entities.Recipe;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

public class CreateRecipe {
    private final RecipeRepository repository;

    public CreateRecipe(final RecipeRepository repository) {
        this.repository = repository;
    }

    public Recipe create(final Recipe recipe) {
        Recipe recipeToSave = Recipe.builder()
                .title(recipe.getTitle())
                .author(recipe.getAuthor())
                .portionSize(recipe.getPortionSize())
                .dietaryRestrictions(recipe.getDietaryRestrictions())
                .dateCreated(recipe.getDateCreated())
                .build();

        return repository.create(recipeToSave);
    }
}
