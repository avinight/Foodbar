package recipes.foodbar.entities;

import java.util.Arrays;
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
    // private Ingredient ingredients;

    // TODO: Constructor doesn't exist as we may be using a factory- look into how this will work
    // TODO: Review, User, and Ingredient classes yet to exist- need to create those so that attributes of this class can be
    //  added correctly
    // TODO: Implement the Shareable interface when that is created, and add the associated Share method
    // TODO: Likes and Dislikes need to be tracked on a per-user-like/dislike basis and not simply iterated or
    //  deiterated within the Recipe object

    private Recipe(String title, final User author, String[] instructions, String cuisine, String[] dietaryRestrictions, final Date dateCreated) {
        this.title = title;
        this.author = author;
        this.portionSize = portionSize;
        this.instructions = instructions;
        this.cuisine = cuisine;
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

        public RecipeBuilder likes(final int likes) {
            this.likes = likes;
            return this;
        }

        public RecipeBuilder dislikes(final int dislikes) {
            this.dislikes = dislikes;
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

    public String[] getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

//    public void addReview(Review newReview) {
//        //pass
//    }

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
