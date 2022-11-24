package recipe.foodbar.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class Recipe {

    private final String id;
    private final String title;
    private final User author;
    private final String[] instructions;
    private final Cuisine cuisine;
    private final String[] dietaryRestrictions;
    private final Date dateCreated;
    private float portionSize;
    private int likes;
    private int dislikes;
    private final ArrayList<Review> reviews;
    private final ArrayList<Ingredient> ingredients;

    public Recipe(String id, String title, User author, String[] instructions, Cuisine cuisine, String[] dietaryRestrictions, Date dateCreated, float portionSize, int likes, int dislikes, ArrayList<Review> reviews, ArrayList<Ingredient> ingredients) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.instructions = instructions;
        this.cuisine = cuisine;
        this.dietaryRestrictions = dietaryRestrictions;
        this.dateCreated = dateCreated;
        this.portionSize = portionSize;
        this.likes = likes;
        this.dislikes = dislikes;
        this.reviews = reviews;
        this.ingredients = ingredients;
    }

    public static RecipeBuilder builder() {
        return new RecipeBuilder();
    }

    public String getId() {
        return id;
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

    public void like() {
        likes += 1;
    }

    public void unlike() {
        likes -= 1;
    }

    public void dislike() {
        dislikes += 1;
    }

    public void undislike() {
        dislikes -= 1;
    }

    public int getRating() {
        return likes - dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
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

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "Recipe{" + "title = " + title + '\'' + ", id = " + id + '\'' + ", author = " + author + '\'' + ", cuisineId = " + cuisine + '\'' + ", likes = " + likes + '\'' + ", dislikes = " + dislikes + '\'' + ", review = " + reviews + '\'' + "}";
    }

    /**
     * Sets the portionSize and
     * modifies each ingredient based on the portionSize multiplier.
     *
     * @param portionSize The portion size of the Recipe.
     */
    public void modifyIngredients(int portionSize) {
        this.portionSize = portionSize;
        for (Ingredient ingredient : ingredients) {
            ingredient.setSize(portionSize * ingredient.getSize());
        }
    }

    /**
     * Adds new ingredients to the ingredients ArrayList.
     *
     * @param ingredient An ingredient.
     */
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public static class RecipeBuilder {

        private String id;
        private String title;
        private User author;
        private float portionSize;
        private String[] instructions;
        private Cuisine cuisine;
        private int likes;
        private int dislikes;
        private String[] dietaryRestrictions;
        private Date dateCreated;
        private ArrayList<Ingredient> ingredients;
        private ArrayList<Review> reviews;

        RecipeBuilder() {
        }

        public RecipeBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public RecipeBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public RecipeBuilder author(final User author) {
            this.author = author;
            return this;
        }

        public RecipeBuilder portionSize(final float portionSize) {
            this.portionSize = portionSize;
            return this;
        }

        public RecipeBuilder instructions(final String[] instructions) {
            this.instructions = instructions;
            return this;
        }

        public RecipeBuilder cuisine(final Cuisine cusine) {
            this.cuisine = cusine;
            return this;
        }

        public RecipeBuilder dietaryRestrictions(final String[] dietaryRestrictions) {
            this.dietaryRestrictions = dietaryRestrictions;
            return this;
        }

        public RecipeBuilder dateCreated(final Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public RecipeBuilder ingredients(final ArrayList<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public RecipeBuilder review(final ArrayList<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public Recipe build() {
            return new Recipe(id, title, author, instructions, cuisine, dietaryRestrictions, dateCreated, portionSize, likes, dislikes, reviews, ingredients);
        }
    }
}
