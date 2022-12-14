import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;
import static junit.framework.TestCase.assertEquals;

import recipe.foodbar.controller.review.ReviewController;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.presenter.ReviewPresenter;
import recipe.foodbar.repository.mongoDB.MongoDB;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.entities.*;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongoDB.repository.MongoUserRepository;
import recipe.foodbar.usecase.review.ReviewInputData;
import recipe.foodbar.usecase.review.ReviewOutputData;
import recipe.foodbar.usecase.review.WriteReviewInteractor;
import recipe.foodbar.usecase.review.port.ReviewInputBoundary;
import recipe.foodbar.usecase.review.port.ReviewOutputBoundary;
import recipe.foodbar.usecase.commonport.IdGenerator;

import java.util.ArrayList;

import static recipe.foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class  TestReviews {
    MongoDatabase db = getMongoDB();
    MongoRecipeRepository recipeRepo = new MongoRecipeRepository(db);
    MongoUserRepository userRepository = new MongoUserRepository(db);

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
        ReviewInputBoundary inputBoundary = new WriteReviewInteractor(recipeRepo, userRepository, outputBoundary);
        ReviewController reviewController = new ReviewController(inputBoundary);
        WriteReviewInteractor interactor = new WriteReviewInteractor(recipeRepo, userRepository, outputBoundary);

        //Creating author, input data, etc
        User author1 = User.builder()
                .id(idGenerator.generate())
                .username("Deez")
                .password("Nutz")
                .email("Deez.Nutz@gmail.com")
                .followers(new ArrayList<User>())
                .following(new ArrayList<User>())
                .build();
        String recipeID = "63912cd06d217e48bf8cffcd";
        ReviewInputData inputData = reviewController.data(recipeID, "DUMPLINGS F***ING SUCK",
                "This dumpling recipe sucks2. Followed the instructions, ended up buying Amouranth merch", author1.getId());

        ReviewOutputData reviewOutputData = interactor.writeReview(inputData);

        //Present added review
        ReviewPresenter presenter = new ReviewPresenter();
        System.out.println();

    }
}
