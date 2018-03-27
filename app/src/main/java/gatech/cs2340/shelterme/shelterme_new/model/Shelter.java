package gatech.cs2340.shelterme.shelterme_new.model;


import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by jungwonkang on 3/13/18.
 */

@IgnoreExtraProperties
public class Shelter {
    public String address;
    public String phone_number;
    public String uid;
    public String capacity;
    public String special_notes;
    public String restrictions;
    public String gender;
    public List<String> restriction_categories;
    public String shelter_name;
    public String longitude;
    public String latitude;


    public Shelter(String uid, String address, String phone_number, String capacity,
                   String special_notes, String restrictions, String gender, List<String> restriction_categories,
                   String shelter_name, String longitude, String latitude){
        this.address = address;
        this.uid = uid;
        this.phone_number = phone_number;
        this.capacity = capacity;
        this.special_notes = special_notes;
        this.restrictions = restrictions;
        this.gender = gender;
        this.restriction_categories = restriction_categories;
        this.shelter_name = shelter_name;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public Shelter() {
        //Default Constructor
    }
}