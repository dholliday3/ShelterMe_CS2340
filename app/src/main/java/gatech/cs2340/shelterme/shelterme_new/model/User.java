package gatech.cs2340.shelterme.shelterme_new.model;

/*
  Created by jungwonkang on 3/13/18.
 */

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Class representing a User.
 */
@SuppressWarnings("ALL")
@IgnoreExtraProperties
public class User {
    private String account_state;
    private String beds_reserved;
    private String email;
    private String gender;
    private String name;
    private String password;
    private String phone;
    private String reserved_shelter;
    private String user_category;
    private String user_name;
    private String veteran;
    private String uid;

    /**
     * Constructor for the user
     * @param account_state state of the account
     * @param beds_reserved number of beds reserved under this user
     * @param email email of the user
     * @param gender gender of the user
     * @param name name of the user
     * @param password password for the user account
     * @param phone phone number for the user
     * @param reserved_shelter which shelter the user has beds reserved in
     * @param user_category category of the user
     * @param user_name user name for login
     * @param veteran veteran status
     * @param uid user id
     */
    public User(String account_state, String beds_reserved, String email, String gender,
                   String name, String password, String phone, String reserved_shelter,
                String user_category,
                   String user_name, String veteran, String uid) {
        this.account_state = account_state;
        this.beds_reserved = beds_reserved;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.reserved_shelter = reserved_shelter;
        this.user_category = user_category;
        this.user_name = user_name;
        this.veteran = veteran;
        this.uid = uid;
    }

    /**
     * Default Constructor
     */
    public User() {
        //Default Constructor
    }

    /**
     * getter for the account state of the user
     * @return String of the state of the account
     */
    public String getAccount_state() {
        return account_state;
    }

    /**
     * setter for the account state of the user
     * @param account_state state to set the account to
     */
    public void setAccount_state(String account_state) {
        this.account_state = account_state;
    }

    /**
     * getter for the number of beds user reserved
     * @return String representation of the number of beds reserved
     */
    public String getBeds_reserved() {
        return beds_reserved;
    }

    /**
     * setter for the number of beds reserved
     * @param beds_reserved sets the number of beds reserved
     */
    public void setBeds_reserved(String beds_reserved) {
        this.beds_reserved = beds_reserved;
    }

    /**
     * getter for the email of the user
     * @return String of the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter for the email
     * @param email email to set to for the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter for the name of the user
     * @return String of the user's real name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name of the user
     * @param name name to give to the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the gender of the user
     * @return String of the gender of the user
     */
    public String getGender() { return gender; }

    /**
     * setter for the gender of the user
     * @param gender the gender to give to the user
     */
    public void setGender(String gender) { this.gender = gender; }

    /**
     * getter for the password of the user
     * @return String representation of the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for the password of the user
     * @param password password to set the user account to
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter for the phone number of the user
     * @return String representation of the user's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * setter for the user's phone number
     * @param phone phone number to give to the user
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * getter to the shelter the user has beds reserved in
     * @return String of the shelter name
     */
    public String getReserved_shelter() {
        return reserved_shelter;
    }

    /**
     * setter for the shelter that is being reserved
     * @param reserved_shelter shelter that is being reserved
     */
    public void setReserved_shelter(String reserved_shelter) {
        this.reserved_shelter = reserved_shelter;
    }

    /**
     * getter for the category of the user
     * @return String of the user category
     */
    public String getUser_category() {
        return user_category;
    }

    /**
     * setter for the user category
     * @param user_category category of the user to set to
     */
    public void setUser_category(String user_category) {
        this.user_category = user_category;
    }

    /**
     * getter for the username of the user account
     * @return String of the username
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * setter for the username
     * @param user_name username to give to the user account
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * getter for the veteran status of the user
     * @return String if the user is a veteran
     */
    public String getVeteran() {
        return veteran;
    }

    /**
     * setter for the veteran status
     * @param veteran whether or not the user is veteran
     */
    public void setVeteran(String veteran) {
        this.veteran = veteran;
    }

    /**
     * getter for the user id
     * @return String of the user id
     */
    public String getUid() {
        return uid;
    }

    /**
     * setter for the user id
     * @param uid new user id to set the user to
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

}
