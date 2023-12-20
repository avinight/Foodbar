import com.mongodb.client.MongoDatabase;

import static junit.framework.TestCase.assertEquals;

import recipe.foodbar.entities.Cuisine;
import foodbar.repository.mongoDB.repository.MongoRecipeRepository;

import static foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class ReviewTest {
    MongoDatabase db = getMongoDB();
    MongoRecipeRepository recipeRepo = new MongoRecipeRepository(db);


}
