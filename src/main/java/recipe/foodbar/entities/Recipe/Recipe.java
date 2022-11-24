package recipe.foodbar.entities.Recipe;

import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.UserExample;

import java.util.ArrayList;
import java.util.Date;

/**
 * The recipe class.
 */
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
    Recipe(String id, String title, final UserExample author, float portionSize, String[] instructions,
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
}
