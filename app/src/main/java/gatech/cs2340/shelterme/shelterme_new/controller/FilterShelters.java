package gatech.cs2340.shelterme.shelterme_new.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import gatech.cs2340.shelterme.shelterme_new.model.Shelter;
import gatech.cs2340.shelterme.shelterme_new.view.MainActivity;

import java.util.Set;

/**
 * Created by danielholliday on 3/14/18.
 *
 * This class will get list of shelters from database and can return appropriate shelters
 * based on filters called from search.
 */

public class FilterShelters {

    private static ArrayList<String> shelterNames = new ArrayList<>();
    private static Set<String> shelterSet = new HashSet<>();
    private static Map<String, Shelter> shelters = MainActivity.shelters;

    /**
     * returns shelters based on gender
     */
    public static ArrayList<String> filterShelterGender(final String gender) {
        //provides the opposite gender passed in --> used in logic to test if a restriction contains
        // neither "Men" or "Women"
        String oppositeGender = (gender == "Women") ? "Men" : "Women";
        if (shelters.containsValue(Shelter.class)) {
            for (Map.Entry<String, Shelter> entry : shelters.entrySet()) {
                // if equals the selected gender or doesn't contain either --> done by checking if
                // opposite gender is present. If it is, don't include.
                if (entry.getValue().getRestrictions().matches(gender) ||
                        (!entry.getValue().getRestrictions().matches(oppositeGender))) {

                    shelterSet.add(entry.getKey());
                }
            }
        }

        return new ArrayList<>(shelterSet); // returns ArrayList of set with shelters
    }

    /**
     * returns shelters based on age
     */

    public static ArrayList<String> filterShelterAge(final String ageGroup) {
        if (shelters.containsValue(Shelter.class)) {
            for (Map.Entry<String, Shelter> entry: shelters.entrySet()) {

                // test for children first -->
                if (entry.getValue().getRestrictions().matches("Children")) {
                    shelterSet.add(entry.getKey());
                } else if (entry.getValue().getRestrictions().matches("Young adults")) {
                    shelterSet.add(entry.getKey());
                } else if (entry.getValue().getRestrictions().matches("Anyone")) {
                    shelterSet.add(entry.getKey());
                } else if (entry.getValue().getRestrictions().matches("Families w/ newborns")) {
                    shelterSet.add(entry.getKey());
                }
            }
        }

        return new ArrayList<>(shelterSet);
    }

    /**
     * returns shelter based on age and gender
     */

    public static ArrayList<String> filterGenderAge(final String gender, final String ageGroup) {
        filterShelterGender(gender);
        filterShelterGender(ageGroup);
        return new ArrayList<>(shelterSet);
    }
}
