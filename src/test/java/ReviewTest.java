import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static junit.framework.TestCase.assertEquals;
import recipe.foodbar.controller.recipe.FilterRecipes;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import recipe.foodbar.usecase.cuisine.FilterByCuisine;
import recipe.foodbar.usecase.recipe.manager.filter.CuisineFilterData;
import recipe.foodbar.usecase.recipe.manager.filter.CuisineFilterInputBoundary;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.entities.*;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import recipe.foodbar.usecase.user.port.IdGenerator;

import java.util.ArrayList;
import java.util.Date;

import static recipe.foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class ReviewTest {
    MongoDatabase db = getMongoDB();
    MongoRecipeRepository recipeRepo = new MongoRecipeRepository(db);


}
