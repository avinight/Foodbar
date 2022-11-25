package recipe.foodbar.app.manual;

import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.simpleDB.InMemoryRecipeRepository;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class Recipe {
    public static void main(String[] args) {
        InMemoryRecipeRepository repo = new InMemoryRecipeRepository();
        final IdGenerator idGenerator = new JugIdGenerator();
        System.out.println("Test Recipe Creation");

        String title = "Mom's Spaghetti";

    }
}
