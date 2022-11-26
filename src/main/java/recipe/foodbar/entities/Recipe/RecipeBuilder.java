package recipe.foodbar.entities.Recipe;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

public class RecipeBuilder {
    private String id;
    private String title;
    private User author;
    private float portionSize;
    private String[] instructions;
    private Cuisine cuisine;
    private String[] dietaryRestrictions;
    private Date dateCreated;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Review> reviews;
    private int likes;
    private int dislikes;

    public RecipeBuilder id(String id) {
        this.id = id;
        return this;
    }

    public RecipeBuilder title(String title) {
        this.title = title;
        return this;
    }

    public RecipeBuilder author(User author) {
        this.author = author;
        return this;
    }

    public RecipeBuilder portionSize(float portionSize) {
        this.portionSize = portionSize;
        return this;
    }

    public RecipeBuilder instructions(String[] instructions) {
        this.instructions = instructions;
        return this;
    }

    public RecipeBuilder cuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
        return this;
    }

    public RecipeBuilder dietaryRestrictions(String[] dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
        return this;
    }

    public RecipeBuilder dateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public RecipeBuilder ingredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public RecipeBuilder reviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Recipe createRecipe() {
        return new Recipe(id, title, author, portionSize, instructions, cuisine, dietaryRestrictions, dateCreated, ingredients, reviews, likes, dislikes);
    }
}