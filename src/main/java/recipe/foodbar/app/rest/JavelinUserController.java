package recipe.foodbar.app.rest;

import io.javalin.http.Handler;

public class JavelinUserController {

//    private final UserController controller;
//
//    public JavelinUserController(UserController controller) {
//        this.controller = controller;
//    }

    public static Handler getUser = ctx -> {
        System.out.println("createUser is called");
        ctx.json(ctx.cookie("session"));
    };
    public static Handler createUser = ctx -> {
        System.out.println("createUser is called");
        System.out.println("Cookie is set");
        ctx.cookie("session", "dfjsdlkfjsdkf", 4 * 60 * 60 * 1000);
    };
}
