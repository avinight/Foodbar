package recipe.foodbar.app.manual;

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

public class RoneyTest {
    public static void main(String[] args) {
        MongoDatabase db = getMongoDB();
        Bson command = new BsonDocument("ping", new BsonInt64(1));
        Document commandResult = db.runCommand(command);
        System.out.println("RoneyTest: Connected successfully to server." + commandResult);
        MongoRecipeRepository recipeRepository = new MongoRecipeRepository(db);

        final IdGenerator idGenerator = new JugIdGenerator();

        Cuisine chineseCuisine = Cuisine.builder()
                .id(idGenerator.generate())
                .name("Chinese")
                .build();
        Cuisine italianCuisine = Cuisine.builder()
                .id(idGenerator.generate())
                .name("Italian")
                .build();

        //Create Users (authors)
        User u1 = new recipe.foodbar.entities.User(idGenerator.generate(), "dsfsdf", "dsfdsf", "dsfsdf", "dsfsdf", "sdfdsf@dsfs.com");


        //Create the recipes and add them to recipeRepo
        Recipe chickenAlfredo = new Recipe(idGenerator.generate(), "Chicken Alfredo", u1,
                (float) 1.0, new ArrayList<String>(), italianCuisine, new ArrayList<String>(), new Date(), new ArrayList<Ingredient>(), new ArrayList<Review>(), 0, 0);

        Recipe r1 = recipeRepository.create(chickenAlfredo);
    }
}
