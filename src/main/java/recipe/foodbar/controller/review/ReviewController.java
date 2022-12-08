package recipe.foodbar.controller.review;

import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.review.ReviewInputData;
import recipe.foodbar.usecase.review.ReviewOutputData;
import recipe.foodbar.usecase.review.port.ReviewInputBoundary;

public class ReviewController {
    public final ReviewInputBoundary f;
    public ReviewController(ReviewInputBoundary f) {
        this.f = f;
    }

    public ReviewOutputData data(String recipeID, String title, String text, User author) {
        ReviewInputData inputData = new ReviewInputData(recipeID, title, text, author.getId());
        return f.writeReview(inputData);
    }

}
