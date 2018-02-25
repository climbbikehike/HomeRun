package com.example.android.homerun.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PC on 2/20/18.
 */

public class UtilityMethods {

    // From https://www.geeksforgeeks.org/check-email-address-valid-not-java/
    private static final String USERNAME_REGEX = "^[\\p{L}0-9_+&*-]+(?:\\."+
            "[\\p{L}0-9_+&*-]+)*@" +
            "(?:[\\p{L}0-9-]+\\.)+[\\p{L}]{2,7}$";

    // No whitespaces and at-least 6 characters:
    private static final String PASSWORD_REGEX = "^(?=\\S+$).{6,}$";

    // Letters from any language and some special characters:
    private static final String NAME_REGEX = "^[\\p{L} .'-]+$";

    public static boolean isUsernameValid(String username) {
        Pattern pat = Pattern.compile(USERNAME_REGEX);
        if (username == null)
            return false;

        return pat.matcher(username).matches();
    }

    public static boolean isPasswordValid(String password) {
        Pattern pat = Pattern.compile(PASSWORD_REGEX);
        if (password == null)
            return false;

        return pat.matcher(password).matches();
    }
    public static boolean isNameValid(String name) {
        Pattern pat = Pattern.compile(NAME_REGEX);
        if (name == null)
            return false;

        return pat.matcher(name).matches();
    }
}
