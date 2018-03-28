package gatech.cs2340.shelterme.shelterme_new.model;

/**
 * Created by jungwonkang on 3/13/18.
 */

import com.google.firebase.database.IgnoreExtraProperties;

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


    public User(String account_state, String beds_reserved, String email, String gender,
                   String name, String password, String phone, String reserved_shelter, String user_category,
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

    public User() {
        //Default Constructor
    }

    public String getAccount_state() {
        return account_state;
    }
    public void setAccount_state(String account_state) {
        this.account_state = account_state;
    }

    public String getBeds_reserved() {
        return beds_reserved;
    }
    public void setBeds_reserved(String beds_reserved) {
        this.beds_reserved = beds_reserved;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReserved_shelter() {
        return reserved_shelter;
    }
    public void setReserved_shelter(String reserved_shelter) {
        this.reserved_shelter = reserved_shelter;
    }

    public String getUser_category() {
        return user_category;
    }
    public void setUser_category(String user_category) {
        this.user_category = user_category;
    }

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getVeteran() {
        return veteran;
    }
    public void setVeteran(String veteran) {
        this.veteran = veteran;
    }

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }

}
