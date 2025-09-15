package org.example.smartHome.util;

/**
 * Utility class for validation of user inputs like email and password.
 */

public class ValidationUtil {

    // regex for email validation format
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    /**
     * Validates if the given email is in proper format.
     * Example of valid: user@gmail.com
     */
    // validates the given email format example: user@gmail.com
    public static boolean isValidEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }


    /**
     * Validates password strength
     * - At least 8 characters
     * - At least one uppercase letter
     * - At least one lowercase letter
     * - At least one digit
     * - At least one special character (!@#$%^&*)
     */
    public static boolean isValidPassword(String password) {

        return
                        password != null &&
                        password.length() >= 8 &&
                        password.matches(".*[A-Z].*") &&
                        password.matches(".*[a-z].*") &&
                        password.matches(".*[0-9].*") &&
                        password.matches(".*[!@#$%^&*].*");

    }
}

