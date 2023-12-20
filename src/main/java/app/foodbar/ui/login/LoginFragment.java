package app.foodbar.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import app.foodbar.R;
import app.foodbar.api.model.UserLogin;
import app.foodbar.api.APIClient;
import app.foodbar.api.APIInterface;
import app.foodbar.databinding.FragmentLoginBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    APIInterface apiInterface;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        apiInterface = APIClient.getClient(getContext()).create(APIInterface.class);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginFragment", "onClick: login button clicked");
                Log.d("LoginFragment", binding.usernameTextInputEditText.getText().toString() + binding.passwordTextInputEditText.getText().toString());
                UserLogin loginUser = new UserLogin(binding.usernameTextInputEditText.getText().toString(), binding.passwordTextInputEditText.getText().toString());
                Call<UserLogin> call = apiInterface.loginUser(loginUser);
                call.enqueue(new Callback<UserLogin>() {
                    @Override
                    public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                        if(response.errorBody() != null) {
                            Toast.makeText(getActivity(), "Login failed, incorrect username or password", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d("LoginFragment ", "onResponse: ");
                            Toast.makeText(getActivity(), "Logged In", Toast.LENGTH_SHORT).show();
                            NavHostFragment.findNavController(LoginFragment.this)
                                    .navigate(R.id.action_LogInFragment_to_mainActivity);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserLogin> call, Throwable t) {
                        Log.d("LoginFragment", "onResponse: Failure" + t.getMessage());
                        Toast.makeText(getActivity(), "Account login data incorrect", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_LogInFragment_to_RegisterFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}