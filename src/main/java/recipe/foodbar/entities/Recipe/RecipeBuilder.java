package recipe.foodbar.entities.Recipe;

import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.UserExample;

import java.util.ArrayList;
import java.util.Date;

public class RecipeBuilder {
    private String id;
    private String title;
    private UserExample author;
    private float portionSize;
    private String[] instructions;
    private String cuisine;
    private String[] dietaryRestrictions;
    private Date dateCreated;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Review> reviews;

    public RecipeBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public RecipeBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public RecipeBuilder setAuthor(UserExample author) {
        this.author = author;
        return this;
    }

    public RecipeBuilder setPortionSize(float portionSize) {
        this.portionSize = portionSize;
        return this;
    }

    public RecipeBuilder setInstructions(String[] instructions) {
        this.instructions = instructions;
        return this;
    }

    public RecipeBuilder setCuisine(String cuisine) {
        this.cuisine = cuisine;
        return this;
    }

    public RecipeBuilder setDietaryRestrictions(String[] dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
        return this;
    }

    public RecipeBuilder setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public RecipeBuilder setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public RecipeBuilder setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Recipe createRecipe() {
        return new Recipe(id, title, author, portionSize, instructions, cuisine, dietaryRestrictions, dateCreated, ingredients, reviews);
    }
}