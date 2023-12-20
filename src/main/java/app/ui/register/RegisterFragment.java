package app.ui.register;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.io.IOException;

import app.api.model.UserRegister;
import recipe.foodbar.android.foodbar.R;
import app.api.APIClient;
import app.api.APIInterface;
import recipe.foodbar.android.foodbar.databinding.FragmentRegisterBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;
    private APIInterface apiInterface;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        apiInterface = APIClient.getClient(getContext()).create(APIInterface.class);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserRegister userRegister = new UserRegister(binding.usernameTextInputEditText.getText().toString(),
                        binding.passwordTextInputEditText.getText().toString(),
                        binding.passwordShadowTextInputEditText.getText().toString(),
                        binding.emailTextInputEditText.getText().toString());
                Call<UserRegister> call = apiInterface.createUser(userRegister);
                call.enqueue(new Callback<UserRegister>() {
                    @Override
                    public void onResponse(Call<UserRegister> call, Response<UserRegister> response) {
                        Log.d("RegisterFragment", "onResponse: Success" + response.code());
                        try {
                            if (response.errorBody().string().equals("UserCreation Successful, no problems encountered.")) {
                                Toast.makeText(getActivity(), "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                NavHostFragment.findNavController(RegisterFragment.this)
                                        .navigate(R.id.action_RegisterFragment_to_LogInFragment);
                            } else {
                                try {
                                    Toast.makeText(getActivity(), response.errorBody().string(), Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserRegister> call, Throwable t) {
                        Log.d("RegisterFragment", "onResponse: Failure" + t.getMessage());
                        Toast.makeText(getActivity(), "Account creation data incorrect", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}