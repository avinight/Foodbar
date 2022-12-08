package recipe.foodbar.android.foodbar.ui.create_recipe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import recipe.foodbar.android.foodbar.R;
import recipe.foodbar.android.foodbar.api.APIClient;
import recipe.foodbar.android.foodbar.api.APIInterface;
import recipe.foodbar.android.foodbar.api.model.CreateRecipe;
import recipe.foodbar.android.foodbar.api.model.Ingredient;
import recipe.foodbar.android.foodbar.api.model.UserRegister;
import recipe.foodbar.android.foodbar.databinding.FragmentCreateRecipeBinding;
import recipe.foodbar.android.foodbar.ui.register.RegisterFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateRecipeFragment extends Fragment {

    String[] cuisine = {"Chinese", "Ethiopian", "French", "Korean", "Italian", "Japanese", "Indian", "Continental"};
    final String TAG = "CreateRecipeFragment";
    ArrayList<Ingredient> ingredients;
    IngredientAdapter ingredientAdapter;
    private APIInterface apiInterface;

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_create_recipe, container, false);
//    }

    private FragmentCreateRecipeBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        apiInterface = APIClient.getClient(getContext()).create(APIInterface.class);
        binding = FragmentCreateRecipeBinding.inflate(inflater, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (binding.getRoot().getContext(), android.R.layout.select_dialog_item, cuisine);
        binding.cusineAutoCompleteTextView.setAdapter(adapter);
        ingredients = new ArrayList<Ingredient>(Arrays.asList(new Ingredient("",1)));
        ingredientAdapter = new IngredientAdapter(ingredients);
        binding.ingredientsListView.setAdapter(ingredientAdapter);
        binding.ingredientsListView.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MenuHost menuHost = requireActivity();
        menuHost.addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.create_recipe_menu, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                Log.d(TAG, "onMenuItemSelected: ");
                if (menuItem.getItemId() == R.id.action_save) {
                    CreateRecipe recipe = new CreateRecipe(binding.titleTextInputEditText.getText().toString(),
                            Float.parseFloat(binding.portionTextInputEditText.getText().toString()),
                            new ArrayList<>(List.of(binding.instructionsTextInputEditText.getText().toString())),
                            binding.cusineAutoCompleteTextView.getText().toString(),
                            new ArrayList<>(),
                            ((IngredientAdapter) binding.ingredientsListView.getAdapter()).getIngredients());

                    Log.d(TAG, "onMenuItemSelected: " + "Save Menu Item");
                    Call<CreateRecipe> call = apiInterface.createRecipe(recipe);
                    call.enqueue(new Callback<CreateRecipe>() {
                        @Override
                        public void onResponse(Call<CreateRecipe> call, Response<CreateRecipe> response) {
                            Toast.makeText(getActivity(), "Recipe Saved Successfully", Toast.LENGTH_SHORT).show();
                            NavHostFragment.findNavController(CreateRecipeFragment.this)
                                    .navigate(R.id.action_createRecipeFragment_to_navigation_home);
                        }

                        @Override
                        public void onFailure(Call<CreateRecipe> call, Throwable t) {

                        }
                    });

//                    action_createRecipeFragment_to_navigation_home
                }
                return true;
            }
        }, this.getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        binding.addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredients.add(new Ingredient("",1));
                ingredientAdapter.notifyItemInserted(ingredients.size());
            }
        });

        binding.removeIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredients.remove(ingredients.size() - 1);
                ingredientAdapter.notifyItemRemoved(ingredients.size());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}