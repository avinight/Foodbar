package recipe.foodbar.entities;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Builder
@Data
public class Cuisine {
    private final String name;
    private final String id;
    private final ArrayList<Recipe> recipes;
}

