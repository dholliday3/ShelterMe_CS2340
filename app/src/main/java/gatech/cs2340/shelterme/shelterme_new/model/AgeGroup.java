package gatech.cs2340.shelterme.shelterme_new.model;

/**
 * Created by danielholliday on 3/25/18.
 */

@SuppressWarnings("PublicMethodNotExposedInInterface")
public enum AgeGroup {
    FAMILIES ("Families w/ newborns"),
    CHILDREN ("Children"),
    YOUNG_ADULTS ("Young adults"),
    ANYONE ("Anyone"),
    NAN ("not-specified");

    private String ageGroup;

    AgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getAgeGroup() { return ageGroup; }
}