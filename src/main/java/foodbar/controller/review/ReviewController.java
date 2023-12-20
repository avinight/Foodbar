package foodbar.controller.review;

import foodbar.usecase.review.ReviewInputData;
import foodbar.usecase.review.port.ReviewInputBoundary;

public class ReviewController {
    public final ReviewInputBoundary f;
    public ReviewController(ReviewInputBoundary f) {
        this.f = f;
    }

    public ReviewInputData data(String recipeID, String title, String text, String author) {
        return new ReviewInputData(recipeID, title, text, author);
    }

}
