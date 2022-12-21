package de.exxcellent.challenge;

public class ValueChecker {
    public static boolean isDouble(String str) {
        try {
            double d = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean isInteger(String str) {
        try {
            double d = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean isString(String str) {
        return !isInteger(str) && !isDouble(str);
    }
}
