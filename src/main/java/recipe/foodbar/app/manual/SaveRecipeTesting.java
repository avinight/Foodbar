package recipe.foodbar.app.manual;

import com.mongodb.client.MongoDatabase;
import recipe.foodbar.controller.recipe.CreateRecipeController;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.controller.user.AccountPresenter;
import recipe.foodbar.entities.*;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.id_generator.jug.JugIdGenerator;

import static recipe.foodbar.repository.mongoDB.MongoDB.getMongoDB;

import recipe.foodbar.repository.mongoDB.repository.*;
//import recipe.foodbar.repository.mongo.repository.MongoRecipeRepository;
//import recipe.foodbar.repository.mongo.repository.MongoUserRepository;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInputBoundary;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInteractor;
import recipe.foodbar.usecase.recipe.manager.CreateRecipePresenter;
import recipe.foodbar.usecase.recipe.manager.RecipeInputData;
import recipe.foodbar.usecase.user.UserInputData;
import recipe.foodbar.usecase.user.UserManager;
import recipe.foodbar.usecase.user.port.UserCreatorInputBoundary;
import recipe.foodbar.usecase.user.port.IdGenerator;
import recipe.foodbar.usecase.user.*;

import java.util.Arrays;
import java.util.Date;

import java.util.ArrayList;
import java.util.Optional;

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
        MongoDatabase db = getMongoDB();
//        InMemoryUserRepository userRepo = new InMemoryUserRepository();
        MongoUserRepository userRepo = new MongoUserRepository(db);
        // can't create an interface an object as then we would have to implement the methods from that repo here
        // TODO: using mongo repo yields an error so reverting to inMemoryRecipeRepo for now
        MongoRecipeRepository recipeRepo = new MongoRecipeRepository(db);
//        InMemoryRecipeRepository recipeRepo = new InMemoryRecipeRepository();
        // initializing an id generator for user and recipe creation
        final IdGenerator idGenerator = new JugIdGenerator();
        System.out.println("Test recipe saving");

        String username = "Bartholomew";
        String password = "123";
        String firstName = "tobias";
        String lastName = "razor";
        String passwordShadow = "123";
        String email = "a@gmail.com";
        AccountPresenter accountPresenter = new AccountPresenter();
        UserCreatorInputBoundary data = new UserManager(accountPresenter, userRepo, idGenerator);
        AccountController accountController = new AccountController(data);
        UserInputData user = accountController.create(username, password, passwordShadow, email);

        String userCreationConfirmation = accountController.data.create(user);
        System.out.println(userRepo.findByUsername("Bartholomew"));

        System.out.println("**********************************************************************************");
        System.out.println("Creating second user");
        String username2 = "Bartholomew2";
        String password2 = "1232";
        String firstName2 = "tobias2";
        String lastName2 = "razor2";
        String passwordShadow2 = "1232";
        String email2 = "a2@gmail.com";
        UserInputData user2Data = accountController.create(username2, password2, passwordShadow2, email2);
        String userCreationConfirmation2 = accountController.data.create(user2Data);

        System.out.println(userRepo.findByUsername("Bartholomew"));  // TODO: to be fixed as the repo returns null here

        // fetching the user objects from the userRepo that need to be saved
        Optional<User> user1 = userRepo.findByEmail("a@gmail.com");
        Optional<User> user2 = userRepo.findByEmail("a2@gmail.com");
        Optional<User> userTest = userRepo.findByEmail("aaa@gmail.com");
//        boolean val1 = user1.isPresent();
//        boolean val2 = user2.isPresent();
//        boolean val3 = userTest.isPresent();
//        if (user1.isPresent()){
//            User user22 = user1.get();}

        // testing that there

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
        String idNum = idGenerator.generate();
        String rTitle = "curry";
        User rAuthor = user1.get();
        float rPortionSize = (float) 2.55;

        ArrayList<String> instructions = new ArrayList<>(Arrays.asList("idk bro. add salt. do the rest idk"));
