package recipe.foodbar.usecase;

public class UserConfirmer {

    public static String userTakenError() {
        return "Username is taken";
    }

    public static String userInformationNull(Boolean[] array){

        StringBuilder returnMessage = new StringBuilder();
        if (array[0]){
            returnMessage.append("Username field is empty ");
        }
        if (array[1]){
            returnMessage.append("Password field is empty ");
        }
        if (array[2]){
            returnMessage.append("Password Confirmation field is empty ");
        }
        if (array[3]){
            returnMessage.append("First Name field is empty ");
        }
        if (array[4]){
            returnMessage.append("Last Name field is empty ");

        }
        if (array[5]){
            returnMessage.append("Last Name field is empty ");
        }
        return returnMessage.toString();
    }

    public static String passwordConfirmation(){
        return "Passwords do not match";
    }
}
