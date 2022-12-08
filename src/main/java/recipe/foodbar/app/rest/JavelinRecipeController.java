package recipe.foodbar.app.rest;

import io.javalin.http.Handler;
import recipe.foodbar.controller.recipe.CreateRecipeController;
import recipe.foodbar.usecase.recipe.manager.RecipeInputData;

public class JavelinRecipeController {

    private static CreateRecipeController createRecipeController;

    public JavelinRecipeController(CreateRecipeController createRecipeController) {
        JavelinRecipeController.createRecipeController = createRecipeController;
    }

    public static Handler getRecipe = ctx -> {
        System.out.println("getRecipe is called");
    };
    public static Handler createRecipe = ctx -> {
        RecipeInputData recipeInputData = ctx.bodyAsClass(RecipeInputData.class);
        recipeInputData.setUserId(ctx.cookie("session"));
        String status = createRecipeController.data.create(recipeInputData);
        System.out.println(status);
    };
}
