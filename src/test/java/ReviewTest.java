import com.mongodb.client.MongoDatabase;

import static junit.framework.TestCase.assertEquals;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;

import static recipe.foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class ReviewTest {
    MongoDatabase db = getMongoDB();
    MongoRecipeRepository recipeRepo = new MongoRecipeRepository(db);


}
