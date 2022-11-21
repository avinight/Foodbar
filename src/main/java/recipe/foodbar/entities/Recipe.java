package recipe.foodbar.entities;

import java.util.ArrayList;
import java.util.Date;


public class Recipe {

    private final String id;
    private final String title;
    private final UserExample author;
    private final float portionSize;
    private final String[] instructions;
    private final String cuisineId;
    private final String[] dietaryRestrictions;
    private final Date dateCreated;
    private int likes;
    private int dislikes;
    private ArrayList<Review> reviews;
    // private Ingredient ingredients;


    private Recipe(String id, String title, final UserExample author, float portionSize, String[] instructions, String cuisineId, String[] dietaryRestrictions, final Date dateCreated) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.portionSize = portionSize;
        this.instructions = instructions;
        this.cuisineId = cuisineId;
        this.likes = 0;
        this.dislikes = 0;
        this.dietaryRestrictions = dietaryRestrictions;
        this.dateCreated = dateCreated;
        this.reviews = new ArrayList<>();
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

    public UserExample getAuthor() {
        return author;
    }

    public float getPortionSize() {
        return portionSize;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public String getCuisineId() {
        return cuisineId;
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

    public void addReview(Review newReview) {
        this.reviews.add(newReview);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title = " + title + '\'' +
                ", id = " + id + '\'' +
                ", author = " + author + '\'' +
                ", cuisineId = " + cuisineId + '\'' +
                ", likes = " + likes + '\'' +
                ", dislikes = " + dislikes + '\'' +
                "}";
    }

//    public void addReview(Review newReview) {
//        //pass
//    }

    public static class RecipeBuilder {

        private String id;
        private String title;
        private UserExample author;
        private float portionSize;
        private String[] instructions;
        private String cuisineId;
        private int likes;
        private int dislikes;
        private String[] dietaryRestrictions;
        private Date dateCreated;

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

        public RecipeBuilder author(final UserExample author) {
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

        public RecipeBuilder cuisineId(final String cuisineId) {
            this.cuisineId = cuisineId;
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

        public Recipe build() {
            return new Recipe(id, title, author, portionSize, instructions, cuisineId, dietaryRestrictions, dateCreated);
        }
    }
}
