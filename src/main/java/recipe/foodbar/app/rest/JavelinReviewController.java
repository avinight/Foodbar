package recipe.foodbar.app.rest;

import io.javalin.http.Handler;
import recipe.foodbar.usecase.review.ReviewInputData;
import recipe.foodbar.usecase.review.WriteReviewInteractor;

public class JavelinReviewController {
    static WriteReviewInteractor writeReviewInteractor;

    public JavelinReviewController(WriteReviewInteractor writeReviewInteractor) {
        JavelinReviewController.writeReviewInteractor = writeReviewInteractor;
    }

    public static Handler createReview = ctx -> {
        ReviewInputData inputData = ctx.bodyAsClass(ReviewInputData.class);
        System.out.println(inputData);
        writeReviewInteractor.writeReview(inputData);
//        UserInputData user = ctx.bodyAsClass(UserInputData.class);
//        String creationStatus = accountController.data.create(user);
//        System.out.println(creationStatus);
//        ctx.json(creationStatus);
    };
}
