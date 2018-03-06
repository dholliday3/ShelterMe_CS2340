package m4.cs2340.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by danielholliday on 2/28/18.
 */

/**
 * NOTICE: Currently, all of these parameters are Strings bc they are imported as Strings.
 * Some of them should be changed to doubles/ints.
 */

@Entity(tableName = "shelters_table")
public class Shelter {
    public static int ShelterCount = 13;
    /*
    Unique Key
    Shelter Name
    Capacity
    Restrictions
    Longitude
    Latitude
    Address
    Special Notes
    Phone Number
    */

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Unique_Key")
    private String shelterKey;

    @ColumnInfo(name = "Shelter_Name")
    private String shelterName;

    @ColumnInfo(name = "Capacity")
    private String capacity;

    @ColumnInfo(name = "Restrictions")
    private String restrictions;

    @ColumnInfo(name = "Longitude")
    private String longitude;

    @ColumnInfo(name = "Latitude")
    private String latitude;

    @ColumnInfo(name = "Address")
    private String address;

    @ColumnInfo(name = "Special_Notes")
    private String specialNotes;

    @ColumnInfo(name = "Phone_Number")
    private String phoneNumber;

    public Shelter(String shelterKey, String shelterName, String capacity,
                   String restrictions, String longitude, String latitude,
                   String address, String specialNotes, String phoneNumber) {
        this.shelterKey = shelterKey;
        this.shelterName = shelterName;
        this.capacity = capacity;
        this.restrictions = restrictions;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.specialNotes = specialNotes;
        this.phoneNumber = phoneNumber;
    }

    public void setShelterKey(String key) {this.shelterKey = key;}

    public String getShelterKey() {return this.shelterKey;}

    public void setShelterName(String shelterName) {this.shelterName = shelterName;}

    public String getShelterName() {return this.shelterName;}

    public void setCapacity(String capacity) {this.capacity = capacity;}

    public String getCapacity() {return this.capacity;}

    public void setRestrictions(String restrictions) {this.restrictions = restrictions;}

    public String getRestrictions() {return this.restrictions;}

    public void setLongitude(String longitude) {this.longitude = longitude;}

    public String getLongitude() {return this.longitude;}

    public void setLatitude(String latitude) {this.latitude = latitude;}

    public String getLatitude() {return this.latitude;}

    public void setAddress(String address) {this.address = address;}

    public String getAddress() {return this.address;}

    public void setSpecialNotes(String specialNotes) {this.specialNotes = specialNotes;}

    public String getSpecialNotes() {return this.specialNotes;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getPhoneNumber() {return this.phoneNumber;}
}
