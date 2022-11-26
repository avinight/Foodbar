package recipe.foodbar.usecase.recipe.manager.edit;

import recipe.foodbar.entities.Ingredient.Ingredient;
import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.presenter.RecipePresenter;
import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.ds.RecipeResponseModel;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

/**
 * This interactor is responsible for performing all direct interactions with the Recipe entity class.
 */
public class RecipeEditor implements IRecipeEditor {
    private final RecipeRepository recipeRepo;
    private final RecipePresenter rp;

    /* TODO: Make this take in request model and output response model and depend on output boundary
     */

    /**
     * Constructor for the RecipeEditor class, initializes a RecipeEditor.
     *
     * @param recipeRepo The gateway.
     * @param rp         the presenter.
     */
    public RecipeEditor(RecipeRepository recipeRepo, RecipePresenter rp) {
        this.recipeRepo = recipeRepo;
        this.rp = rp;
    }

    /**
     * Edits the portionSize of a Recipe object.
     *
     * @param rm The request model.
     */
    @Override
    public void editPortionSize(RecipeRequestModel rm) {
        /* Must check that the id exists and is valid, otherwise throw an exception*/
        recipeRepo.findById(rm._id()).get().modifyIngredients((int) rm.portionSize());

        /* Create a response model and display */
        rp.displayEdited(RecipeResponseModel.ResponseDataType.EDIT);
    }

    /**
     * Edits the title of a Recipe object.
     *
     * @param rm The request model.
     */
    @Override
    public void editTitle(RecipeRequestModel rm) {
        recipeRepo.findById(rm._id()).get().setTitle(rm.title());
    }

    /**
     * Edits the cuisine of a Recipe object.
     *
     * @param rm The request model.
     */
    @Override
    public void editCuisine(RecipeRequestModel rm) {
        recipeRepo.findById(rm._id()).get().setCuisine(rm.cuisine());
    }

    /**
     * Edits the dietary restrictions of a Recipe object.
     *
     * @param rm The request model.
     */
    @Override
    public void editDietaryRestrictions(RecipeRequestModel rm) {
        recipeRepo.findById(rm._id()).get().setDietaryRestrictions(rm.dietaryRestrictions());
    }

    /**
     * Edits the ingredients of a Recipe object.
     *
     * @param rm The request model.
     */
    @Override
    public boolean editIngredients(RecipeRequestModel rm) {
        Recipe rr = recipeRepo.findById(rm._id()).get();
        for (Ingredient ingredient : rm.ingredients()){
            if (!rr.getIngredients().contains(ingredient) && rm.ingredients().contains(ingredient)) {
                rr.addIngredient(ingredient);
            } else if (rr.getIngredients().contains(ingredient) && !rm.ingredients().contains(ingredient)) {
                rr.removeIngredient(ingredient);
            }
        }
        return true;
    }
    @Override
    public boolean editInstructions(RecipeRequestModel rm) {
        Recipe rr = recipeRepo.findById(rm._id()).get();

        return true;
    }


    /*
    TODO: not sure if i need to return edited recipe, boolean to the presenter or something else.
     */
}
