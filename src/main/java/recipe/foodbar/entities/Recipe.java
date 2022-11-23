package recipe.foodbar.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class Recipe {
    private final String id;
    private final String title;
    private final UserExample author;
    private final String[] instructions;
    private final String cuisineId;
    private final String[] dietaryRestrictions;
    private final Date dateCreated;
    private float portionSize;
    private int likes;
    private int dislikes;
    private final ArrayList<Review> reviews;
    private final ArrayList<Ingredient> ingredients;

    /**
     * Constructs a Recipe with id, title, author, portionSize, instructions, cuisine, dietaryRestrictions, dateCreated,
     * ingredients, and reviews.
     *
     * @param id                    The id of the recipe.
     * @param title                 The title of the recipe.
     * @param author                The author of the recipe.
     * @param portionSize           The portion size of the recipe.
     * @param instructions          The instructions of the recipe.
     * @param cuisine               The cuisine of the recipe.
     * @param dietaryRestrictions   The dietary restrictions of the recipe.
     * @param dateCreated           The date the recipe was created.
     * @param ingredients           The ingredients of the recipe.
     * @param reviews               The reviews of the recipe.
     */
    private Recipe(String id, String title, final UserExample author, float portionSize, String[] instructions,
                   String cuisine, String[] dietaryRestrictions, final Date dateCreated,
                   ArrayList<Ingredient> ingredients, ArrayList<Review> reviews) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.portionSize = portionSize;
        this.instructions = instructions;
        this.cuisineId = cuisine;
        this.ingredients = ingredients;
        this.likes = 0;
        this.dislikes = 0;
        this.dietaryRestrictions = dietaryRestrictions;
        this.dateCreated = dateCreated;
        this.reviews = new ArrayList<>();
    }

    public static RecipeBuilder builder() {
        return new RecipeBuilder();
    }

    /**
     * Returns the id of the recipe.
     *
     * @return the id of the recipe.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the title of the recipe.
     *
     * @return the title of the recipe.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the recipe.
     *
     * @return the author of the recipe.
     */
    public UserExample getAuthor() {
        return author;
    }

    /**
     * Returns the portion size of the recipe.
     *
     * @return the portionSize of the recipe.
     */
    public float getPortionSize() {
        return portionSize;
    }

    /**
     * Returns the instructions of the recipe.
     *
     * @return the instructions of the recipe.
     */
    public String[] getInstructions() {
        return instructions;
    }

    /**
     * Returns the cuisineId of the recipe.
     *
     * @return the cuisineId of the recipe.
     */
    public String getCuisineId() {
        return cuisineId;
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

    /**
     * Adds a like to the recipe.
     *
     */
    public void like() {
        likes += 1;
    }

    /**
     * Unlikes the recipe.
     *
     */
    public void unlike() {
        likes -= 1;
    }

    /**
     * Adds a dislike to the recipe
     */
    public void dislike() {
        dislikes += 1;
    }

    /**
     * Undislikes the recipe.
     */
    public void undislike() {
        dislikes -= 1;
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
    @Override
    public String toString() {
        return "Recipe{" + "title = " + title + '\'' + ", id = " + id + '\'' + ", author = " + author + '\'' + ", cuisineId = " + cuisineId + '\'' + ", likes = " + likes + '\'' + ", dislikes = " + dislikes + '\'' + ", review = " + reviews + '\'' + "}";
    }


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

        public RecipeBuilder ingredients(final ArrayList<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public RecipeBuilder review(final ArrayList<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public Recipe build() {
            return new Recipe(id,
                    title,
                    author,
                    portionSize,
                    instructions,
                    cuisineId,
                    dietaryRestrictions,
                    dateCreated,
                    ingredients,
                    reviews
            );
        }
    }
}
