package foodbar.usecase.review.port;

import foodbar.usecase.review.ReviewInputData;
import foodbar.usecase.review.ReviewOutputData;

public interface ReviewInputBoundary {
    ReviewOutputData writeReview(ReviewInputData data);
}
