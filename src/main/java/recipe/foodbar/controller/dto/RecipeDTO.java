package recipe.foodbar.controller.dto;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.UserExample;

import java.time.LocalDate;

public class RecipeDTO {
    private String id;
    private String title;
    private UserExample author;
    private float portionSize;
    private String[] instructions;
    private Cuisine cuisine;
    private int likes;
    private int dislikes;
    private String[] dietaryRestrictions;
    private LocalDate dateCreated;
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

    public UserExample getAuthor() {
        return author;
    }

    public void setAuthor(UserExample author) {
        this.author = author;
    }

    public float getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(float portionSize) {
        this.portionSize = portionSize;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] instructions) {
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

    public String[] getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(String[] dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Recipe toRecipe() {
        return Recipe.builder()
                .id(id)
                .title(title)
                .author(author)
                .portionSize(portionSize)
                .instructions(instructions)
                .cuisine(cuisine)
                .dietaryRestrictions(dietaryRestrictions)
                .dateCreated(dateCreated)
                .build();
    }
}
