package gatech.cs2340.shelterme.shelterme_new.view;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Ally Liu on 2/26/2018.
 */

public class ShelterListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelterlist);

        //Toolbar stuff.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_shelterlist);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Hard-coded shelters. Need to put in real values.
        final ArrayList<String> shelters = new ArrayList<String>(Arrays.asList("Shelter 1",
                "Shelter 2",
                "Shelter 3",
                "Shelter 5",
                "Shelter 6",
                "Shelter 7",
                "Shelter 8",
                "Shelter 9"));

        //converts the string array into list object
        ListAdapter shelterListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shelters);
        ListView shelterListView = (ListView) findViewById(R.id.shelterList);
        shelterListView.setAdapter(shelterListAdapter);

        shelterListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        String shelterClicked = String.valueOf(adapterView.getItemAtPosition(position)); //gives the strong value of the shelter clicked (can be used in about)
                        //Toast.makeText(ShelterListActivity.this, shelterClicked, Toast.LENGTH_LONG).show();
                        String shelter = shelters.get(position);

                        Intent intent = new Intent(ShelterListActivity.this, ShelterInfoActivity.class);
                        intent.putExtra("name", shelter);
                        startActivity(intent);
                    }
                }
        );
    }
    //Back button.
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        this.finish();
        return true;
    }
}
