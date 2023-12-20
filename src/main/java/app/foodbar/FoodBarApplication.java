package app.foodbar;

import android.app.Application;

import com.google.android.material.color.DynamicColors;

public class FoodBarApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}

