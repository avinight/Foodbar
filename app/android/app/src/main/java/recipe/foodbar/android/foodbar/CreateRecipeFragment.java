package recipe.foodbar.android.foodbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import recipe.foodbar.android.foodbar.databinding.FragmentCreateRecipeBinding;
import recipe.foodbar.android.foodbar.databinding.FragmentRegisterBinding;

public class CreateRecipeFragment extends Fragment {

    String[] cuisine = {"Chinese", "Korean", "Italian", "Japanese", "Indian", "Continental"};

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

        binding = FragmentCreateRecipeBinding.inflate(inflater, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (binding.getRoot().getContext(), android.R.layout.select_dialog_item, cuisine);
        binding.cusineAutoCompleteTextView.setAdapter(adapter);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        navigationView.getMenu().findItem(R.id.login).setVisible(false);

//        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(RegisterFragment.this)
//                        .navigate(R.id.action_LogInFragment_to_mainActivity);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}