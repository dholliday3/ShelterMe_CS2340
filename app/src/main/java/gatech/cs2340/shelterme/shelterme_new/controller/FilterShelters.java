package gatech.cs2340.shelterme.shelterme_new.controller;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import gatech.cs2340.shelterme.shelterme_new.model.AgeGroup;
import gatech.cs2340.shelterme.shelterme_new.model.Gender;
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

    private static Set<String> shelterSet = new HashSet<>();
    private static Set<String> prevSet = new HashSet<>();
    private static Map<String, Shelter> shelters = MainActivity.shelters;
    private static int last = 0;


    /**
     * Filters shelters based on gender
     * @param gender gender to filter by
     * @return returns shelters based on gender or not-specified.
     * If not specified --> return all shelters.
     * If Male/Female --> return shelters with specified Male and shelters that don't specify gender
     */
    public static ArrayList<String> filterShelterGender(String gender) {

        if (gender.equals(Gender.NAN.getGender())) { // if gender == NAN --> add all shelters
            shelterSet.addAll(shelters.keySet());
        } else {
            // provides the opposite gender passed in --> used in logic to test if a restriction contains
            // neither "Men" or "Women"
            String oppositeGender = (gender.equals(Gender.FEMALE.getGender())) ? Gender.MALE.getGender() : Gender.FEMALE.getGender();

            shelterSet = new HashSet<>();

            for (Map.Entry<String, Shelter> entry : shelters.entrySet()) {
                // if equals the selected gender or doesn't contain either --> done by checking if
                // opposite gender is present. If it is, don't include.

                if (entry.getValue().getGender().matches(gender) ||
                        (!entry.getValue().getGender().matches(oppositeGender))) {
                    shelterSet.add(entry.getKey());

                }
            }
        }

        return new ArrayList<>(shelterSet); // returns ArrayList of set with shelters
    }


    /**
     * Filters and returns shelters based on age
     * @param ageGroup age group to filter by
     * @return shelters based on age
     */
    public static ArrayList<String> filterShelterAge(String ageGroup) {
        shelterSet = new HashSet<>();
        for (Map.Entry<String, Shelter> entry: shelters.entrySet()) {

            Boolean restrictBool = false;
            for (String restriction: entry.getValue().getRestriction_categories()) {
                if (restriction.equals(ageGroup)) {
                    restrictBool = true;
                }
            }
            if (restrictBool) {
                shelterSet.add(entry.getKey());
                Log.d("filterShelterAge", entry.getValue().getShelter_name() + " ASDF: " +  entry.getValue().getRestrictions());

            }
        }

        return new ArrayList<>(shelterSet);
    }

    /**
     * Filters the shelters by genders and age group
     * @param gender which gender to filter by
     * @param ageGroup which age group to filter by
     * @return return shelters based on gender and age
     */
    public static ArrayList<String> filterGenderAge(String gender, String ageGroup) {

        //if only gender
        //if only ageGroup
        //if both
        //else return all

        if (!gender.equals(Gender.NAN.getGender()) && ageGroup.equals(AgeGroup.NAN.getAgeGroup())) {
            filterShelterGender(gender);
        } else if (!ageGroup.equals(AgeGroup.NAN.getAgeGroup()) && gender.equals(Gender.NAN.getGender())) {
            filterShelterAge(ageGroup);
        } else if (!gender.equals(Gender.NAN.getGender()) && !ageGroup.equals(AgeGroup.NAN.getAgeGroup())) {
            String oppositeGender = (gender.equals(Gender.FEMALE.getGender())) ? Gender.MALE.getGender() : Gender.FEMALE.getGender();
            shelterSet = new HashSet<>();

            Log.d("both", gender);
            Log.d("both", ageGroup);
            int counter = 0;
            for (Map.Entry<String, Shelter> entry: shelters.entrySet()) {
                if (entry.getValue().getGender().matches(gender) ||
                        (!entry.getValue().getGender().matches(oppositeGender))) {
                    counter++;
                    Boolean restrictBool = false;
                    for (String restriction: entry.getValue().getRestriction_categories()) {
                        if (restriction.equals(ageGroup)) {
                            restrictBool = true;
                        }
                    }
                    if (restrictBool) {
                        shelterSet.add(entry.getKey());
                    }
                }
            }
            Log.d("both", counter + "");
        } else {
            shelterSet.addAll(shelters.keySet());
        }
        return new ArrayList<>(shelterSet);
    }
}