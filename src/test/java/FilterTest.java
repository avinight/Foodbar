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

public class FilterTest {
    MongoDatabase db = getMongoDB();
    MongoRecipeRepository recipeRepo = new MongoRecipeRepository(db);

    final IdGenerator idGenerator = new JugIdGenerator();

    @Test
    public void testFilterChineseRecipes() {
        CuisineFilterInputBoundary inputBoundary = new FilterByCuisine(recipeRepo);
        FilterRecipes filterController = new FilterRecipes(inputBoundary);
        FilterByCuisine interactor = new FilterByCuisine(recipeRepo);

        //Test Chinese
        Cuisine chineseCuisine = Cuisine.builder()
                .id(idGenerator.generate())
                .name("Chinese")
                .build();

        ArrayList<Recipe> chineseRecipes = interactor.filterByCuisine(filterController.data(chineseCuisine));
        for (Recipe r: chineseRecipes) {
            Assertions.assertEquals(r.getCuisine().getName(), chineseCuisine.getName());
        }
        Assertions.assertEquals(3, chineseRecipes.size());
    }

    @Test
    public void testFilterItalianRecipes() {
        CuisineFilterInputBoundary inputBoundary = new FilterByCuisine(recipeRepo);
        FilterRecipes filterController = new FilterRecipes(inputBoundary);
        FilterByCuisine interactor = new FilterByCuisine(recipeRepo);

        //Test Italian
        Cuisine italianCuisine = Cuisine.builder()
                .id(idGenerator.generate())
                .name("Italian")
                .build();

        ArrayList<Recipe> italianRecipes = interactor.filterByCuisine(filterController.data(italianCuisine));
        Assertions.assertEquals(3, italianRecipes.size());
        System.out.println(italianRecipes.get(0));
    }

    @Test
    public void testFilterEthiopianRecipes() {
        CuisineFilterInputBoundary inputBoundary = new FilterByCuisine(recipeRepo);
        FilterRecipes filterController = new FilterRecipes(inputBoundary);
        FilterByCuisine interactor = new FilterByCuisine(recipeRepo);

        //Test Ethiopian
        Cuisine ethiopianCuisine = Cuisine.builder()
                .id(idGenerator.generate())
                .name("Ethiopian")
                .build();

        ArrayList<Recipe> ethiopianRecipes = interactor.filterByCuisine(filterController.data(ethiopianCuisine));
        Assertions.assertEquals(0, ethiopianRecipes.size());
    }




}
