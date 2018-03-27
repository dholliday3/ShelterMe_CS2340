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

/**
 * Created by Ally Liu on 2/27/2018.
 */

public class ShelterInfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button reserveBed = (Button) findViewById(R.id.reserveBed);
        reserveBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               updateCapacity();

            }
        });

                //Toolbar stuff.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shelter Page");

        //Code that gets information from the ListView.
        String shelterName = this.getIntent().getExtras().getString("name");

        TextView nameTV = findViewById(R.id.shelterName_textview);
        nameTV.setText(shelterName);

        TextView addressTV = findViewById(R.id.address);
        addressTV.setText("Address: " + MainActivity.shelters.get(shelterName).address);

        TextView phoneTV = findViewById(R.id.phoneNumber);
        phoneTV.setText("Phone Number: " + MainActivity.shelters.get(shelterName).phone_number);

        TextView capacityTV = findViewById(R.id.capacity);
        capacityTV.setText("Capacity: " + MainActivity.shelters.get(shelterName).capacity);

        TextView restrictionsTV = findViewById(R.id.restrictions);
        restrictionsTV.setText("Restrictions: " + MainActivity.shelters.get(shelterName).restrictions);

        TextView special_notesTV = findViewById(R.id.specialNotes);
        special_notesTV.setText("Special Notes: " + MainActivity.shelters.get(shelterName).special_notes);


    }
    //Back button.
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        this.finish();
        return true;
    }

    private void updateCapacity() {
        String shelterName = this.getIntent().getExtras().getString("name");
        int capacity = Integer.parseInt(MainActivity.shelters.get(shelterName).capacity);
        capacity--;
        MainActivity.shelters.get(shelterName).capacity = Integer.toString(capacity);
    }


}
