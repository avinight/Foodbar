package recipe.foodbar.usecase.user_example.validator;

import recipe.foodbar.entities.UserExample;
import recipe.foodbar.usecase.user_example.exception.UserValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class UserValidator {

    public static void validateCreateUser(final UserExample userExample) {
        if (userExample == null) throw new UserValidationException("User should not be null");
        if (isBlank(userExample.getEmail())) throw new UserValidationException("Email should not be null");
        if (isBlank(userExample.getFirstName())) throw new UserValidationException("First name should not be null");
        if (isBlank(userExample.getLastName())) throw new UserValidationException("Last name should not be null");
    }

    private UserValidator() {

    }
}