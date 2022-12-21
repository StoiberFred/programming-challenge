package de.exxcellent.challenge;

import java.util.List;
import java.util.stream.Collectors;

public class ValueChecker {
    public static boolean bothListsAreInteger(List<String> first, List<String> second) {
        for(boolean b: first.stream().map(ValueChecker::isInteger).collect(Collectors.toList())) if (!b) return false;
        for(boolean b: second.stream().map(ValueChecker::isInteger).collect(Collectors.toList())) if (!b) return false;
        return true;
    }

    public static boolean isInteger(String str) {
        try {
            double d = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
