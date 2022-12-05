package recipe.foodbar.app.manual;

import recipe.foodbar.controller.recipe.FilterRecipes;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.Review;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import recipe.foodbar.repository.simpleDB.InMemoryUserRepository;
import recipe.foodbar.usecase.cuisine.FilterByCuisine;
import recipe.foodbar.usecase.recipe.manager.filter.CuisineFilterData;
import recipe.foodbar.usecase.recipe.manager.filter.CuisineFilterInputBoundary;
import recipe.foodbar.usecase.user.port.IdGenerator;

import java.util.ArrayList;
import java.util.Date;

public class UserTest {
    public static void main(String[] args) {
//        InMemoryUserRepository repo = new InMemoryUserRepository();
//        MongoRecipeRepository recipeRepo = new MongoRecipeRepository();
//        final IdGenerator idGenerator = new JugIdGenerator();
//
//        Cuisine chineseCuisine = new Cuisine("Chinese", "10");
//        Cuisine italianCuisine = new Cuisine("Italian", "11");
//
//        //Create the recipes and add them to recipeRepo
//        Recipe chickenAlfredo = new Recipe("1", "Chicken Alfredo", new User("12", "pp", "pp", "pp", "pp","pp"),
//                (float) 1.0, new String[0], italianCuisine, new String[0], new Date(), new ArrayList<Ingredient>(), new ArrayList<String>(), new ArrayList<String>(),
//                new ArrayList<Review>());
//        Recipe pizza = new Recipe("2", "Pizza", new User("13", "pp", "pp", "pp", "pp","pp"),
//                (float) 1.0, new String[0], italianCuisine, new String[0], new Date(), new ArrayList<Ingredient>(), new ArrayList<String>(), new ArrayList<String>(),
//                new ArrayList<Review>());
//        Recipe generalTao = new Recipe("3", "General Tao", new User("14", "pp", "pp", "pp", "pp","pp"),
//                (float) 1.0, new String[0], chineseCuisine, new String[0], new Date(), new ArrayList<Ingredient>(), new ArrayList<String>(), new ArrayList<String>(),
//                new ArrayList<Review>());
//        Recipe dumplings = new Recipe("4", "Dumplings", new User("15", "pp", "pp", "pp", "pp","pp"),
//                (float) 1.0, new String[0], chineseCuisine, new String[0], new Date(), new ArrayList<Ingredient>(), new ArrayList<String>(), new ArrayList<String>(),
//                new ArrayList<Review>());
//        Recipe rice = new Recipe("5", "Rice", new User("16", "pp", "pp", "pp", "pp","pp"),
//                (float) 1.0, new String[0], chineseCuisine, new String[0], new Date(), new ArrayList<Ingredient>(), new ArrayList<String>(), new ArrayList<String>(),
//                new ArrayList<Review>());
//
//        Recipe r1 = recipeRepo.create(chickenAlfredo);
//        Recipe r2 = recipeRepo.create(pizza);
//        Recipe r3 = recipeRepo.create(generalTao);
//        Recipe r4 = recipeRepo.create(dumplings);
//        Recipe r5 = recipeRepo.create(rice);
//
//        //Input Boundary, Controller, Input Data
//        CuisineFilterInputBoundary inputBoundary = new FilterByCuisine(recipeRepo);
//        FilterRecipes filterController = new FilterRecipes(inputBoundary);
//
//        CuisineFilterData chineseInputData = filterController.data(chineseCuisine);
//
//        //Use case interactor
//        FilterByCuisine interactor = new FilterByCuisine(recipeRepo);
//
//        ArrayList<Recipe> filteredRecipes = interactor.filterByCuisine(chineseInputData);
//
//        System.out.println(filteredRecipes);













//
//
//
//        System.out.println("Test Account creation");
//
//        String username = "Arthur123";
//        String password = "123";
//        String firstName = "Arthur";
//        String lastName = "dog";
//        String passwordShadow = "123";
//        String email = "a@gmail.com";
//        AccountPresenter accountPresenter = new AccountPresenter();
//        UserCreatorInputBoundary data = new UserManager(accountPresenter, repo, idGenerator);
//        AccountController accountController = new AccountController(data);
//        UserInputData user = accountController.create(username, password, passwordShadow, firstName, lastName, email);
//
//
//        System.out.println(accountController.data.create(user));
//        System.out.println(repo.findByUsername("Arthur123"));
//        System.out.println(repo.existsByUsername("Arthur123"));
//
//        System.out.println("**********************************************************************************");
//
//        System.out.println("Test Account creation with one null entry");
//
//        String username2 = "Arthur2";
//        String password2 = "123";
//        String firstName2 = null;
//        String lastName2 = "dog";
//        String passwordShadow2 = "123";
//        String email2 = "a@gmail.com";
//        UserInputData user2 = accountController.create(username2, password2, passwordShadow2,
//                firstName2, lastName2, email2);
//
//
//        System.out.println(accountController.data.create(user2));
//        System.out.println(repo.findByUsername("Arthur2"));
//        System.out.println(repo.existsByUsername("Arthur2"));
//
//        System.out.println("**********************************************************************************");
//
//        System.out.println("Test Account creation with two null entries");
//
//        String username3 = "Arthur3";
//        String password3 = "12345";
//        String firstName3 = null;
//        String lastName3 = null;
//        String passwordShadow3 = "12345";
//        String email3 = "dog@gmail.com";
//
//        //Setup of a new in memory repository object
//
//        UserInputData user3 = accountController.create(username3, password3, passwordShadow3,
//                firstName3, lastName3, email3);
//
//        //presenter receives this data and returns the Username, along with successful creation message
//
//        //accountController.data.create(user);
//
//        System.out.println(accountController.data.create(user3));
//        System.out.println(repo.findByUsername("Arthur3"));
//        System.out.println(repo.findAllUsers());
    }
}
