package foodbar.entities;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class Review {
    private String recipeId;
    private String title;
    private String text;
    private User author;
}
