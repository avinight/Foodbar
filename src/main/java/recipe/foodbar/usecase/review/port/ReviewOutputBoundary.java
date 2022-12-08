package recipe.foodbar.usecase.review.port;

import recipe.foodbar.entities.Review;
import recipe.foodbar.usecase.review.ReviewOutputData;

public interface ReviewOutputBoundary {
    ReviewOutputData present(Review review, String message);
}
