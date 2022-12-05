package recipe.foodbar.repository.mongoDB.mapper;

import lombok.NonNull;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.repository.mongoDB.model.RecipeModel;

public class RecipeMapper {
    @NonNull
    public static Recipe toEntity(RecipeModel recipeModel) {
        return new Recipe(recipeModel.getId().toHexString(),
                recipeModel.getTitle(),
                recipeModel.getAuthor(),
                recipeModel.getPortionSize(),
                recipeModel.getInstructions(),
                recipeModel.getCuisine(),
                recipeModel.getDietaryRestrictions(),
                recipeModel.getDateCreated(),
                recipeModel.getIngredients(),
                recipeModel.getReviews(),
                recipeModel.getLikers(),
                recipeModel.getDislikers());
    }

    @NonNull
    public static RecipeModel toUserModel(Recipe recipe) {
        return new RecipeModel(new ObjectId(recipe.getId()),
                recipe.getTitle(),
                recipe.getAuthor(),
                recipe.getInstructions(),
                recipe.getCuisine(),
                recipe.getDietaryRestrictions(),
                recipe.getDateCreated(),
                recipe.getPortionSize(),
                recipe.getReviews(),
                recipe.getIngredients(),
                recipe.getLikers(),
                recipe.getDislikers());
    }
}
