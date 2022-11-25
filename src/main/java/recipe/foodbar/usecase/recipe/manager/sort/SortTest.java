package recipe.foodbar.usecase.recipe.manager.sort;

import org.junit.Before;
import org.junit.Test;
import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.presenter.RecipePresenter;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

import java.time.ZoneId;
import java.time.LocalDate;
import java.util.*;

public class SortTest {
    RecipeSorter rs;
    List<Recipe> rlst;
    Comparator<Recipe> comparator;
    RecipeRepository recipeRepo;
    RecipePresenter rp;
    @Before
    public void setUp() {rs = new RecipeSorter(recipeRepo, rp);}

    @Test
    public void testSortBy() {
        rlst = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//        var user1 = recipe.foodbar.entities.UserExample.builder()
//                .email("john.doe@gmail.com")
//                .password("mypassword")
//                .lastName("doe")
//                .firstName("john")
//                .build();

        var italianCuisine = recipe.foodbar.entities.Cuisine.builder()
                .name("Italian")
                .build();

        var frenchCuisine = recipe.foodbar.entities.Cuisine.builder()
                .name("French")
                .build();

        var pastaDough = recipe.foodbar.entities.Ingredient.builder()
                .name("Basic Egg Pasta Dough")
                .size(1)
                .build();

        var cheese = recipe.foodbar.entities.Ingredient.builder()
                .name("Parmigiano Reggiano")
                .size(1.25F)
                .build();

//        var recipe1 = Recipe.builder()
//                .author(user1)
//                .cuisineId(italianCuisine.getName())
//                .title("Ravioli di Zucca")
//                .dateCreated(date)
//                .portionSize(4)
//                .ingredients(new ArrayList<>(Arrays.asList(pastaDough, cheese)))
//                .build();

//        var recipe2 = Recipe.builder()
//                .author(user1)
//                .cuisineId(italianCuisine.getName())
//                .title("pee")
//                .dateCreated(date)
//                .portionSize(4)
//                .ingredients(new ArrayList<>(Arrays.asList(pastaDough, cheese)))
//                .build();

//        var recipe3 = Recipe.builder()
//                .author(user1)
//                .cuisineId(frenchCuisine.getName())
//                .title("poo")
//                .dateCreated(date)
//                .portionSize(4)
//                .ingredients(new ArrayList<>(Arrays.asList(pastaDough, cheese)))
//                .build();
//
//        recipe1.like();
//        recipe1.like();
//        recipe3.like();
//
//        rlst.add(recipe1);
//        rlst.add(recipe2);
//        rlst.add(recipe3);
//        System.out.println(rlst);
//        rs.sortBy(rlst);
//        System.out.println(rlst);

    }
}
