package gatech.cs2340.shelterme.shelterme_new.model;

/**
 * Created by danielholliday on 3/25/18.
 */


@SuppressWarnings("ALL")

public enum Gender {
    FEMALE ("Women"),
    MALE ("Men"),
    NAN ("not-specified");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() { return gender; }
}