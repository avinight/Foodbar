package recipe.foodbar.entities;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class Review {
    public static final int MAX_LENGTH = 300;
    private String recipeId;
    private String title;
    private String text;
    private User author;
}
