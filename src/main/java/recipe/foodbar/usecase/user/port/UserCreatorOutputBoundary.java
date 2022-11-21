/*
UserCreatorOutputBoundary interface used to allow upwards communication from
usecase to presenter without dependency
 */
package recipe.foodbar.usecase.user.port;


public interface UserCreatorOutputBoundary {

    /**
     * Method to receive a String representation of the success or
     * error messages needed to be displayed
     *
     * @param message the String message given
     * @return The message to be displayed
     */
    String present(String message);
}