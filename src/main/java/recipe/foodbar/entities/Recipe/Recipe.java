package recipe.foodbar.entities.Recipe;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * The recipe class.
 */
public class Recipe {
    private final String id;
    private Cuisine cuisine;
    private final Date dateCreated;
    private final ArrayList<Review> reviews;
    private final ArrayList<Ingredient> ingredients;
    private String title;
    private User author;
    private String[] instructions;
    private String[] dietaryRestrictions;
    private float portionSize;
    private int likes;
    private int dislikes;

    /**
     * Constructs a Recipe with id, title, author, portionSize, instructions, cuisine, dietaryRestrictions, dateCreated,
     * ingredients, and reviews.
     *
     * @param id                  The id of the recipe.
     * @param title               The title of the recipe.
     * @param author              The author of the recipe.
     * @param portionSize         The portion size of the recipe.
     * @param instructions        The instructions of the recipe.
     * @param cuisine             The cuisine of the recipe.
     * @param dietaryRestrictions The dietary restrictions of the recipe.
     * @param dateCreated         The date the recipe was created.
     * @param ingredients         The ingredients of the recipe.
     * @param reviews             The reviews of the recipe.
     * @param likes               The count of likes for recipe
     * @param dislikes            The count of dislikes for recipe
     */
    public Recipe(String id, String title, final User author, float portionSize, String[] instructions,
           Cuisine cuisine, String[] dietaryRestrictions, final Date dateCreated,
           ArrayList<Ingredient> ingredients, ArrayList<Review> reviews, int likes, int dislikes) {
        this.id = id;
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
        this.reviews = reviews;
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

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the author of the recipe.
     *
     * @return the author of the recipe.
     */
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User ue) {
        this.author = ue;
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
     * Returns the instructions of the recipe.
     *
     * @return the instructions of the recipe.
     */
    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] i) {
        this.instructions = i;
    }

    /**
     * Returns the cuisine of the recipe.
     *
     * @return the cuisine of the recipe.
     */
    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) { this.cuisine = cuisine; }
    /**
     * Returns the rating of the recipe.
     *
     * @return int likes - dislikes
     */
    public int getRating() {
        return likes - dislikes;
    }

    /**
     * Returns the likes of the recipe.
     *
     * @return int likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Returns the dislikes of the recipe.
     *
     * @return int dislikes
     */
    public int getDislikes() {
        return dislikes;
    }

    /**
     * Returns the dietary restrictions of the recipe.
     *
     * @return String[]
     */
    public String[] getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    /**
     * Sets the dietary restrictions of the recipe.
     *
     * @param dr    Dietary Restrictions.
     */
    public void setDietaryRestrictions(String[] dr) {
        this.dietaryRestrictions = dr;
    }

    /**
     * Returns the date this recipe was created.
     *
     * @return Date
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Returns this recipe's ingredients.
     *
     * @return ArrayList<Ingredient>
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Returns this recipe's reviews.
     *
     * @return ArrayList<Review>
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }


    /**
     * Adds a like to the recipe.
     */
    public void like() {
        likes += 1;
    }

    /**
     * Unlikes the recipe.
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
     * Adds new ingredients to the ingredients ArrayList.
     *
     * @param ingredient An ingredient.
     */
    public boolean addIngredient(Ingredient ingredient) {
        if (this.ingredients.contains(ingredient)) {
            return true;
        } else {
            this.ingredients.add(ingredient);
            return false;
        }
    }

    /**
     * Removes ingredient from ingredients ArrayList.
     *
     * @param ingredient An ingredient.
     */
    public boolean removeIngredient(Ingredient ingredient) {
        if (this.ingredients.contains(ingredient)) {
            this.ingredients.remove(ingredient);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return a string representation of this Recipe.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Recipe{" + "title = " + title + '\'' + ", id = " + id + '\'' + ", author = " + author + '\'' + ", cuisineId = " + cuisine + '\'' + ", likes = " + likes + '\'' + ", dislikes = " + dislikes + '\'' + ", review = " + reviews + '\'' + "}";
    }

}
