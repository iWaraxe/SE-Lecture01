package com.coherentsolution.section02;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateChecker {
    public static boolean hasDuplicateBooks(List<? extends Item> books) {
        Set<String> titles = new HashSet<>();
        for (Item book : books) {
            if (!titles.add(book.getName())) {
                return true; // Found a duplicate title
            }
        }
        return false;
    }

    public static boolean hasDuplicateMagazines(List<? extends Item> magazines) {
        Set<String> names = new HashSet<>();
        for (Item magazine : magazines) {
            if (!names.add(magazine.getName())) {
                return true; // Found a duplicate name
            }
        }
        return false;
    }

    public static boolean isDuplicate(String name, List<? extends Item> items) {
        Set<String> names = new HashSet<>();
        for (Item item : items) {
            if (!names.add(item.getName())) {
                return true;
            }
        }
        return false;
    }

}
