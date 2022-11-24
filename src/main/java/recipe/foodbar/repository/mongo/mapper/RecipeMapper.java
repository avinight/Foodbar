package recipe.foodbar.repository.mongo.mapper;

import lombok.NonNull;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.repository.mongo.model.RecipeModel;

public class RecipeMapper {
    @NonNull
    public static Recipe toEntity(RecipeModel recipeModelModel) {
        return new Recipe(recipeModelModel.get_id(),
                recipeModelModel.getTitle(),
                recipeModelModel.getAuthor(),
                recipeModelModel.getInstructions(),
                recipeModelModel.getCuisine(),
                recipeModelModel.getDietaryRestrictions(),
                recipeModelModel.getDateCreated(),
                recipeModelModel.getPortionSize(),
                recipeModelModel.getLikes(),
                recipeModelModel.getDislikes(),
                recipeModelModel.getReviews(),
                recipeModelModel.getIngredients());
    }

    @NonNull
    public static RecipeModel toUserModel(Recipe recipe) {
        return new RecipeModel(recipe.getId(),
                recipe.getTitle(),
                recipe.getAuthor(),
                recipe.getInstructions(),
                recipe.getCuisine(),
                recipe.getDietaryRestrictions(),
                recipe.getDateCreated(),
                recipe.getPortionSize(),
                recipe.getLikes(),
                recipe.getDislikes(),
                recipe.getReviews(),
                recipe.getIngredients());
    }
}
