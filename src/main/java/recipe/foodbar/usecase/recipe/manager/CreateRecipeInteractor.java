package recipe.foodbar.usecase.recipe.manager;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.usecase.commonport.IdGenerator;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.recipe.validator.RecipeValidator;
import recipe.foodbar.usecase.user.port.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateRecipeInteractor implements CreateRecipeInputBoundary {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;
    private final CreateRecipeOutputBoundary presenter;

    public CreateRecipeInteractor(RecipeRepository recipeRepository, UserRepository userRepository, IdGenerator idGenerator, CreateRecipeOutputBoundary presenter) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
        this.presenter = presenter;
    }

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
