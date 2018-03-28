package gatech.cs2340.shelterme.shelterme_new.model;


import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by jungwonkang on 3/13/18.
 */

@IgnoreExtraProperties
public class Shelter {
    private String address;
    private String phone_number;
    private String uid;
    private String capacity;
    private String special_notes;
    private String restrictions;
    private String gender;
    private List<String> restriction_categories;
    private String shelter_name;
    private String longitude;
    private String latitude;
    private String beds;


    public Shelter(String uid, String address, String phone_number, String capacity,
                   String special_notes, String restrictions, String gender, List<String> restriction_categories,
                   String shelter_name, String longitude, String latitude, String beds){
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
        this.beds = beds;

    }

    public Shelter() {
        //Default Constructor
    }

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getShelter_name() {
        return shelter_name;
    }
    public void setShelter_name(String shelter_name) {
        this.shelter_name = shelter_name;
    }

    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getRestrictions() {
        return restrictions;
    }
    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public List<String> getRestriction_categories() { return restriction_categories; }
    public void setRestriction_categories(List<String> restriction_categories) {this.restriction_categories = restriction_categories; }

    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getSpecial_notes() {
        return special_notes;
    }

    public void setSpecial_notes(String special_notes) {
        this.special_notes = special_notes;
    }


    public String getPhone_number() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBeds() {
        return beds;
    }
    public void setBeds(String beds) {
        this.beds = uid;
    }
}