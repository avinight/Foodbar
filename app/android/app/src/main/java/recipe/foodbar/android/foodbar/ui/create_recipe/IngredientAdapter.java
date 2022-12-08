package recipe.foodbar.android.foodbar.ui.create_recipe;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import recipe.foodbar.android.foodbar.R;
import recipe.foodbar.android.foodbar.api.model.Ingredient;
import recipe.foodbar.android.foodbar.databinding.IngredientItemBinding;


public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {

    public ArrayList<Ingredient> ingredients;

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextInputEditText ingredientInputTextView;
        private TextInputEditText quantityInputTextView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

//            textView = (TextView) view.findViewById(R.id.textView);
            ingredientInputTextView = view.findViewById(R.id.ingredient_TextInputEditText);
            quantityInputTextView = view.findViewById(R.id.qty_TextInputEditText);
        }

//        public TextView getTextView() {
//            return textView;
//        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public IngredientAdapter(ArrayList<Ingredient> dataSet) {
        ingredients = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public IngredientAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ingredient_item, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull IngredientAdapter.ViewHolder holder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        TextInputEditText ingredientInputEditText = holder.ingredientInputTextView;
        TextInputEditText qtyInputEditText = holder.quantityInputTextView;
        ingredientInputEditText.setText(ingredients.get(position).name);
        Log.d("Ingedient Adapter", "onBindViewHolder: " + ingredients.get(position).size);
        qtyInputEditText.setText("");
        ingredientInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ingredients.get(holder.getAdapterPosition()).name = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        qtyInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    int qty = Integer.parseInt(s.toString());
                    ingredients.get(holder.getAdapterPosition()).size = Integer.parseInt(s.toString());
                } catch (Exception ignored) {

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}

