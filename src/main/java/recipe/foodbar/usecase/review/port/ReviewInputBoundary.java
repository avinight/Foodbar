package recipe.foodbar.usecase.review.port;

import recipe.foodbar.controller.dto.ReviewDTO;
import recipe.foodbar.entities.Review;
import recipe.foodbar.usecase.review.ReviewInputData;
import recipe.foodbar.usecase.review.ReviewOutputData;

public interface ReviewInputBoundary {
    ReviewOutputData writeReview(ReviewInputData data);
}
