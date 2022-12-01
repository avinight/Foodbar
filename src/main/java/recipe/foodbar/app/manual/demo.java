package recipe.foodbar.app.manual;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.entities.Recipe.RecipeBuilder;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

public class demo {
    public static void main(String[] args) {
        User junaid = new User("001", "arshadju", "P@ssw0rd!", "Junaid", "Arshad", "junaid.arshad@mail.utoronto.ca");
        User gigajunaid = new User("002", "gigaarshadju", "P@ssw0rd!", "Gigajunaid", "Gigaarshad", "gigajunaid@yomomma.co.uk");
        String[] instr = new String[]{"Cut the potatoes", "do the rest idk"};
        String[] dr = new String[]{"Vegan", "Halal"};
        Cuisine cui = new Cuisine("Indian", "1");
        ArrayList<Ingredient> ing = new ArrayList<>();
        Ingredient ing1 = new Ingredient("Potatoes", 69);
        ing.add(ing1);
        Recipe curry = new Recipe("001", "Aloo Curry", junaid, 1, instr, cui, dr, new Date(), ing, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<Review>());

        // Use builder rather than constructor so that unnecessary inputs aren't required

        System.out.println(junaid);
        System.out.println(gigajunaid);
        System.out.println(curry);
        curry.like("002");
        System.out.println("Curry rating :" + curry.getRating());
        curry.like("002");
        System.out.println("Curry rating :" + curry.getRating());
        curry.like("002");
        curry.dislike("002");
        System.out.println("Curry rating :" + curry.getRating());


    }

}


