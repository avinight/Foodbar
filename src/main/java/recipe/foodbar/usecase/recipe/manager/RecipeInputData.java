package recipe.foodbar.usecase.recipe.manager;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

public class RecipeInputData {
    private final String title;
    private final User author;
    private final float portionSize;
    private final String[] instructions;
    private final Cuisine cuisine;
    private final String[] dietaryRestrictions;
    private final Date dateCreated;
    private final ArrayList<Ingredient> ingredients;
    private final ArrayList<String> likers;
    private final ArrayList<String> dislikers;
    private final ArrayList<Review> reviews;

    public RecipeInputData(String title, final User author, float portionSize, String[] instructions,
                           Cuisine cuisine, String[] dietaryRestrictions, final Date dateCreated,
                           ArrayList<Ingredient> ingredients, ArrayList<String> likers, ArrayList<String> dislikers,
                           ArrayList<Review> reviews) {
        this.title = title;
        this.author = author;
        this.portionSize = portionSize;
        this.instructions = instructions;
        this.cuisine = cuisine;
        this.dietaryRestrictions = dietaryRestrictions;
        this.dateCreated = dateCreated;
        this.ingredients = ingredients;
        this.likers = likers;
        this.dislikers = dislikers;
        this.reviews = reviews;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public float getPortionSize() {
        return portionSize;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public String[] getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getLikers() {
        return likers;
    }

    public ArrayList<String> getDislikers() {
        return dislikers;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }
}
