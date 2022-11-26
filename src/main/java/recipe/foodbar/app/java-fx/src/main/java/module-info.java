module recipe.foodbar.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens recipe.foodbar.javafx to javafx.fxml;
    exports recipe.foodbar.javafx;
}