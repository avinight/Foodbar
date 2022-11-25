package recipe.foodbar.repository.mongo.mapper;

import lombok.NonNull;
import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.repository.mongo.model.RecipeModel;

public class RecipeMapper {
    @NonNull
    public static Recipe toEntity(RecipeModel recipeModelModel) {
        return new Recipe(recipeModelModel.get_id(),
                recipeModelModel.getTitle(),
                recipeModelModel.getAuthor(),
                recipeModelModel.getPortionSize(),
                recipeModelModel.getInstructions(),
                recipeModelModel.getCuisine(),
                recipeModelModel.getDietaryRestrictions(),
                recipeModelModel.getDateCreated(),
                recipeModelModel.getIngredients(),
                recipeModelModel.getReviews());
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
                recipe.getReviews(),
                recipe.getIngredients());
    }
}
