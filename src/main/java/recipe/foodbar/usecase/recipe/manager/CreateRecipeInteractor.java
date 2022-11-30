package recipe.foodbar.usecase.recipe.manager;

import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.recipe.validator.RecipeValidator;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class CreateRecipeInteractor implements CreateRecipeInputBoundary{
    private final RecipeRepository repository;
    private final IdGenerator idGenerator;
    private final CreateRecipeOutputBoundary presenter;

    public CreateRecipeInteractor(RecipeRepository repository, IdGenerator idGenerator, CreateRecipeOutputBoundary presenter) {
        this.repository = repository;
        this.idGenerator = idGenerator;
//        this.presenter = presenter1;
        this.presenter = presenter;
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

        // TODO: Assuming the validator above throws the appropriate exception, we can present a
        //  message of the recipe being successfully created through the presenter. I think that
        //  the exceptions thrown by the validator above in case of an invalid entry should also
        //  be passed out through the presenter attribute of this interactor since it's job is communicating
        //  with the UI. Confirm with Roney!!
        repository.create(recipeToSave);

        return presenter.present("Recipe successfully created and uploaded");
    }
}
