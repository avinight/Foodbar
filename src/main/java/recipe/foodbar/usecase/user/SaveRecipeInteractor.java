package recipe.foodbar.usecase.user;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.user.port.UserRepositoryInterface;

import java.util.Optional;

public class SaveRecipeInteractor implements SaveRecipeInputBoundary {

    private final SaveRecipeOutputBoundary presenterInterface;
    private final UserRepositoryInterface userRepo;
    private final RecipeRepository recipeRepo;

    /**
     * Constructor for saveRecipeInteractor object which takes in both the presenterInterface and the
     * repository interface object
     *
     * @param presenterInterface SaveRecipeOutputBoundary interface so that use case can call the presenter
     * @param userRepo           the UserRepositoryInterface to access the data in the outermost layer
     */
    public SaveRecipeInteractor(SaveRecipeOutputBoundary presenterInterface, UserRepositoryInterface userRepo,
                                RecipeRepository recipeRepo) {
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
//        String userID = inputDS.getUserSaver().getId();
//         TODO: might need to change the lines below
        String userID = inputDS.getUserSaver().getUsername();
        String recipeID = inputDS.getRecipeToBeSaved().getId();


        Optional<User> saver = userRepo.findById(userID);
        Optional<Recipe> recipeToBeSaved = recipeRepo.findById(recipeID);

        if (saver.isPresent() && recipeToBeSaved.isPresent()) {
            User saverUser = saver.get();
            Recipe recipe = recipeToBeSaved.get();

            // Check if the recipe being passed in has already been saved or not
            if (saverUser.containsRecipe(recipe)) {
                return presenterInterface.present("Recipe is already saved");
                // TODO: ensure that .equals() is implemented in class User
            } else if (recipe.getUser().equals(saverUser)) {
                return presenterInterface.present("You can't save a recipe that you have created");
            } else {
                // if recipe is not in the list of saved recipes then we save it and return the message below
                saverUser.addRecipe(recipe);
                userRepo.update(saverUser);
                return presenterInterface.present("Recipe successfully saved");
            }
        }

        return presenterInterface.present("User or recipe object is invalid");
    }

    @Override
    public String unsaveRecipe(SaveRecipeData inputDS) {
        String userID = inputDS.getUserSaver().getId();
        String recipeID = inputDS.getRecipeToBeSaved().getId();

        // the lines below implicitly assume that the repo contains user and recipe objects which are valid and
        // that invalid user and recipe objects are not added to the repo.
        Optional<User> saver = userRepo.findByUsername(userID);
        Optional<Recipe> recipeToBeSaved = recipeRepo.findById(recipeID);

        if (saver.isPresent() && recipeToBeSaved.isPresent()) {
            User saverUser = saver.get();
            Recipe recipe = recipeToBeSaved.get();

            // Check if the recipe being passed in has already been saved or not
            if (saverUser.containsRecipe(recipe)) {
                // since the recipe that needs to be saved in is in the list of savedRecipes we can successfully
                // remove it and return a message reporting the success of recipe being unsaved
                saverUser.removeRecipe(recipe);
                userRepo.update(saverUser);
                return presenterInterface.present("Recipe successfully unsaved");
            } else {
                // if recipe is not in the list of saved recipes then there's nothing to un-save, and we report
                // this back
                return presenterInterface.present("Recipe is not in the list of savedRecipes");
            }
        }
        return presenterInterface.present("User or recipe object is invalid");

    }
}
