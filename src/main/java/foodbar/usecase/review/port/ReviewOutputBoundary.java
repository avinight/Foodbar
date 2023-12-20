package foodbar.usecase.review.port;

import foodbar.entities.Review;
import foodbar.usecase.review.ReviewOutputData;

public interface ReviewOutputBoundary {
    ReviewOutputData present(Review review, String message);
}
