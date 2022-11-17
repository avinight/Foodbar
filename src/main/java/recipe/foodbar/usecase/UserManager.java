/* Below is the UserManger class which acts as the usecase interactor,
 * using all the separate classes to run the necessary code for the use case
 */

package recipe.foodbar.usecase;


public class UserManager implements UserCreatorInputBoundary{

//    private String username;
//    private String password;
//    private String passwordShadow;
//    private String firstName;
//    private String lastName;
//    private String email;
    private UserCreatorOutputBoundary output;


//    /**
//     * Constructor for UserManager
//     *
//     * @param username String representing the username of the object
//     * @param password String representing the password of the object
//     * @param passwordShadow String representing the passwordShadow of the object
//     * @param first String representing the firstname of the object
//     * @param last String representing the lastname of the object
//     * @param email String representing the email of the object
//     */


//    public UserManager (String username, String password, String passwordShadow, String first,
//                        String last, String email){
//        this.username = username;
//        this.password = password;
//        this.passwordShadow = passwordShadow;
//        this.firstName = first;
//        this.lastName = last;
//        this.email = email;
//
//    }

    /**
     *
     * @param output UserCreatorOutputBoundary object to follow dependency rules
     */
    public UserManager (UserCreatorOutputBoundary output){
        this.output = output;
    }


    /**
     * Method to create a RegisteredUser object after checking if it contains valid information
     *
     * @param input a bundle of information in the form of a UserInputData object
     * @return boolean of whether the account creation was successful
     */
    @Override
    public String create(UserInputData input) {
        String id = input.getUsername();
        String password = input.getPassword();
        String passwordShadow = input.getPasswordShadow();
        String email = input.getEmail();
        String firstName = input.getFirstName();
        String lastName = input.getLastName();

        Boolean[] nullChecks = UserChecker.checkNullEntries(input);

        //if code works fix the password parameter
        if (nullChecks[0] || nullChecks[1] || nullChecks[2] ||
                nullChecks[3] || nullChecks[4] || nullChecks[5]) {
//            return UserConfirmer.userInformationNull(nullChecks);
            return output.present(UserConfirmer.userInformationNull(nullChecks));

        }  else if (!(UserChecker.checkPasswordMatch(password, passwordShadow))) {
//            return UserConfirmer.passwordConfirmation();
            return output.present(UserConfirmer.passwordConfirmation());


        } else if (UserChecker.checkUserTaken(input)){
//            return UserConfirmer.userTakenError();
            return output.present(UserConfirmer.userTakenError());


        } else {

            //creation of the account and added to the repository
            UserFactory.createAccount(id, password, firstName, lastName, email);

            return output.present("UserCreation Successful, no problems encountered.");
        }

    }


}
