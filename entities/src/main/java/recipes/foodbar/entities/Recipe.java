package recipes.foodbar.entities;

import java.util.ArrayList;
import java.util.Date;

public class Recipe {
    private String title;
    private User author;
    private float portionSize;
    private String[] instructions;
    private String cuisine;
    private int likes;
    private int dislikes;
    private String[] dietaryRestrictions;
    private Date dateCreated;
    // private Review[] reviews;
    private ArrayList<Ingredient> ingredients;


    private Recipe(String title, final User author, float portionSize, String[] instructions, String cuisine, String[] dietaryRestrictions, final Date dateCreated, ArrayList<Ingredient> ingredients) {
        this.title = title;
        this.author = author;
        this.portionSize = portionSize;
        this.instructions = instructions;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.likes = 0;
        this.dislikes = 0;
        this.dietaryRestrictions = dietaryRestrictions;
        this.dateCreated = dateCreated;
    }

    public static RecipeBuilder builder() { return new RecipeBuilder();}

    public static class RecipeBuilder {
        private String title;
        private User author;
        private float portionSize;
        private String[] instructions;
        private String cuisine;
        private int likes;
        private int dislikes;
        private String[] dietaryRestrictions;
        private Date dateCreated;
        private ArrayList<Ingredient> ingredients;

        RecipeBuilder() {}

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

        public RecipeBuilder cuisine(final String cuisine) {
            this.cuisine = cuisine;
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

        public RecipeBuilder ingredients(final ArrayList<Ingredient> ingredients){
            this.ingredients = ingredients;
            return this;
        }

        public Recipe build() {
            return new Recipe(title, author, portionSize, instructions, cuisine, dietaryRestrictions, dateCreated, ingredients);
        }
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

    public String getCuisine() {
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
        dislikes -=1 ;
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

//    public void addReview(Review newReview) {
//        //pass
//    }

    /**
     * Sets the portionSize and
     * modifies each ingredient based on the portionSize multiplier.
     * @param portionSize   The portion size of the Recipe.
     */
    public void modifyIngredients(int portionSize){
        this.portionSize = portionSize;
        for (Ingredient ingredient : ingredients){
            ingredient.setSize(portionSize * ingredient.getSize());
        }
    }

    /**
     * Adds new ingredients to the ingredients ArrayList.
     * @param ingredient    An ingredient.
     */
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title = " + title + '\'' +
                ", author = " + author + '\'' +
                ", cuisine = " + cuisine + '\'' +
                ", likes = " + likes + '\'' +
                ", dislikes = " + dislikes + '\'' +
                "}";
    }
}
