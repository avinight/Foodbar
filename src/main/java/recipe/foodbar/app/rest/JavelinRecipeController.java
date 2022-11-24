package recipe.foodbar.app.rest;

import io.javalin.http.Handler;

public class JavelinRecipeController {
    public static Handler getRecipe = ctx -> {
        System.out.println("createUser is called");
        ctx.json(ctx.cookie("session"));
    };
    public static Handler createRecipe = ctx -> {
        System.out.println("createUser is called");
        System.out.println("Cookie is set");
        ctx.cookie("session", "dfjsdlkfjsdkf", 4 * 60 * 60 * 1000);
    };
}
