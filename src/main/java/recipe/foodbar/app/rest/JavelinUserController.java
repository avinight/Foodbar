package recipe.foodbar.app.rest;

import io.javalin.http.Handler;
import io.javalin.http.UnauthorizedResponse;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.controller.user.login.UserLoginController;
import recipe.foodbar.controller.user.logout.UserLogoutController;
import recipe.foodbar.usecase.user.UserInputData;
import recipe.foodbar.usecase.userLogin.UserLoginInput;
import recipe.foodbar.usecase.userLogout.UserLogoutInput;

public class JavelinUserController {

    private static AccountController accountController;
    private static UserLoginController userLoginController;
    private static UserLogoutController userLogoutController;

    public JavelinUserController(AccountController accountController, UserLoginController userLoginController, UserLogoutController userLogoutController) {
        JavelinUserController.accountController = accountController;
        JavelinUserController.userLoginController = userLoginController;
        JavelinUserController.userLogoutController = userLogoutController;
    }

    public static Handler createUser = ctx -> {
        UserInputData user = ctx.bodyAsClass(UserInputData.class);
        String creationStatus = accountController.data.create(user);
        System.out.println(creationStatus);
        ctx.json(creationStatus);
    };

    public static Handler loginUser = ctx -> {
        UserLoginInput userLoginInput = ctx.bodyAsClass(UserLoginInput.class);
        String loginStatus = userLoginController.data.login(userLoginInput);
        System.out.println(loginStatus);
        switch (loginStatus) {
            case "login Failed: Invalid Password", "login Failed: User Does Not Exist" ->
                    throw new UnauthorizedResponse(loginStatus);
            default -> ctx.cookie("session", loginStatus, 4 * 60 * 60 * 1000);
        }
    };

    public static Handler logoutUser = ctx -> {
        String logoutStatus = userLogoutController.data.logout(new UserLogoutInput(ctx.cookie("session")));
        ctx.removeCookie("session");
        System.out.println(logoutStatus);
    };
}
