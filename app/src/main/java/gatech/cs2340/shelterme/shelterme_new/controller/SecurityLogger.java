package gatech.cs2340.shelterme.shelterme_new.controller;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 *
 *Created by Jason Liang on 4/26/2018.
 */
public class SecurityLogger {
    public static void logInfo(String email, String action) {
        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference().child("logs").child("login_registration");
        Long timeStampLong = System.currentTimeMillis()/1000;
        String timeStamp = timeStampLong.toString();
        String regLog = email + " | " + timeStamp + " | " + action;
        dbReference.push().setValue(regLog);
    }
    public static void logReservation(String email, String action) {
        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference().child("logs").child("reservation");
        Long timeStampLong = System.currentTimeMillis()/1000;
        String timeStamp = timeStampLong.toString();
        String regLog = email + " | " + timeStamp + " | " + action;
        dbReference.push().setValue(regLog);
    }
}