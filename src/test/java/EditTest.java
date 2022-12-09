import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import recipe.foodbar.controller.recipe.CreateRecipeController;
import recipe.foodbar.controller.recipe.EditRecipe;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.presenter.AccountPresenter;
import recipe.foodbar.presenter.RecipePresenter;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import recipe.foodbar.repository.mongoDB.repository.MongoUserRepository;
import recipe.foodbar.usecase.commonport.IdGenerator;
import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInputBoundary;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInteractor;
import recipe.foodbar.usecase.recipe.manager.CreateRecipePresenter;
import recipe.foodbar.usecase.recipe.manager.edit.IRecipeEditor;
import recipe.foodbar.usecase.recipe.manager.edit.RecipeEditor;
import recipe.foodbar.usecase.user.manager.UserManager;
import recipe.foodbar.usecase.user.port.UserCreatorInputBoundary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static recipe.foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class EditTest {
    MongoDatabase db = getMongoDB();
    MongoRecipeRepository recipeRepo = new MongoRecipeRepository(db);

    final IdGenerator idGenerator = new JugIdGenerator();

    MongoUserRepository userRepo = new MongoUserRepository(db);
    CreateRecipePresenter createRecipePresenter = new CreateRecipePresenter();
    CreateRecipeInputBoundary recipeData = new CreateRecipeInteractor(recipeRepo, userRepo, idGenerator, createRecipePresenter);
    CreateRecipeController recipeController = new CreateRecipeController(recipeData);

    AccountPresenter accountPresenter = new AccountPresenter();
    UserCreatorInputBoundary data = new UserManager(accountPresenter, userRepo, idGenerator);
    AccountController accountController = new AccountController(data);

    @Test
    public void testSetPortionSize() {
        // creating the same users as the one in the previous testcase but with different names
        String username = "toby";
        String password = "123";
        String firstName = "tobias";
        String lastName = "razor";
        String passwordShadow = "123";
        String email = "a24@gmail.com";
        // the line below formats the data into a format that can be used by the use case interactor
//        UserInputData user = accountController.create(username, password, passwordShadow, email);
        String userCreationConfirmation = accountController.create(username, password, passwordShadow, email);

        String username3 = "Toby2";
        String password3 = "1232";
        String firstName3 = "tobias2";
        String lastName3 = "razor2";
        String passwordShadow3 = "1232";
        String email3 = "a242@gmail.com";
        String userCreationConfirmation3 = accountController.create(username3, password3, passwordShadow3, email3);

        // fetching user objects that can create the recipes
        Optional<User> user1 = userRepo.findByEmail("a24@gmail.com");
        Optional<User> user2 = userRepo.findByEmail("a242@gmail.com");
        Optional<User> userTest = userRepo.findByEmail("aaa@gmail.com");
        // check that userTest doesn't exist in the repo.

        String idNum = idGenerator.generate();
        String rTitle = "curry";
        String authorID = user1.get().getId();
        float rPortionSize = (float) 2.55;

        ArrayList<String> instructions = new ArrayList<>(Arrays.asList("idk bro. add salt. do the rest idk"));
//        instructions.add(0, "idk bro. add salt. do the rest idk");
        String cui = Cuisine.builder().id(idGenerator.generate()).name("Indian").build().getName();
//        String cusine =
        ArrayList<String> dr = new ArrayList<>(Arrays.asList("Vegan", "Halal"));
        Date rDate = new Date();
        ArrayList<Ingredient> ing = new ArrayList<>();
        Ingredient ing1 = new Ingredient("Potatoes", 69);
        ing.add(ing1);

        String recipeID = user1.get().getSavedRecipes().
        Optional<Recipe> recipeFromRepo = recipeRepo.findById(recipeID);
       if(recipeFromRepo.isPresent()){
        Recipe recipe1 = recipeFromRepo.get();}

        RecipeRequestModel rm = new RecipeRequestModel();
        rm.setId(recipeID);
        rm.setPortionSize(3);

        RecipePresenter presenter = new RecipePresenter();
        IRecipeEditor inputboundary = new RecipeEditor(recipeRepo, presenter);
        EditRecipe controller = new EditRecipe(rm, inputboundary, presenter);
        controller.edit();

        System.out.println(recipeFromRepo.get().getPortionSize());
        assert recipeFromRepo.get().getPortionSize() == 3;
    }
}

