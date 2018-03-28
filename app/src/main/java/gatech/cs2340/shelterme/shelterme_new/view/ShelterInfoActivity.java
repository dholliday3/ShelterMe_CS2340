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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by Ally Liu on 2/27/2018.
 */

public class ShelterInfoActivity extends AppCompatActivity {


    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private Map<String, Shelter> shelters = MainActivity.shelters;
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
                beds--;
                if (beds - 1 < 0) {
                    beds = 0;
                }
                mDatabase.child("shelters").child(shelterID).child("beds").setValue(Integer.toString(beds));
            }
        });

        Button cancelButton = (Button) findViewById(R.id.cancelReserve);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String shelterID = MainActivity.shelters.get(shelterName).getUid();
                int beds = Integer.parseInt(MainActivity.shelters.get(shelterName).getBeds());
                beds++;
                if (beds + 1 > (Integer.parseInt(MainActivity.shelters.get(shelterName).getCapacity()))) {
                    beds = Integer.parseInt(MainActivity.shelters.get(shelterName).getCapacity());
                }
                mDatabase.child("shelters").child(shelterID).child("beds").setValue(Integer.toString(beds));
            }
        });
    }
    //Back button.
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        this.finish();
        return true;
    }
}
