package de.exxcellent.challenge;

import java.util.*;
import java.util.stream.Collectors;

public class Utility {

    public static boolean ListIsInteger(List<String> list) {
        for(boolean b: list.stream().map(Utility::isInteger).collect(Collectors.toList())) if (!b) return false;
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

    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        Set<T> keys = new HashSet<T>();
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}
