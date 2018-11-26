/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

/**
 *
 * @author mehgn
 */
public class PasswordValidation {
     
    
    /*
    Checks where the @param password only have chars matching the allowedCharacters array.
    */


    /*
    Checks @param password is not shorter than 6 or longer than 200 chars.
    */
   
    public Boolean checkPasswordLenght(String password) {
        if (password.length() < 6 || password.length() > 32) {
            System.out.println("your password is not valid!");
            return false;
        }
        System.out.println("your password lenght is valid!");
        return true;
    }

    /*
    Checks if the @param password contains atleast one upper and lowercase char.
    also checks if there is atleast one digit in the @param password.
    */
    public Boolean checkUpperAndLowerCaseCharacter(String password) {

        Boolean leastOneUpperCase = false;
        Boolean leastOneLowerCase = false;
        Boolean leastOneDigit = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                leastOneUpperCase = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                leastOneLowerCase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                leastOneDigit = true;
            }

            if (leastOneUpperCase && leastOneLowerCase && leastOneDigit) {
                System.out.println("Upper and lower CHECK is valid!");
                return (leastOneUpperCase && leastOneLowerCase && leastOneDigit);
            }
        }
        System.out.println("Upper, Digit and lower CHECK is not valid!");
        return false;

    }
    
    
    public Boolean checkPassword(String password){
        if(checkPasswordLenght(password) && checkUpperAndLowerCaseCharacter(password)){
        return true;
        }
        return false;
    }
}
