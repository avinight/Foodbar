package recipe.foodbar.entities;

import lombok.*;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuisine {
    private String name;
    private String id;
    @Builder.Default
    private ArrayList<Recipe> recipes = new ArrayList<>();
}

