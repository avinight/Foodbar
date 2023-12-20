package foodbar.usecase.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import foodbar.entities.Review;

@Data
@AllArgsConstructor
public class ReviewOutputData {
    private Review review;
    private String status;
}
