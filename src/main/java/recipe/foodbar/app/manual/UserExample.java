package recipe.foodbar.app.manual;

//import recipe.foodbar.config.ManualConfig;
import recipe.foodbar.usecase.recipe.exception.RecipeAlreadyExistsException;

import recipe.foodbar.controller.recipe.FilterRecipes;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.simpleDB.InMemoryUserRepository;
import recipe.foodbar.usecase.cuisine.FilterByCuisine;
import recipe.foodbar.usecase.recipe.manager.filter.CuisineFilterData;
import recipe.foodbar.usecase.recipe.manager.filter.CuisineFilterInputBoundary;
import recipe.foodbar.usecase.user.port.IdGenerator;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

public class UserExample {
    public static void main(String[] args) throws RecipeAlreadyExistsException {
//        InMemoryUserRepository repo = new InMemoryUserRepository();
//        MongoRecipeRepository recipeRepo = new MongoRecipeRepository();
//        final IdGenerator idGenerator = new JugIdGenerator();
//
//        Cuisine chineseCuisine = new Cuisine("Chinese", "10");
//        Cuisine italianCuisine = new Cuisine("Italian", "11");
//
//        //Create Users (authors)
//        User u1 = new User("12", "pp", "pp", "pp", "pp","pp");
//        User u2 = new User("13", "pp", "pp", "pp", "pp","pp");
//        User u3 = new User("14", "pp", "pp", "pp", "pp","pp");
//        User u4 = new User("15", "pp", "pp", "pp", "pp","pp");
//        User u5 = new User("16", "pp", "pp", "pp", "pp","pp");
//
//
//
//        //Create the recipes and add them to recipeRepo
//        Recipe chickenAlfredo = new Recipe("1", "Chicken Alfredo", u1.getId(),
//                (float) 1.0, new String[0], italianCuisine, new String[0], new Date(), new ArrayList<Ingredient>(), new ArrayList<String>(), new ArrayList<String>(),
//                new ArrayList<Review>());
//        Recipe pizza = new Recipe("2", "Pizza", u2.getId(),
//                (float) 1.0, new String[0], italianCuisine, new String[0], new Date(), new ArrayList<Ingredient>(), new ArrayList<String>(), new ArrayList<String>(),
//                new ArrayList<Review>());
//        Recipe generalTao = new Recipe("3", "General Tao", u3.getId(),
//                (float) 1.0, new String[0], chineseCuisine, new String[0], new Date(), new ArrayList<Ingredient>(), new ArrayList<String>(), new ArrayList<String>(),
//                new ArrayList<Review>());
//        Recipe dumplings = new Recipe("4", "Dumplings", u4.getId(),
//                (float) 1.0, new String[0], chineseCuisine, new String[0], new Date(), new ArrayList<Ingredient>(), new ArrayList<String>(), new ArrayList<String>(),
//                new ArrayList<Review>());
//        Recipe rice = new Recipe("5", "Rice", u5.getId(),
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

        // Setup
//        var config = new ManualConfig();
//
//        // User Setup
//        var createUser = config.createUser();
//        var findUser = config.findUser();
//        var loginUser = config.loginUser();
//
//        // Cuisine Setup
//        var createCusine = config.createCuisine();
//
//        // Recipe Setup
//        var createRecipe = config.createRecipe();
//        var updateRecipe = config.updateRecipe();
//
//        // Review Setup
////        var createReview = config.createReview();
//        LocalDate date = LocalDate.now();
//
//        var user1 = recipe.foodbar.entities.UserExample.builder()
//                .email("john.doe@gmail.com")
//                .password("mypassword")
//                .lastName("doe")
//                .firstName("john")
//                .build();
//
//        var user2 = recipe.foodbar.entities.UserExample.builder()
//                .email("tim.allen@apple.com")
//                .password("mypassword")
//                .lastName("allen")
//                .firstName("tim")
//                .build();
//
//        var italianCusine = recipe.foodbar.entities.Cuisine.builder()
//                .name("Italian")
//                .build();
//
//        var pastaDough = recipe.foodbar.entities.Ingredient.builder()
//                .name("Basic Egg Pasta Dough")
//                .size(1)
//                .build();
//
//        var cheese = recipe.foodbar.entities.Ingredient.builder()
//                .name("Parmigiano Reggiano")
//                .size(1.25F)
//                .build();
//
//        var roastBeef = recipe.foodbar.entities.Ingredient.builder()
//                .name("Beef")
//                .size(4)
//                .build();
//
//        var rosemary = recipe.foodbar.entities.Ingredient.builder()
//                .name("Rosemary")
//                .size(6)
//                .build();
//
//        var recipeToSave1 = recipe.foodbar.entities.Recipe.builder()
//                .author(user1)
//                .cuisine(italianCusine)
//                .title("Ravioli di Zucca")
//                .dateCreated(date)
//                .portionSize(4)
//                .ingredients(new ArrayList<>(Arrays.asList(pastaDough, cheese)))
//                .build();
//
//        var recipeToSave2 = recipe.foodbar.entities.Recipe.builder()
//                .author(user1)
//                .cuisine(italianCusine)
//                .title("Italian Roast Beef")
//                .dateCreated(date)
//                .portionSize(4)
//                .ingredients(new ArrayList<>(Arrays.asList(roastBeef, rosemary)))
//                .dietaryRestrictions(new String[]{
//                        "Glueten Free",
//                        "Lactose free"
//                })
//                .build();
//
//        var reviewToSave1 = recipe.foodbar.entities.Review.builder()
//                .author(user2)
//                .id(recipeToSave1.getId())
//                .title("Great Recipe")
//                .text("I cooked this for thanks giving and it was amazing");
//
//        // Create a user
//        var actualCreateUser = createUser.create(user1);
//        System.out.println("User created with id " + actualCreateUser.getId());
//
//        // Find a user by id
//        var actualFindUser = findUser.findById(actualCreateUser.getId());
//        System.out.println("Found user with id " + actualFindUser.get().getId());
//
//        // List all users
//        var users = findUser.findAllUsers();
//        System.out.println("List all users: " + users);
//
//        // Login
//        loginUser.login("john.doe@gmail.com", "mypassword");
//        System.out.println("Allowed to login with email 'john.doe@gmail.com' and password  'mypassword'");
//
//        // Create a cuisine
//        var cuisine = createCusine.create(italianCusine);

        // Create a recipe
//        var recipe1 = createRecipe.create(recipeToSave1);
//        var recipe2 = createRecipe.create(recipeToSave2);

        // Create a review
//        createRecipe
    }
}