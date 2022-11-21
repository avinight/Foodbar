package recipe.foodbar.app.manual;

import recipe.foodbar.config.ManualConfig;

public class UserExample {
    public static void main(String[] args) {
        // Setup
        var config = new ManualConfig();
        var createUser = config.createUser();
        var findUser = config.findUser();
        var loginUser = config.loginUser();
        var user = recipe.foodbar.entities.UserExample.builder()
                .email("john.doe@gmail.com")
                .password("mypassword")
                .lastName("doe")
                .firstName("john")
                .build();

        // Create a user
        var actualCreateUser = createUser.create(user);
        System.out.println("User created with id " + actualCreateUser.getId());

        // Find a user by id
        var actualFindUser = findUser.findById(actualCreateUser.getId());
        System.out.println("Found user with id " + actualFindUser.get().getId());

        // List all users
        var users = findUser.findAllUsers();
        System.out.println("List all users: " + users);

        // Login
        loginUser.login("john.doe@gmail.com", "mypassword");
        System.out.println("Allowed to login with email 'john.doe@gmail.com' and password  'mypassword'");

//      // Create a cusine

    }
}