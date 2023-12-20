package foodbar.usecase.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class ReviewInputData {
    String recipeId;
    String title;
    String text;
    String userId;
}
