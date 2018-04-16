package gatech.cs2340.shelterme.shelterme_new.model;


import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by jungwonkang on 3/13/18.
 */

@SuppressWarnings({"PublicMethodNotExposedInInterface",
        "AssignmentToCollectionOrArrayFieldFromParameter", "DefaultFileTemplate"})
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

    /**
     * Constructor for the shelters
     * @param uid shelter id
     * @param address location of the shelter
     * @param phone_number phone number of the shelter
     * @param capacity number of people shelter can fit
     * @param special_notes special necessary notes about the shelter
     * @param restrictions specific restrictions the shelter has
     * @param gender which genders the shelter takes
     * @param restriction_categories specific restriction categories
     * @param shelter_name name of the shelter
     * @param longitude longitude location of shelter for maps
     * @param latitude latitude location of shelter for maps
     * @param beds number of available beds in the shelter
     */
    public Shelter(String uid, String address, String phone_number, String capacity,
                   String special_notes, String restrictions, String gender,
                   List<String> restriction_categories,
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

    /**
     * Default constructor
     */
    public Shelter() {
        //Default Constructor
    }

    /**
     * getter for the shelter id
     * @return String of the shelter id
     */
    public String getUid() {
        return uid;
    }

    /**
     * setter for the shelter id
     * @param uid the new uid to set to
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * getter for the shelter name
     * @return String of the shelter name
     */
    public String getShelter_name() {
        return shelter_name;
    }

    /**
     * setter for the shelter name
     * @param shelter_name the new shelter name to set to
     */
    public void setShelter_name(String shelter_name) {
        this.shelter_name = shelter_name;
    }

    /**
     * getter for the capacity of the shelter
     * @return String representation of the capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * setter for the capacity of the shelter
     * @param capacity the new capacity to set to
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * getter for the restrictions of the shelter
     * @return String of the restrictions the shelter has
     */
    public String getRestrictions() {
        return restrictions;
    }

    /**
     * setter for the restrictions of the shelter
     * @param restrictions the new restrictions to set to
     */
    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * getter for the gender specific shelters
     * @return String of which genders the shelter accepts
     */
    public String getGender() { return gender; }

    /**
     * setter for the gender specific shelters
     * @param gender sets the genders the shelters will accept
     */
    public void setGender(String gender) { this.gender = gender; }

    /**
     * getter for the restriction categories of the shelter
     * @return List of the different categories
     */
    public Iterable<String> getRestriction_categories() { return restriction_categories; }

    /**
     * setter for the restriction categories of the shelter
     * @param restriction_categories the new restriction categories to set for the shelter
     */
    public void setRestriction_categories(List<String> restriction_categories)
    {this.restriction_categories = restriction_categories; }

    /**
     * getter for the longitude of the shelter
     * @return String representation of the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * setter for the longitude
     * @param longitude the new longitude to set the shelter to
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * getter for the latitude of the shelter
     * @return String representation of the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * setter for the latitude
     * @param latitude the new latitude to set the shelter to
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * getter for the address of the shelter
     * @return String of the current address location
     */
    public String getAddress() {
        return address;
    }

    /**
     * setter for the address of the shelter
     * @param address the address of the shelter to set to
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * getter for the special notes about the shelters
     * @return String of the special notes about the shelter
     */
    public String getSpecial_notes() {
        return special_notes;
    }

    /**
     * setter for the special notes
     * @param special_notes the special notes for the shelter to write for the description
     */
    public void setSpecial_notes(String special_notes) {
        this.special_notes = special_notes;
    }

    /**
     * getter for the phone number of the shelter
     * @return String representation of the phone number of the shelter
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * setter for the phone number
     * @param phone_number the phone number of the shelter
     */
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * getter for the number of available beds the shelter has
     * @return String representation of the number of beds the shelter currently has
     */
    public String getBeds() {
        return beds;
    }

    /**
     * setter for the number of beds
     * @param beds the new number of beds to set the shelter to
     */
    public void setBeds(String beds) {
        this.beds = beds;
    }
}