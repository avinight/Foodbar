package recipe.foodbar.app.rest;

import io.javalin.Javalin;
import recipe.foodbar.config.JavelinConfig;

public class JavelinApplication {

    private final JavelinConfig javelinConfig = new JavelinConfig();
//    private final UserController userController = new UserController(javelinConfig.createUser(), javelinConfig.findUser(), javelinConfig.loginUser());
//    private final VertxUserController controller = new VertxUserController(userController);

    public static void main(String[] args) {
        var app = Javalin.create(/*config*/).get("/", ctx -> ctx.result("Hello World")).start(8080);

//        app.get("hello", ctx -> ctx.html("Hello World"));

//        User
        app.get("/user", JavelinUserController.getUser);
        app.post("/user", JavelinUserController.createUser);

//        Recipe
//        app.get("/user", JavelinUserController.getUser);
//        app.post("/user", JavelinUserController.createUser);
    }
}
