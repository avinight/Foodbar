package recipe.foodbar.usecase.user;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;

public class SaveRecipeController {

    public final SaveRecipeInputBoundary inputBoundary;

    public SaveRecipeController(SaveRecipeInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }


//    public SaveRecipeData saveRecipe(User saver, Recipe recipeGiven) {
//        return new SaveRecipeData(saver, recipeGiven);
//    }

    public String saveRecipe(User saver, Recipe recipeGiven){
        SaveRecipeData dataToSave = new SaveRecipeData(saver, recipeGiven);
        return inputBoundary.saveRecipe(dataToSave);
    }

    public String unsaveRecipe(User saver, Recipe recipeGiven){
        SaveRecipeData dataToUnsave = new SaveRecipeData(saver, recipeGiven);
        return inputBoundary.unsaveRecipe(dataToUnsave);
    }
}
