package recipe.foodbar.repository.mongo.repository;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.repository.mongo.MongoDB;
import recipe.foodbar.repository.mongo.mapper.RecipeMapper;
import recipe.foodbar.repository.mongo.model.RecipeModel;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.entities.Recipe.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

public class MongoRecipeRepository implements RecipeRepository {
    MongoDatabase db = MongoDB.getReference();
    MongoCollection<RecipeModel> collection = db.getCollection("Recipe", RecipeModel.class);

    @Override
    public ArrayList<Recipe> getAllRecipes() {
        return null;
    }

    @Override
    public Recipe create(Recipe recipe) {
        try {
            RecipeModel rm = RecipeMapper.toUserModel(recipe);
            InsertOneResult result = collection.insertOne(rm);
            System.out.println("Success! Inserted document id: " + result.getInsertedId());
        } catch (MongoException me) {
            System.err.println("Unable to insert user due to an error: " + me);
        }
//        Todo: Remove returning Recipe after creating Recipe
        return recipe;
    }

    @Override
    public Recipe update(Recipe recipe) {
        RecipeModel rm = RecipeMapper.toUserModel(recipe);
        Bson query = eq("_id", recipe.getId());
        ReplaceOptions opts = new ReplaceOptions().upsert(true);
        UpdateResult result = collection.replaceOne(query, rm, opts);
//        Todo: Remove console println, do we need to return Recipe?
        System.out.println(result);
        return recipe;
    }

    @Override
    public ArrayList<Recipe> getByCuisine(Cuisine cuisine) {
        Bson query = eq("cuisine", cuisine);
        List<RecipeModel> recipeModelList = collection.find(query).into(new ArrayList<>());
        List<Recipe> recipeList = recipeModelList.stream().map(RecipeMapper::toEntity).collect(Collectors.toList());
        return (ArrayList<Recipe>) recipeList;
    }

    @Override
    public Optional<Recipe> findById(String id) {
        Bson query = eq("_id", id);
        Optional<RecipeModel> rm = Optional.ofNullable(collection.find(query).first());
        return rm.map(RecipeMapper::toEntity);
    }
}
