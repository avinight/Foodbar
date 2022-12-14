package recipe.foodbar.presenter;

import recipe.foodbar.entities.Review;
import recipe.foodbar.usecase.review.ReviewOutputData;
import recipe.foodbar.usecase.review.port.ReviewOutputBoundary;

public class ReviewPresenter implements ReviewOutputBoundary {
    @Override
    public ReviewOutputData present(Review review, String message) {
        return new ReviewOutputData(review, message);
    }
}
