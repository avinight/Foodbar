package foodbar.presenter;

import foodbar.usecase.review.ReviewOutputData;
import foodbar.entities.Review;
import foodbar.usecase.review.port.ReviewOutputBoundary;

public class ReviewPresenter implements ReviewOutputBoundary {
    @Override
    public ReviewOutputData present(Review review, String message) {
        return new ReviewOutputData(review, message);
    }
}
