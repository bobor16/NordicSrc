/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

/**
 *
 * @author Martin Sorensen
 */
public class PasswordValidation {
    
    private char[] allowedCharacters
            = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z',
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    
    /*
    Checks where the @param password only have chars matching the allowedCharacters array.
    */

    
    public Boolean checkAllowedCharacters(String password) {
        char[] passwordArray = password.toCharArray();
        int arrayIncrementCheck = 0;

        for (int i = 0; i < allowedCharacters.length; i++) {
            for (int j = 0; j < passwordArray.length; j++) {
                if (allowedCharacters[i] == passwordArray[j]) {
                    arrayIncrementCheck++;
                }
            }
        }
        if (arrayIncrementCheck == passwordArray.length) {
            System.out.println("your password char is valid!");
            return true;
        }
        return false;
    }

    /*
    Checks @param password is not shorter than 6 or longer than 200 chars.
    */
   
    public Boolean checkPasswordLenght(String password) {
        if (password.length() < 6 || password.length() > 200) {
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
}
