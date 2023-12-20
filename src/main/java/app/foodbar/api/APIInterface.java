package app.foodbar.api;

import okhttp3.ResponseBody;
import app.foodbar.api.model.CreateRecipe;
import app.foodbar.api.model.CreateReview;
import app.foodbar.api.model.UserLogin;
import app.foodbar.api.model.UserRegister;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    //User API Interface
    @POST("/api/register")
    Call<UserRegister> createUser(@Body UserRegister userRegister);

    @POST("/api/login")
    Call<UserLogin> loginUser(@Body UserLogin userLogin);

    @GET("/api/logout")
    Call<ResponseBody> logoutUser();

    //Recipe API Interface
    @POST("/api/recipe")
    Call<CreateRecipe> createRecipe(@Body CreateRecipe createRecipe);

    //Review API Interface
    @POST("/api/recipe")
    Call<CreateReview> createReview(@Body CreateReview createReview);

//    @GET("/api/users?")
//    Call<UserList> doGetUserList(@Query("page") String page);
}
