package recipe.foodbar.config;

import recipe.foodbar.encoder.sha256.Sha256PasswordEncoder;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.simpleDB.InMemoryCuisineRepository;
import recipe.foodbar.repository.simpleDB.InMemoryRecipeRepository;
import recipe.foodbar.repository.simpleDB.InMemoryUserRepository;
import recipe.foodbar.usecase.cuisine.CreateCuisine;
import recipe.foodbar.usecase.cuisine.port.CuisineRepository;
import recipe.foodbar.usecase.recipe.CreateRecipe;
import recipe.foodbar.usecase.recipe.UpdateRecipe;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.review.CreateReview;
import recipe.foodbar.usecase.user_example.CreateUser;
import recipe.foodbar.usecase.user_example.FindUser;
import recipe.foodbar.usecase.user_example.LoginUser;
import recipe.foodbar.usecase.user_example.port.IdGenerator;
import recipe.foodbar.usecase.user_example.port.PasswordEncoder;
import recipe.foodbar.usecase.user_example.port.UserRepository;


public class ManualConfig {
    private final UserRepository userRepository = new InMemoryUserRepository();
    private final CuisineRepository cuisineRepository = new InMemoryCuisineRepository();
    private final RecipeRepository recipeRepository = new InMemoryRecipeRepository();
    private final IdGenerator idGenerator = new JugIdGenerator();
    private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

    public CreateUser createUser() {
        return new CreateUser(userRepository, passwordEncoder, idGenerator);
    }

    public FindUser findUser() {
        return new FindUser(userRepository);
    }

    public LoginUser loginUser() {
        return new LoginUser(userRepository, passwordEncoder);
    }

    public CreateCuisine createCuisine() {
        return new CreateCuisine(cuisineRepository, idGenerator);
    }

    public CreateRecipe createRecipe() {
        return new CreateRecipe(recipeRepository, idGenerator);
    }

    public UpdateRecipe updateRecipe() {
        return new UpdateRecipe(recipeRepository, idGenerator);
    }

    public CreateReview createReview(String recipeId) {
        return new CreateReview(recipeRepository, idGenerator, recipeId);
    }
}