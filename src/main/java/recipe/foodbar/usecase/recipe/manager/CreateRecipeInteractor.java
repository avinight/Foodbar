package recipe.foodbar.usecase.recipe.manager;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.usecase.recipe.RecipeInputData;
import recipe.foodbar.usecase.recipe.exception.RecipeAlreadyExistsException;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.recipe.validator.RecipeValidator;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class CreateRecipeInteractor implements CreateRecipeInputBoundary{
    private final RecipeRepository repository;
    private final IdGenerator idGenerator;
    private final CreateRecipeOutputBoundary outputBoundary;

    public CreateRecipeInteractor(RecipeRepository repository, IdGenerator idGenerator, CreateRecipeOutputBoundary outputBoundary) {
        this.repository = repository;
        this.idGenerator = idGenerator;
        this.outputBoundary = outputBoundary;
    }

//    public Recipe create(final Recipe recipe) throws RecipeAlreadyExistsException {
//        RecipeValidator.validateCreateRecipe(recipe);
//        if (repository.findById(recipe.getId()).isPresent()) {
//            throw new RecipeAlreadyExistsException("Recipe already exists");
//        }
//        Recipe recipeToSave = Recipe.builder()
//                .id(idGenerator.generate())
//                .title(recipe.getTitle())
//                .author(recipe.getAuthor())
//                .instructions(recipe.getInstructions())
//                .cuisine(recipe.getCuisine())
//                .portionSize(recipe.getPortionSize())
//                .dietaryRestrictions(recipe.getDietaryRestrictions())
//                .dateCreated(recipe.getDateCreated())
//                .createRecipe();
//
//
//        return repository.create(recipeToSave);
//    }

    @Override
    public String create(RecipeInputData input) {
        Recipe recipeToSave = Recipe.builder()
                .id(idGenerator.generate())
                .title(input.getTitle())
                .author(input.getAuthor())
                .instructions(input.getInstructions())
                .cuisine(input.getCuisine())
                .portionSize(input.getPortionSize())
                .dietaryRestrictions(input.getDietaryRestrictions())
                .dateCreated(input.getDateCreated())
                .createRecipe();

        RecipeValidator.validateCreateRecipe(recipeToSave);

        repository.create(recipeToSave);

        return "Alrighty mayte, it's done!";
    }
}
