package gatech.cs2340.shelterme.shelterme_new.model;

import android.os.StrictMode;

/**
 * Created by jungwonkang on 3/12/18.
 */

public class Shelter {

    //private String _id;
    private String unique_key;
    private String shelter_name;
    private String capacity;
    private String restrictions;
    private String longitude;
    private String latitude;
    private String address;
    private String special_notes;
    private String phone_number;
    //private int __v;

    public Shelter(String unique_key, String shelter_name, String capacity,
                   String restrictions, String longitude, String latitude,
                   String address, String special_notes, String phone_number) {
        //this._id = _id;
        this.unique_key = unique_key;
        this.shelter_name = shelter_name;
        this.capacity = capacity;
        this.restrictions = restrictions;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.special_notes = special_notes;
        this.phone_number = phone_number;
        //this.__v = __v;
    }

    /**
     * dummy constructor
     */
    public Shelter() {

    }

    /*
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    */

    public String getUnique_key() {
        return unique_key;
    }
    public void setUnique_key(String unique_key) {
        this.unique_key = unique_key;
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


    /*
    public int get__v() {
        return __v;
    }
    public void set_v(int __v) {
        this.__v = __v;
    }
    */

    @Override
    public String toString() {
        String info = String.format("Shelter Info: uniqueKey = %d, shelterName = %s, " +
                        "capacity = %s, restrictions = %s, longitude = %d, latitude = %d, " +
                        "address = %s, specialNotes = %s, phoneNumber = %s", unique_key, shelter_name,
                capacity, restrictions, longitude, latitude, address, special_notes, phone_number);
        return "hi";
    }
}