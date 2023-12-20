package foodbar.usecase.recipe.manager;

import foodbar.entities.Recipe;
import foodbar.usecase.commonport.IdGenerator;
import foodbar.usecase.recipe.validator.RecipeValidator;
import recipe.foodbar.entities.Cuisine;
import foodbar.usecase.recipe.port.RecipeRepository;
import foodbar.usecase.user.port.UserRepository;

import java.util.Date;

public class CreateRecipeInteractor implements CreateRecipeInputBoundary {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;
    private final CreateRecipeOutputBoundary presenter;

    /**
     * Constructor for saveRecipeInteractor object which takes in both the presenterInterface and the
     * repository interface object
     *
     * @param userRepository the UserRepositoryInterface to access the data in the outermost layer
     * @param recipeRepository the RecipeRepositoryInterface to access the data in the outermost layer
     * @param idGenerator id generator which will generate a random ID for the recipe
     * @param presenter the output boundary interface implemented by the presenter
     */
    public CreateRecipeInteractor(RecipeRepository recipeRepository, UserRepository userRepository, IdGenerator idGenerator, CreateRecipeOutputBoundary presenter) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
        this.presenter = presenter;
    }

    /**
     * Creates a recipe, validates that it correctly formatted, and then saves it to the repo
     * @param input input data from the controller
     *
     * @return returns string message from presenter
     */
    @Override
    public String create(RecipeInputData input) {
        if (userRepository.findById(input.getUserId()).isPresent()) {
            Recipe recipeToSave = Recipe.builder()
                    .id(idGenerator.generate())
                    .title(input.getTitle())
                    .user(userRepository.findById(input.getUserId()).get())
                    .instructions(input.getInstructions())
                    .cuisine(Cuisine.builder().id(idGenerator.generate()).name(input.getCuisine()).build())
                    .portionSize(input.getPortionSize())
                    .ingredients(input.getIngredients())
                    .dietaryRestrictions(input.getDietaryRestrictions())
                    .dateCreated(new Date())
                    .build();

            RecipeValidator.validateCreateRecipe(recipeToSave);

            recipeRepository.create(recipeToSave);

            // need to return the ID of the recipe object that was created
            String recipeID = recipeToSave.getId();
            System.out.println(recipeID);
            return presenter.present("Recipe saved successfully");
        }
        return presenter.present("Recipe couldn't be created");
    }
}
