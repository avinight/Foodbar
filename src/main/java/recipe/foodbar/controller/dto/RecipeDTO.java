package recipe.foodbar.controller.dto;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

public class RecipeDTO {
    private String id;
    private String title;
    private String userId;
    private float portionSize;
    private ArrayList<String> instructions;
    private Cuisine cuisine;
    private int likes;
    private int dislikes;
    private ArrayList<String> dietaryRestrictions;
    private Date dateCreated;
    private Review[] reviews;
//    private Ingredient[] ingredients

    public static RecipeDTO toRecipeDTO(final Recipe recipe) {
        var userWeb = new RecipeDTO();
        userWeb.setId(recipe.getId());
        userWeb.setTitle(recipe.getTitle());
        userWeb.setAuthor(recipe.getAuthor());
        userWeb.setPortionSize(recipe.getPortionSize());
        userWeb.setInstructions(recipe.getInstructions());
        userWeb.setCuisine(recipe.getCuisine());
        userWeb.setDietaryRestrictions(recipe.getDietaryRestrictions());
        userWeb.setDateCreated(recipe.getDateCreated());
        return userWeb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return userId;
    }

    public void setAuthor(String authorId) {
        this.userId = authorId;
    }

    public float getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(float portionSize) {
        this.portionSize = portionSize;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }

    public Cuisine getcuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
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

    public ArrayList<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(ArrayList<String> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Recipe toRecipe() {
        return Recipe.builder()
                .id(id)
                .title(title)
                .author(userId)
                .portionSize(portionSize)
                .instructions(instructions)
                .cuisine(cuisine)
                .dietaryRestrictions(dietaryRestrictions)
                .dateCreated(dateCreated)
                .build();
    }
}
