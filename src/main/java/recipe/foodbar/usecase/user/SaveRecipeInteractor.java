package recipe.foodbar.usecase.user_example;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.user.port.UserCreatorInputBoundary;
import recipe.foodbar.usecase.user_example.SaveRecipeOutputBoundary;
import recipe.foodbar.usecase.user.port.UserRepositoryInterface;

import java.util.Optional;

public class SaveRecipeInteractor implements SaveRecipeInputBoundary{

    private final SaveRecipeOutputBoundary presenterInterface;
    private final UserRepositoryInterface userRepo;
    private final RecipeRepository recipeRepo;

    /**
     * Constructor for saveRecipeInteractor object which takes in both the presenterInterface and the
     * repository interface object
     *
     * @param presenterInterface SaveRecipeOutputBoundary interface so that use case can call the presenter
     * @param userRepo the UserRepositoryInterface to access the data in the outermost layer
     */
    public SaveRecipeInteractor(SaveRecipeOutputBoundary presenterInterface, UserRepositoryInterface userRepo,
                                RecipeRepository recipeRepo){
        this.presenterInterface = presenterInterface;
        this.userRepo = userRepo;
        this.recipeRepo = recipeRepo;

    }

    /**
     * Abstract save recipe method implemented by the SaveRecipeInteractor
     *
     * @param inputDS the SaveRecipeData which contains the user that wants to save the recipe and the recipe object
     *                they want to save
     * @return The return type of the presenter interface i.e. string denoting success or failure of saving and
     * un-saving a recipe
     */
    @Override
    public String saveRecipe(SaveRecipeData inputDS) {
        String userID = inputDS.getUserSaver().getId();
        String recipeID = inputDS.getRecipeToBeSaved().getId();

        // TODO: findByID method to be added to UserRepo Interface and InMemoryUserRepo
//        Optional<User> saver = userRepo.findByID(userID);
        Optional<User> saver = userRepo.findByUsername(userID); // TODO: WRONG! method name to be updated
        Optional <Recipe> recipeToBeSaved= recipeRepo.findById(recipeID);

        if (saver.isPresent() && recipeToBeSaved.isPresent()) {
            saver.get().addRecipe(recipeToBeSaved.get());
            return presenterInterface.present("Recipe successfully saved");
        }
        return "";
        // TODO: should an exception be created to handle a logged
    }
}
