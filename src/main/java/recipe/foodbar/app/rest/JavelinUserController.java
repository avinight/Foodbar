package recipe.foodbar.app.rest;

import io.javalin.http.Handler;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.usecase.user.UserInputData;

public class JavelinUserController {

    private static AccountController controller;

    public JavelinUserController(AccountController controller) {
        this.controller = controller;
    }

    public static Handler getUser = ctx -> {
        System.out.println("createUser is called");
//        ctx.json(ctx.cookie("session"));
    };
    public static Handler createUser = ctx -> {
        UserInputData user = ctx.bodyAsClass(UserInputData.class);
        String creationStatus = controller.data.create(user);
        System.out.println(creationStatus);
        ctx.json(creationStatus);
//        ctx.cookie("session", "dfjsdlkfjsdkf", 4 * 60 * 60 * 1000);
    };

    public static Handler loginUser = ctx -> {

    }
}
