package recipe.foodbar.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuisine {
    private String name;
    private String id;
    private ArrayList<Recipe> recipes;
}

