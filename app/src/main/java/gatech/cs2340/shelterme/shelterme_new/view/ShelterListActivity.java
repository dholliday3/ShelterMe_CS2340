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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;
import gatech.cs2340.shelterme.shelterme_new.R;
import gatech.cs2340.shelterme.shelterme_new.controller.FilterShelters;

import android.view.Menu;
import android.view.MenuInflater;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Ally Liu on 2/26/2018.
 */

public class ShelterListActivity extends AppCompatActivity {
    public static String querySearch = "";

    private ArrayList<String> shelter_names = new ArrayList<>();
    private Set<String> shelterNameSet = new HashSet<>();
    ArrayAdapter<String> shelterListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelterlist);



        //Toolbar stuff.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_shelterlist);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("List of Shelters");

        for(String name : MainActivity.shelters.keySet()){
            shelter_names.add(name);
        }

        //converts the string array into list object
        shelterListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shelter_names);
        ListView shelterListView = (ListView) findViewById(R.id.shelterList);
        shelterListView.setAdapter(shelterListAdapter);

        shelterListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        String shelterClicked = String.valueOf(adapterView.getItemAtPosition(position)); //gives the strong value of the shelter clicked (can be used in about)
                        //Toast.makeText(ShelterListActivity.this, shelterClicked, Toast.LENGTH_LONG).show();
                        String shelter = shelter_names.get(position);

                        Intent intent = new Intent(ShelterListActivity.this, ShelterInfoActivity.class);
                        intent.putExtra("name", shelter);
                        startActivity(intent);
                    }
                }
        );


        // gets data from gender spinner and updates list show on search --> notifies listadapter
        // that the list has changed
        //Get data from spinners
        final Spinner genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        Spinner ageSpinner = (Spinner) findViewById(R.id.age_spinner);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String genderSelected = genderSpinner.getItemAtPosition(position).toString();

                if (genderSelected == "Male")
                    genderSelected = "Men";
                else if (genderSelected == "Female")
                    genderSelected = "Women";
                shelter_names = FilterShelters.filterShelterGender(genderSelected);
                shelterListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /* maybe use this.
        String genderSelected = genderSpinner.getSelectedItem().toString();
        String ageSelected = ageSpinner.getSelectedItem().toString();
        */

        //shelter_names = new FilterShelters().filterShelterGender(genderSelec)
    }
    //Back button.
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        this.finish();
        return true;
    }


    //Handles the Search Bar.
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
                                String shelter = shelter_names.get(position);

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
