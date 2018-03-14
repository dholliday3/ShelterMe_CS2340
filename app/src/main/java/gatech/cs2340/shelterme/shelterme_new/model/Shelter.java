package gatech.cs2340.shelterme.shelterme_new.model;


import com.google.firebase.database.IgnoreExtraProperties;

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
    public String shelter_name;
    public String longitude;
    public String latitude;


    public Shelter(String uid, String address, String phone_number, String capacity,
                   String special_notes, String restrictions, String shelter_name, String longitude,
                   String latitude){
        this.address = address;
        this.uid = uid;
        this.phone_number = phone_number;
        this.capacity = capacity;
        this.special_notes = special_notes;
        this.restrictions = restrictions;
        this.shelter_name = shelter_name;
        this.longitude = longitude;
        this.latitude = latitude;

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



}