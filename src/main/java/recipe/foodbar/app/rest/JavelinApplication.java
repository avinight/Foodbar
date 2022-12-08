package recipe.foodbar.app.rest;

import io.javalin.Javalin;
import recipe.foodbar.config.JavelinConfig;

public class JavelinApplication {
//    private final UserController userController = new UserController(javelinConfig.createUser(), javelinConfig.findUser(), javelinConfig.loginUser());
//    private final VertxUserController controller = new VertxUserController(userController);

    public static void main(String[] args) {
        JavelinConfig javelinConfig = new JavelinConfig();
        JavelinUserController userController = new JavelinUserController(javelinConfig.getAccountController());
        var app = Javalin.create().get("/", ctx -> ctx.result("Hello World!")).start(8080);

//        app.get("hello", ctx -> ctx.html("Hello World"));

//        User
//        app.get("/user", JavelinUserController.getUser);
        app.post("/register", userController.createUser);
        app.post("/login", userController.)

//        Recipe
//        app.get("/user", javelinUserController.getUser);
//        app.post("/user", JavelinUserController.createUser);
    }
}
