package gatech.cs2340.shelterme.shelterme_new.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import gatech.cs2340.shelterme.shelterme_new.R;

import java.util.HashSet;
import java.util.Map;
import gatech.cs2340.shelterme.shelterme_new.model.Shelter;
import gatech.cs2340.shelterme.shelterme_new.model.User;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.widget.EditText;

import android.app.AlertDialog;
/**
 * Created by Ally Liu on 2/27/2018.
 */

public class ShelterInfoActivity extends AppCompatActivity {


    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private Map<String, Shelter> shelters = MainActivity.shelters;
    private Map<String, User> users = MainActivity.users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        //Toolbar stuff.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shelter Page");

        //Code that gets information from the ListView.
        final String shelterName = this.getIntent().getExtras().getString("name");

        TextView nameTV = findViewById(R.id.shelterName_textview);
        nameTV.setText(shelterName);

        TextView addressTV = findViewById(R.id.address);
        addressTV.setText("Address: " + MainActivity.shelters.get(shelterName).getAddress());

        TextView phoneTV = findViewById(R.id.phoneNumber);
        phoneTV.setText("Phone Number: " + MainActivity.shelters.get(shelterName).getPhone_number());

        TextView capacityTV = findViewById(R.id.capacity);
        capacityTV.setText("Capacity: " + MainActivity.shelters.get(shelterName).getCapacity());

        TextView bedsTV = findViewById(R.id.beds);
        bedsTV.setText("Beds: " + MainActivity.shelters.get(shelterName).getBeds());

        TextView restrictionsTV = findViewById(R.id.restrictions);
        restrictionsTV.setText("Restrictions: " + MainActivity.shelters.get(shelterName).getRestrictions());

        TextView special_notesTV = findViewById(R.id.specialNotes);
        special_notesTV.setText("Special Notes: " + MainActivity.shelters.get(shelterName).getSpecial_notes());

        Button reserveButton = (Button) findViewById(R.id.reserveBed);
        reserveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String shelterID = MainActivity.shelters.get(shelterName).getUid();
                int beds = Integer.parseInt(MainActivity.shelters.get(shelterName).getBeds());

                if (users.get("danholli@gmail.com").getReserved_shelter().equals("none") || users.get("danholli@gmail.com").getReserved_shelter().equals(shelterName)) {
                    //set user data
                    mDatabase.child("users").child("danholli").child("reserved_shelter").setValue(shelterName);
                    int num_beds_reserved = Integer.parseInt(MainActivity.users.get("danholli@gmail.com").getBeds_reserved());
                    num_beds_reserved++;
                    mDatabase.child("users").child("danholli").child("beds_reserved").setValue(Integer.toString(num_beds_reserved));
                    //set shelter bed data
                    beds--;
                    if (beds - 1 < 0) {
                        beds = 0;
                    }
                    mDatabase.child("shelters").child(shelterID).child("beds").setValue(Integer.toString(beds));
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(ShelterInfoActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("You already have a bed reserved in another shelter! Please cancel before reserving again.");
                    alertDialog.show();
                }
            }
        });

        Button cancelButton = (Button) findViewById(R.id.cancelReserve);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String shelterID = MainActivity.shelters.get(shelterName).getUid();
                int beds = Integer.parseInt(MainActivity.shelters.get(shelterName).getBeds());
                int put_beds_back = Integer.parseInt(users.get("danholli@gmail.com").getBeds_reserved());
                beds = beds + put_beds_back;
                if (beds + put_beds_back > (Integer.parseInt(MainActivity.shelters.get(shelterName).getCapacity()))) {
                    beds = Integer.parseInt(MainActivity.shelters.get(shelterName).getCapacity());
                }
                mDatabase.child("shelters").child(shelterID).child("beds").setValue(Integer.toString(beds));
                mDatabase.child("users").child("danholli").child("reserved_shelter").setValue("none");
                mDatabase.child("users").child("danholli").child("beds_reserved").setValue(Integer.toString(0));
            }
        });
        Button notifButton = (Button) findViewById(R.id.notifbutton);
        notifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShelterInfoActivity.this, NotifActivity.class);
                startActivity(intent);
            }
        });
    }
    //Back button.

    /**
     * Back button. When pressed, brings the user to the previous page.
     * @return boolean when the back button is pressed
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        this.finish();
        return true;
    }
}
