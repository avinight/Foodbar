package recipe.foodbar.usecase.recipe.manager;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.usecase.recipe.exception.RecipeAlreadyExistsException;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.recipe.validator.RecipeValidator;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class CreateRecipe {
    private final RecipeRepository repository;
    private final IdGenerator idGenerator;

    public CreateRecipe(final RecipeRepository repository, final IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Recipe create(final Recipe recipe) throws RecipeAlreadyExistsException {
        RecipeValidator.validateCreateRecipe(recipe);
        if (repository.findById(recipe.getId()).isPresent()) {
            throw new RecipeAlreadyExistsException("Recipe already exists");
        }
        Recipe recipeToSave = Recipe.builder()
                .id(idGenerator.generate())
                .title(recipe.getTitle())
                .author(recipe.getAuthor())
                .instructions(recipe.getInstructions())
                .cuisine(recipe.getCuisine())
                .portionSize(recipe.getPortionSize())
                .dietaryRestrictions(recipe.getDietaryRestrictions())
                .dateCreated(recipe.getDateCreated())
                .build();


        return repository.create(recipeToSave);
    }
}
