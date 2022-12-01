package recipe.foodbar.app.manual;

import recipe.foodbar.controller.recipe.CreateRecipeController;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.controller.user.AccountPresenter;
import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongo.*;
import recipe.foodbar.repository.simpleDB.InMemoryUserRepository;
import recipe.foodbar.repository.mongo.repository.MongoRecipeRepository;
import recipe.foodbar.repository.mongo.repository.MongoUserRepository;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInputBoundary;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInteractor;
import recipe.foodbar.usecase.recipe.manager.CreateRecipePresenter;
import recipe.foodbar.usecase.recipe.manager.RecipeInputData;
import recipe.foodbar.usecase.user.UserInputData;
import recipe.foodbar.usecase.user.UserManager;
import recipe.foodbar.usecase.user.port.UserCreatorInputBoundary;
import recipe.foodbar.usecase.user.port.IdGenerator;
import recipe.foodbar.usecase.user.port.UserRepositoryInterface;
import recipe.foodbar.entities.*;
import recipe.foodbar.usecase.user.*;
import java.util.Date;

import org.junit.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class SaveRecipeTesting {
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
    public static void main(String[] args) {
        // TODO: Need to change this to MongouserRepo after the necessary methods have been added to that repo.
        InMemoryUserRepository repo = new InMemoryUserRepository();
        // can't create an interface an object as then we would have to implement the methods from that repo here
//        MongoUserRepository repo = new MongoUserRepository();
        MongoRecipeRepository recipeRepo = new MongoRecipeRepository();
        final IdGenerator idGenerator = new JugIdGenerator();
        System.out.println("Test recipe saving");

        String username = "Bartholomew";
        String password = "123";
        String firstName = "tobias";
        String lastName = "razor";
        String passwordShadow = "123";
        String email = "a@gmail.com";
        AccountPresenter accountPresenter = new AccountPresenter();
        UserCreatorInputBoundary data = new UserManager(accountPresenter, repo, idGenerator);
        AccountController accountController = new AccountController(data);
        UserInputData user = accountController.create(username, password, passwordShadow, firstName, lastName, email);

        String userCreationConfirmation = accountController.data.create(user);
        System.out.println(repo.getByUsername("Bartholomew"));

        System.out.println("**********************************************************************************");
        System.out.println("Creating second user");
        String username2 = "Bartholomew2";
        String password2 = "1232";
        String firstName2 = "tobias2";
        String lastName2 = "razor2";
        String passwordShadow2 = "1232";
        String email2 = "a2@gmail.com";
        UserInputData user2Data = accountController.create(username2, password2, passwordShadow2, firstName2, lastName2, email2);
        String userCreationConfirmation2 = accountController.data.create(user2Data);

        System.out.println(repo.getByUsername("Bartholomew"));  // TODO: to be fixed as the repo returns null here

        //
        Optional<User> user1 = repo.findByEmail("a@gmail.com");
        Optional<User> user2 = repo.findByEmail("a2@gmail.com");
//        if (user1.isPresent()){
//            User user22 = user1.get();}

        ArrayList<Recipe> actArray = user1.get().getSavedRecipes();

        ArrayList<Recipe> expArray = new ArrayList<Recipe>();
//        assertEquals(expArray, actArray);
        System.out.println(expArray.equals((ArrayList<Recipe>) actArray));

        // TODO: Creating presenter for the create recipe use case. Using the same ID generator and recipe
        //  repository as the one defined above. the things below only need to be created once for the creation of
        //  all recipes
        CreateRecipePresenter createRecipePresenter = new CreateRecipePresenter();
        CreateRecipeInputBoundary recipeData = new CreateRecipeInteractor(recipeRepo, idGenerator, createRecipePresenter);
        CreateRecipeController recipeController = new CreateRecipeController(recipeData);

        // TODO: The lines above only need to be defined once to create a recipe. After this we repeat the following
        //  template for creating a recipe and saving it to the repo
        String rTitle = "curry";
        User rAuthor = user1.get();
        float rPortionSize = (float) 2.55;
        String[] instructions = new String[]{"idk bro. add salt", "do the rest idk"};
        Cuisine cui = new Cuisine("Indian", "1");
        String[] dr = new String[]{"Vegan", "Halal"};
        Date rDate = new Date();
        ArrayList<Ingredient> ing = new ArrayList<>();
        Ingredient ing1 = new Ingredient("Potatoes", 69);
        ing.add(ing1);
        ArrayList<String> rLikers = new ArrayList<>();
        ArrayList<String> rDislikers = new ArrayList<>();
        ArrayList<Review> rReviews = new ArrayList<>();



        RecipeInputData recipe = recipeController.createRecipe(rTitle, rAuthor, rPortionSize, instructions, cui, dr,
                rDate, ing, rLikers, rDislikers, rReviews);

        String recipeCreationConfirmation = recipeController.inputBoundary.create(recipe);

        System.out.println("ooga booga");




//        RecipeInputData recipe = recipeController.createRecipe()








    }


}
