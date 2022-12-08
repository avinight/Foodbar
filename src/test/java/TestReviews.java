import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static junit.framework.TestCase.assertEquals;

import recipe.foodbar.controller.review.ReviewController;
import recipe.foodbar.presenter.ReviewPresenter;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.entities.*;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.usecase.review.ReviewInputData;
import recipe.foodbar.usecase.review.WriteReviewInteractor;
import recipe.foodbar.usecase.review.port.ReviewInputBoundary;
import recipe.foodbar.usecase.review.port.ReviewOutputBoundary;
import recipe.foodbar.usecase.user.port.IdGenerator;

import java.util.ArrayList;

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
        ReviewInputBoundary inputBoundary = new WriteReviewInteractor(recipeRepo, outputBoundary);
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
        String recipeID = "638e886d2aaa9312bfd0d283";
        Review newReview = reviewController.data(recipeID, "THESE DUMPLINGS F****NG SUCK",
                "This dumpling recipe sucks. Tried to follow instructions, ended up buying Amouranth merch", author1);
        //Present added review
        ReviewPresenter presenter = new ReviewPresenter();
        Assertions.assertEquals("This dumpling recipe sucks. Tried to follow instructions, ended up buying " +
                "Amouranth merch", presenter.present(newReview).getText());
    }
}
