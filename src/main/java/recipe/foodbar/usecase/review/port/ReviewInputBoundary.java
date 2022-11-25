package recipe.foodbar.usecase.review.port;

import recipe.foodbar.controller.dto.ReviewDTO;

public interface ReviewInputBoundary {
    ReviewDTO writeReview(ReviewDTO reviewDTO);
}