//        instructions.add(0, "idk bro. add salt. do the rest idk");
        Cuisine cui = Cuisine.builder().id(idGenerator.generate()).name("Indian").build();
        ArrayList<String> dr = new ArrayList<>(Arrays.asList("Vegan", "Halal"));
        Date rDate = new Date();
        ArrayList<Ingredient> ing = new ArrayList<>();
        Ingredient ing1 = new Ingredient("Potatoes", 69);
        ing.add(ing1);
        ArrayList<String> rLikers = new ArrayList<>();
        ArrayList<String> rDislikers = new ArrayList<>();
        ArrayList<Review> rReviews = new ArrayList<>();



        RecipeInputData recipeInputData = recipeController.createRecipe(rTitle, rAuthor, rPortionSize, instructions, cui, dr,
                rDate, ing, rReviews, rLikers, rDislikers);

        String recipeID = recipeController.inputBoundary.create(recipeInputData);
        Optional<Recipe> recipeFromRepo = recipeRepo.findById(recipeID);
        Recipe recipe1 = recipeFromRepo.get();
//        System.out.println(recipeID);

//        System.out.println("ooga booga");

        boolean val1 = user1.isPresent();
        boolean val2 = user2.isPresent();
        boolean val3 = userTest.isPresent();

        // fetch recipe object from the repo to be saved. TODO: how do i fetch using the ID since i can't access the id?
        //  overriding and creating a recipe using entity directly and manually saving to repo

//        Recipe recipe1 = new Recipe(idNum, rTitle, rAuthor, rPortionSize, instructions, cui, dr, rDate, ing, rReviews, rLikers, rDislikers);
//        String rID = recipe1.getId();
//        recipeRepo.create(recipe1);

        // creating presenter and controllers for saving recipe. prerequisite steps(only need to be done once)
        SaveRecipePresenter saveRecipePresenter = new SaveRecipePresenter();
        SaveRecipeInputBoundary saveRecipeData = new SaveRecipeInteractor(saveRecipePresenter, userRepo, recipeRepo);
        SaveRecipeController saveRecipeController = new SaveRecipeController(saveRecipeData);

        // the lines of code below need to be repeated everytime for saving a recipe

        // TEST 1: recipe creator tries to save the recipe that they have created
        // TODO: need to finalize how the user object and the recipe object being passed in is going to be validated:
        SaveRecipeData dataForSaving = saveRecipeController.saveRecipe(user1.get(), recipe1);
        // line below prints a message telling the user that they save a recipe that they have created
        String saveRecipeConfirmation = saveRecipeController.inputBoundary.saveRecipe(dataForSaving);

        ArrayList<Recipe> testResult1 = user1.get().getSavedRecipes();
//        boolean test1val = testResult1.equals(new ArrayList<Recipe>());

        // TEST2: User saves a recipe successfully
        System.out.println("\n 2. Test that user can save another user's recipe successfully");

        SaveRecipeData dataForSaving2 = saveRecipeController.saveRecipe(user2.get(), recipe1);
        String saveRecipeConfirmation2 = saveRecipeController.inputBoundary.saveRecipe(dataForSaving2);
        user2 = userRepo.findById(user2.get().getId());

        ArrayList<Recipe> testResult2 = user2.get().getSavedRecipes();
//        Recipe testResult2Recipe = testResult2.get(0);
//        // TODO: need to finalize how the user object and the recipe object being passed in is going to be validated:
//
        System.out.println("\n 3. Test that can't save a recipe that they have already saved.");
        // TEST3: User tries to save a recipe that's already been saved
        SaveRecipeData dataForSaving3 = saveRecipeController.saveRecipe(user2.get(), recipe1);
        String saveRecipeConfirmation3 = saveRecipeController.inputBoundary.saveRecipe(dataForSaving3);

        ArrayList<Recipe> testResult3 = user2.get().getSavedRecipes();

        System.out.println("\n 4. Test that user can successfully un-save a recipe that they have saved");
        // Test4: user can successfully un-save a recipe that they have saved
        SaveRecipeData dataForUnsaving = saveRecipeController.saveRecipe(user2.get(), recipe1);
        String unsaveRecipeConfirmation = saveRecipeController.inputBoundary.unsaveRecipe(dataForUnsaving);

        user2 = userRepo.findById(user2.get().getId());
        ArrayList<Recipe> testResult4 = user2.get().getSavedRecipes();

        System.out.println("\n 5. Test when user tries to un-save a recipe that they haven't saved");
        // user 1 tries to unsave recipe1 which they have created and which is not in their list of savedRecipes
        SaveRecipeData dataForUnsaving2 = saveRecipeController.saveRecipe(user1.get(), recipe1);
        String unsaveRecipeConfirmation2 = saveRecipeController.inputBoundary.unsaveRecipe(dataForUnsaving2);

        ArrayList<Recipe> testResult5 = user1.get().getSavedRecipes();



    }


}

