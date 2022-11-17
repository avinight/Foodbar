package recipe.foodbar;

import recipe.foodbar.controller.AccountController;
import recipe.foodbar.controller.AccountPresenter;
import recipe.foodbar.entities.RegisteredUser;
import recipe.foodbar.usecase.*;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Test Account creation");
//
//        String username = "Arthur123";
//        String password = "123";
//        String firstName = "Arthur";
//        String lastName = "dog";
//        String password2 = "123";
//        String email = "a@gmail.com";
//        //username, password, password2, firstName, lastName, email
//        AccountPresenter accountPresenter = new AccountPresenter();
//        UserCreatorInputBoundary data = new UserManager(accountPresenter);
//        AccountController accountController = new AccountController(data);
//        UserInputData user = accountController.create(username, password, password2, firstName, lastName, email);
//
//        //presenter receives this data and returns the Username, along with successful creation message
//
//        //accountController.data.create(user);
//
//        System.out.println(accountController.data.create(user));
//        System.out.println(InMemoryUserRepository.findByUsername("Arthur123"));
//        System.out.println(InMemoryUserRepository.existsByUsername("Arthur123"));

        /********************************************************************
         *  Test account failure for missing firstname entry
         */
//
//        System.out.println("Test Account creation");
//
//        String username = "Arthur123";
//        String password = "123";
//        String firstName = null;
//        String lastName = "dog";
//        String password2 = "123";
//        String email = "a@gmail.com";
//        //username, password, password2, firstName, lastName, email
//        AccountPresenter accountPresenter = new AccountPresenter();
//        UserCreatorInputBoundary data = new UserManager(accountPresenter);
//        AccountController accountController = new AccountController(data);
//        UserInputData user = accountController.create(username, password, password2, firstName, lastName, email);
//
//        //presenter receives this data and returns the Username, along with successful creation message
//
//        //accountController.data.create(user);
//
//        System.out.println(accountController.data.create(user));
//        System.out.println(InMemoryUserRepository.findByUsername("Arthur123"));
//        System.out.println(InMemoryUserRepository.existsByUsername("Arthur123"));

        /**
         * Test creation of passwords not matching
         */
        System.out.println("Test Account creation");

        String username = "Arthur123";
        String password = "123";
        String firstName = "Arthur";
        String lastName = "dog";
        String password2 = "1234";
        String email = "a@gmail.com";
        //username, password, password2, firstName, lastName, email
        AccountPresenter accountPresenter = new AccountPresenter();
        UserCreatorInputBoundary data = new UserManager(accountPresenter);
        AccountController accountController = new AccountController(data);
        UserInputData user = accountController.create(username, password, password2, firstName, lastName, email);

        //presenter receives this data and returns the Username, along with successful creation message

        //accountController.data.create(user);

        System.out.println(accountController.data.create(user));
        System.out.println(InMemoryUserRepository.findByUsername("Arthur123"));
        System.out.println(InMemoryUserRepository.existsByUsername("Arthur123"));
    }
}
