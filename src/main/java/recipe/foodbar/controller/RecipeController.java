package recipe.foodbar.controller;

import recipe.foodbar.controller.dto.RecipeDTO;
import recipe.foodbar.usecase.recipe.CreateRecipe;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeController {

    private final CreateRecipe createRecipe;

    public RecipeController(final CreateRecipe createRecipe) {
        this.createRecipe = createRecipe;
    }
    //create, get, all, showByCuisine, getByFollowing
}
