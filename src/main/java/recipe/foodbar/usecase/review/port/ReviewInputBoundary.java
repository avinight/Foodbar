package recipe.foodbar.usecase.review.port;

import recipe.foodbar.controller.dto.ReviewDTO;
import recipe.foodbar.entities.Review;

public interface ReviewInputBoundary {
    Review writeReview(ReviewDTO reviewDTO);
}
