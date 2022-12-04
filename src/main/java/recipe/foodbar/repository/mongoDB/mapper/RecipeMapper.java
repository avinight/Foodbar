package recipe.foodbar.repository.mongoDB.mapper;

import lombok.NonNull;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.repository.mongoDB.model.RecipeModel;

public class RecipeMapper {
    @NonNull
    public static Recipe toEntity(RecipeModel recipeModelModel) {
        return new Recipe(recipeModelModel.get_id().toHexString(),
                recipeModelModel.getTitle(),
                recipeModelModel.getAuthor(),
                recipeModelModel.getPortionSize(),
                recipeModelModel.getInstructions(),
                recipeModelModel.getCuisine(),
                recipeModelModel.getDietaryRestrictions(),
                recipeModelModel.getDateCreated(),
                recipeModelModel.getIngredients(),
                recipeModelModel.getReviews(),
                recipeModelModel.getLikes(),
                recipeModelModel.getDislikes());
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
                recipe.getIngredients());
    }
}
