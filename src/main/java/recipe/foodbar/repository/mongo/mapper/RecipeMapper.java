package recipe.foodbar.repository.mongo.mapper;

import lombok.NonNull;
import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.repository.mongo.model.RecipeModel;

public class RecipeMapper {
    @NonNull
    public static Recipe toEntity(RecipeModel recipeModel) {
        return new Recipe(recipeModel.get_id(),
                recipeModel.getTitle(),
                recipeModel.get_id(),
                recipeModel.getPortionSize(),
                recipeModel.getInstructions(),
                recipeModel.getCuisine(),
                recipeModel.getDietaryRestrictions(),
                recipeModel.getDateCreated(),
                recipeModel.getIngredients(),
                recipeModel.getLikers(),
                recipeModel.getDislikers(),
                recipeModel.getReviews());
    }

    @NonNull
    public static RecipeModel toUserModel(Recipe recipe) {
        return new RecipeModel(
                recipe.getId(),
                recipe.getTitle(),
                recipe.getAuthor(),
                recipe.getPortionSize(),
                recipe.getInstructions(),
                recipe.getCuisine(),
                recipe.getDietaryRestrictions(),
                recipe.getDateCreated(),
                recipe.getIngredients(),
                recipe.getLikers(),
                recipe.getDislikers(),
                recipe.getReviews()
        );
    }
}
