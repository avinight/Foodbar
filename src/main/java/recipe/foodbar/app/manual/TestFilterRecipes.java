package recipe.foodbar.app.manual;

import com.mongodb.client.MongoDatabase;
import recipe.foodbar.entities.*;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import recipe.foodbar.usecase.user.port.IdGenerator;

import java.util.ArrayList;
import java.util.Date;

import static recipe.foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class TestFilterRecipes {
    public static void main(String[] args) {
        MongoDatabase db = getMongoDB();
        MongoRecipeRepository recipeRepo = new MongoRecipeRepository(db);

        final IdGenerator idGenerator = new JugIdGenerator();

        Cuisine chineseCuisine = Cuisine.builder()
                .id(idGenerator.generate())
                .name("Chinese")
                .build();
        Cuisine italianCuisine = Cuisine.builder()
                .id(idGenerator.generate())
                .name("Italian")
                .build();

        User emoney221 = new User(idGenerator.generate(), "dsfsdf", "dsfdsf", "dsfsdf", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Recipe pizza = new Recipe(idGenerator.generate(), "Pizza", emoney221,
                (float) 1.0, new ArrayList<String>(), italianCuisine, new ArrayList<String>(), new Date(), new ArrayList<Ingredient>(), new ArrayList<Review>(), new ArrayList<String>(), new ArrayList<String>());
        Recipe pasta = new Recipe(idGenerator.generate(), "Pasta", emoney221,
                (float) 1.0, new ArrayList<String>(), italianCuisine, new ArrayList<String>(), new Date(), new ArrayList<Ingredient>(), new ArrayList<Review>(), new ArrayList<String>(), new ArrayList<String>());
        Recipe generalTao = new Recipe(idGenerator.generate(), "General Tao", emoney221,
                (float) 1.0, new ArrayList<String>(), chineseCuisine, new ArrayList<String>(), new Date(), new ArrayList<Ingredient>(), new ArrayList<Review>(), new ArrayList<String>(), new ArrayList<String>());
        Recipe dumplings = new Recipe(idGenerator.generate(), "Dumplings", emoney221,
                (float) 1.0, new ArrayList<String>(), chineseCuisine, new ArrayList<String>(), new Date(), new ArrayList<Ingredient>(), new ArrayList<Review>(), new ArrayList<String>(), new ArrayList<String>());
        Recipe rice = new Recipe(idGenerator.generate(), "Rice", emoney221,
                (float) 1.0, new ArrayList<String>(), chineseCuisine, new ArrayList<String>(), new Date(), new ArrayList<Ingredient>(), new ArrayList<Review>(), new ArrayList<String>(), new ArrayList<String>());

//        Recipe r1 = recipeRepo.create(pasta);
//        Recipe r2 = recipeRepo.create(pizza);
//        Recipe r3 = recipeRepo.create(generalTao);
//        Recipe r4 = recipeRepo.create(dumplings);
//        Recipe r5 = recipeRepo.create(rice);

//        CuisineFilterInputBoundary inputBoundary = new FilterByCuisine(recipeRepo);
//        FilterRecipes filterController = new FilterRecipes(inputBoundary);
//
//        CuisineFilterData chineseInputData = filterController.data(chineseCuisine);
//
//        FilterByCuisine interactor = new FilterByCuisine(recipeRepo);
//
//        ArrayList<Recipe> chineseRecipees = interactor.filterByCuisine(chineseInputData);
//
//        System.out.println(chineseRecipees);

        System.out.println(recipeRepo.getByCuisine(italianCuisine));


//        // Create Cuisine Setup
//
//        // Filter Controller Setup
//        RecipeRepository repo = new MongoRecipeRepository();
//        CuisineFilterInputBoundary f2 = new FilterByCuisine(repo);
//        FilterRecipes controller = new FilterRecipes(f2);
//
//        CuisineFilterData chineseCuisineData = controller.data();
//        CuisineFilterData italianCuisineData = controller.data();
//
//
//        controller.f.filterByCuisine(chineseCuisineData);
//
//
//        //Recipe setup


    }
}
