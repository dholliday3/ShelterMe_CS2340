package gatech.cs2340.shelterme.shelterme_new.view;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;
import gatech.cs2340.shelterme.shelterme_new.R;
import gatech.cs2340.shelterme.shelterme_new.controller.FilterShelters;
import gatech.cs2340.shelterme.shelterme_new.model.AgeGroup;
import gatech.cs2340.shelterme.shelterme_new.model.Gender;

import android.view.Menu;
import android.view.MenuInflater;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Ally Liu on 2/26/2018.
 */

public class ShelterListActivity extends AppCompatActivity {
    public static String querySearch = "";

    private ArrayList<String> shelterNames = new ArrayList<>();
    ArrayAdapter<String> shelterListAdapter;

    private Spinner genderSpinner, ageSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelterlist);

        //Toolbar stuff
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_shelterlist);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("List of Shelters");

        //populate search based on shelters --> initially from setShelterNames
        setShelterNames();
        populateShelterSearch();

        //set spinners
        genderSpinner = findViewById(R.id.gender_spinner);
        ageSpinner = findViewById(R.id.age_spinner);
        addAgeSpinnerListener();
        addGenderSpinnerListener();

    }
    //Back button.

    /**
     * populates shelterList into a listview on the search
     */
    private void populateShelterSearch() {
        //converts the string array into list object
        shelterListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shelterNames);
        ListView shelterListView = (ListView) findViewById(R.id.shelterList);
        shelterListView.setAdapter(shelterListAdapter);

        shelterListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        String shelterClicked = String.valueOf(adapterView.getItemAtPosition(position)); //gives the strong value of the shelter clicked (can be used in about)
                        String shelter = shelterNames.get(position);

                        Intent intent = new Intent(ShelterListActivity.this, ShelterInfoActivity.class);
                        intent.putExtra("name", shelter);
                        startActivity(intent);
                    }
                }
        );
    }

    /**
     * class that populates the shelter list --> originally with the data from the database
     */
    private void setShelterNames() {
        shelterNames.addAll(MainActivity.shelters.keySet());
        shelterNames = new ArrayList<>(new HashSet<>(shelterNames));
    }

    /**
     * sets items on gender spinner and handles events
     */
    private void addGenderSpinnerListener() {
        //Spinner genderSpinner = findViewById(R.id.gender_spinner);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String genderItem = parent.getSelectedItem().toString();
                String ageItem = ageSpinner.getSelectedItem().toString();

                switch (genderItem) {
                    case "not-specified":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, ageItem);
                        populateShelterSearch();
                        break;
                    case "Male":
                        shelterNames = FilterShelters.filterGenderAge(Gender.MALE.getGender(), ageItem);
                        populateShelterSearch();
                        break;
                    case "Female":
                        shelterNames = FilterShelters.filterGenderAge(Gender.FEMALE.getGender(), ageItem);
                        populateShelterSearch();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    /**
     * sets items on age spinner and handles events
     */
    private void addAgeSpinnerListener() {
        //Spinner ageSpinner = findViewById(R.id.age_spinner);

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ageItem = parent.getSelectedItem().toString();
                String genderItem = genderSpinner.getSelectedItem().toString();

                //convert "Female/Male" shown on spinner to proper string used in controller logic
                genderItem = (genderItem.equals("Female")) ? Gender.FEMALE.getGender() : Gender.MALE.getGender();

                switch (ageItem) {
                    case "not-specified":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, ageItem);
                        populateShelterSearch();
                        break;
                    case "Families":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, AgeGroup.FAMILIES.getAgeGroup());
                        populateShelterSearch();
                        break;
                    case "Children":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, AgeGroup.CHILDREN.getAgeGroup());
                        populateShelterSearch();
                        break;
                    case "Young adults":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, AgeGroup.YOUNG_ADULTS.getAgeGroup());
                        populateShelterSearch();
                        break;
                    case "Anyone":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, AgeGroup.ANYONE.getAgeGroup());
                        populateShelterSearch();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    /**
     * Back Button. When pressed, brings the user to the previous page
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        this.finish();
        return true;
    }


    /**
     * Used to handle the search bar.
     * @param menu
     * @return boolean telling the menu was created
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setIconifiedByDefault(false);
            searchView.setQueryHint("Search shelters");
        }
        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            public boolean onQueryTextChange(String newText) {
                // this is your adapter that will be filtered
                querySearch = newText;
                return true;
            }

            public boolean onQueryTextSubmit(String query) {
//              Here u can get the value "query" which is entered in the search box.
                ArrayList<String> searchedShelter = new ArrayList<String>();
                searchedShelter.add(query);
                ListAdapter shelterListAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, searchedShelter);
                ListView shelterListView = (ListView) findViewById(R.id.shelterList);
                shelterListView.setAdapter(shelterListAdapter);

                shelterListView.setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                String shelterClicked = String.valueOf(adapterView.getItemAtPosition(position)); //gives the strong value of the shelter clicked (can be used in about)
                                //Toast.makeText(ShelterListActivity.this, shelterClicked, Toast.LENGTH_LONG).show();
                                String shelter = shelterNames.get(position);

                                Intent intent = new Intent(ShelterListActivity.this, ShelterInfoActivity.class);
                                intent.putExtra("name", shelter);
                                startActivity(intent);
                            }
                        }
                );
                return true;
            }
        };
        searchView.setOnQueryTextListener(queryTextListener);

        return super.onCreateOptionsMenu(menu);
    }

}
