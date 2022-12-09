package recipe.foodbar.usecase.recipe.manager.edit;

import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.presenter.RecipePresenter;
import recipe.foodbar.repository.mongoDB.model.RecipeModel;
import recipe.foodbar.usecase.recipe.ds.RecipeEditedResponseModel;
import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

/**
 * This class is responsible for performing all direct interactions with the Recipe entity class.
 */

public class RecipeEditor implements IRecipeEditor {
    private final RecipeRepository recipeRepo;
    private final RecipePresenter rp;

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
        if(recipeRepo.findById(rm.getId()).isPresent()){
        recipeRepo.findById(rm.getId()).get().modifyIngredients((int) rm.getPortionSize()); }

        /* Create a response model and display */
        rp.displayEdited(RecipeEditedResponseModel.ResponseDataType.EDIT);
    }

    /**
     * Edits the title of a Recipe object.
     *
     * @param rm The request model.
     */
    @Override
    public void editTitle(RecipeRequestModel rm) {
        if(recipeRepo.findById(rm.getId()).isPresent()){
            recipeRepo.findById(rm.getId()).get().setTitle(rm.getTitle());
        }

    }

    /**
     * Edits the cuisine of a Recipe object.
     *
     * @param rm The request model.
     */
    @Override
    public void editCuisine(RecipeRequestModel rm) {
        if(recipeRepo.findById(rm.getId()).isPresent()){
            recipeRepo.findById(rm.getId()).get().setCuisine(rm.getCuisine());
        }
    }

    /**
     * Edits the dietary restrictions of a Recipe object.
     *
     * @param rm The request model.
     */
    @Override
    public void editDietaryRestrictions(RecipeRequestModel rm) {
        if(recipeRepo.findById(rm.getId()).isPresent()) {
            recipeRepo.findById(rm.getId()).get().setDietaryRestrictions(rm.getDietaryRestrictions());
        }
    }

    /**
     * Edits the ingredients of a Recipe object.
     *
     * @param rm The request model.
     */
    @Override
    public boolean editIngredients(RecipeRequestModel rm) {
        if(recipeRepo.findById(rm.getId()).isPresent()){
        Recipe rr = recipeRepo.findById(rm.getId().toString()).get();
        for (Ingredient ingredient : rm.getIngredients()){
            if (!rr.getIngredients().contains(ingredient) && rm.getIngredients().contains(ingredient)) {
                rr.addIngredient(ingredient);
            } else if (rr.getIngredients().contains(ingredient) && !rm.getIngredients().contains(ingredient)) {
                rr.removeIngredient(ingredient);
            }
        }
        return true;
        }
        return false;
    }

    /**
     * Edits the instructions of a Recipe object.
     *
     * @param rm the request model.
     * @return true if successfully edited instructions
     */
    @Override
    public boolean editInstructions(RecipeRequestModel rm) {
        if(recipeRepo.findById(rm.getId()).isPresent()){
        recipeRepo.findById(rm.getId()).get().setInstructions(rm.getInstructions());}
        return true;
    }
}
