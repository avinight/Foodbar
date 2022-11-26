package recipe.foodbar.usecase.recipe.ds;

import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

public class RecipeRequestModel {
    private final String id;
    private final String title;
    private final User author;
    private final String[] instructions;
    private final String cuisineId;
    private final String[] dietaryRestrictions;
    private final Date dateCreated;
    private final float portionSize;
    private int likes;
    private int dislikes;
    private final ArrayList<Review> reviews;
    private final ArrayList<Ingredient> ingredients;
    public RecipeRequestModel(String id,
                              String title,
                              final User author,
                              float portionSize,
                              String[] instructions,
                              String cuisineId,
                              String[] dietaryRestrictions,
                              final Date dateCreated,
                              ArrayList<Ingredient> ingredients,
                              ArrayList<Review> reviews){

        this.id = id;
        this.title = title;
        this.author = author;
        this.portionSize = portionSize;
        this.instructions = instructions;
        this.cuisineId = cuisineId;
        this.dietaryRestrictions = dietaryRestrictions;
        this.dateCreated = dateCreated;
        this.ingredients = ingredients;
        this.reviews = reviews;

    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCuisineId() {
        return cuisineId;
    }

    public User getAuthor() {
        return author;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public String[] getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public float getPortionSize() {
        return portionSize;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

}
