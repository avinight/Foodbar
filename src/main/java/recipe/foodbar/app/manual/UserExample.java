package recipe.foodbar.app.manual;

//import recipe.foodbar.config.ManualConfig;
import recipe.foodbar.usecase.recipe.exception.RecipeAlreadyExistsException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class UserExample {
    public static void main(String[] args) throws RecipeAlreadyExistsException {
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