package recipe.foodbar.usecase.recipe.manager.edit;

import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.presenter.RecipePresenter;
import recipe.foodbar.repository.mongo.mapper.RecipeMapper;
import recipe.foodbar.repository.mongo.model.RecipeModel;
import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.ds.RecipeResponseModel;
import recipe.foodbar.usecase.recipe.manager.edit.IRecipeEditor;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

/**
 * This class is responsible for performing all direct interactions with the Recipe entity class.
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
    public void editPortionSize(RecipeModel rm) {
        /* Must check that the id exists and is valid, otherwise throw an exception*/
        recipeRepo.findById(rm.get_id()).get().modifyIngredients((int) rm.getPortionSize());

        /* Create a response model and display */
        rp.displayEdited(RecipeResponseModel.ResponseDataType.EDIT);
    }

    public void editTitle(RecipeModel rm) {
        recipeRepo.findById(rm.get_id()).get().setTitle(rm.getTitle());
    }

    public void editCuisine(RecipeModel rm) {
        recipeRepo.findById(rm.get_id()).get().setCuisine(rm.getCuisine());
    }

    public void editDietaryRestrictions(RecipeModel rm) {
        recipeRepo.findById(rm.get_id()).get().setDietaryRestrictions(rm.getDietaryRestrictions());
    }

    public void editIngredients(RecipeModel rm) {
        Recipe rr = recipeRepo.findById(rm.get_id()).get();
        for (Ingredient ingredient : rm.getIngredients()){
            if (!rr.getIngredients().contains(ingredient) && rm.getIngredients().contains(ingredient)) {
                rr.addIngredient(ingredient);
            } else if (!rr.getIngredients().contains(ingredient) && rm.getIngredients().contains(ingredient)) {
                rr.removeIngredient(ingredient);
            }

        }
    }

    @Override
    public void editPortionSize(RecipeRequestModel rrm) {

    }
}
