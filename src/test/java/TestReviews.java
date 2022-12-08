import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static junit.framework.TestCase.assertEquals;

import recipe.foodbar.controller.recipe.CreateRecipeController;
import recipe.foodbar.controller.review.ReviewController;
import recipe.foodbar.presenter.ReviewPresenter;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.entities.*;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongoDB.repository.MongoUserRepository;
import recipe.foodbar.usecase.commonport.IdGenerator;
import recipe.foodbar.usecase.review.ReviewInputData;
import recipe.foodbar.usecase.review.ReviewOutputData;
import recipe.foodbar.usecase.review.WriteReviewInteractor;
import recipe.foodbar.usecase.review.port.ReviewInputBoundary;
import recipe.foodbar.usecase.review.port.ReviewOutputBoundary;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static recipe.foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class TestReviews {
    MongoDatabase db = getMongoDB();
    MongoRecipeRepository recipeRepo = new MongoRecipeRepository(db);

    final IdGenerator idGenerator = new JugIdGenerator();

    @Test
    public void testRecipeExists() {
        ArrayList<Recipe> allRecipes = recipeRepo.getAllRecipes();
        System.out.println(allRecipes);
    }
    @Test
    public void testCreateReviewItalianCuisine() {
        //Input, Output boundaries, controller, usecase interactor
        ReviewOutputBoundary outputBoundary = new ReviewPresenter();
        MongoUserRepository userRepo = new MongoUserRepository(db);
        ReviewInputBoundary inputBoundary = new WriteReviewInteractor(recipeRepo, userRepo, outputBoundary);
        ReviewController reviewController = new ReviewController(inputBoundary);
        //Creating author, input data, etc
        User author1 = User.builder()
                .id(idGenerator.generate())
                .username("Deez")
                .password("Nutz")
                .email("Deez.Nutz@gmail.com")
                .followers(new ArrayList<User>())
                .following(new ArrayList<User>())
                .build();
        userRepo.create(author1);

        Cuisine italianCuisine = Cuisine.builder()
                .id(idGenerator.generate())
                .name("Italian")
                .build();

        Recipe injera = Recipe.builder()
                .id(idGenerator.generate())
                .title("Injera")
                .user(author1)
                .portionSize((float) 1.0)
                .instructions(new ArrayList<String>())
                .cuisine(italianCuisine)
                .dietaryRestrictions(new ArrayList<String>())
                .dateCreated(new Date())
                .ingredients(new ArrayList<Ingredient>())
                .reviews(new ArrayList<Review>())
                .likers(new ArrayList<String>())
                .dislikers(new ArrayList<String>())
                .build();

        Recipe r1 = recipeRepo.create(injera);

        ReviewInputData inputData = new ReviewInputData(r1.getId(), "This Injera Recipe Sucks",
                "This recipe sucks. Tried to follow instructions but ended up buying loltyler1 merch", author1.getId());
        WriteReviewInteractor interactor = new WriteReviewInteractor(recipeRepo, userRepo, outputBoundary);

        ReviewOutputData outputData = interactor.writeReview(inputData);
        Assertions.assertEquals("Review saved successfully", outputData.getStatus());

    }
}
