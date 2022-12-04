package recipe.foodbar.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Ingredient {
    private final String name;
    private float size;
}