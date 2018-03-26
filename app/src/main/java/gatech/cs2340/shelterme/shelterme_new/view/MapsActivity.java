package gatech.cs2340.shelterme.shelterme_new.view;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import gatech.cs2340.shelterme.shelterme_new.R;
import gatech.cs2340.shelterme.shelterme_new.controller.FilterShelters;
import gatech.cs2340.shelterme.shelterme_new.model.AgeGroup;
import gatech.cs2340.shelterme.shelterme_new.model.Gender;
import gatech.cs2340.shelterme.shelterme_new.model.Shelter;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Map<String, Shelter> shelters = MainActivity.shelters;
    private ArrayList<String> shelterNames = new ArrayList<>();

    private Spinner genderSpinner, ageSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //set shelter data
        setShelterNames();

        //add listeners
        genderSpinner = findViewById(R.id.gender_spinner);
        ageSpinner = findViewById(R.id.age_spinner);
        addAgeSpinnerListener();
        addGenderSpinnerListener();
    }

    /**
     * class that populates the shelter list --> originally with the data from the database
     */
    private void setShelterNames() {
        shelterNames.addAll(MainActivity.shelters.keySet());
        shelterNames = new ArrayList<>(new HashSet<>(shelterNames));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //randomly select a shelter for moveCamera() --> replace with better solution
        Random rand = new Random();
        List<String> keys = new ArrayList<>(shelters.keySet());
        String randKey = keys.get(rand.nextInt(keys.size()));
        Shelter randVal = shelters.get(randKey);
        LatLng cameraLocation = new LatLng(Double.parseDouble(randVal.getLatitude()), Double.parseDouble(randVal.getLongitude()));

        populateSheltersOnMap();
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cameraLocation, 11.0f));

    }

    private void populateSheltersOnMap() {
        double lat;
        double lon;
        LatLng location;

        Log.d("populateSheltersOnMap:", shelterNames.size() + "" );

        //clear map
        mMap.clear();


        for (String shelter: shelterNames) {
            lat = Double.parseDouble(shelters.get(shelter).getLatitude());
            lon = Double.parseDouble(shelters.get(shelter).getLongitude());
            location = new LatLng(lat, lon);
            mMap.addMarker(new MarkerOptions().position(location).title(shelters.get(shelter).getShelter_name()));
        }
    }

    // *************** filter related ******************* //
    /**
     * sets items on gender spinner and handles events
     *
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
                        populateSheltersOnMap();
                        break;
                    case "Male":
                        shelterNames = FilterShelters.filterGenderAge(Gender.MALE.getGender(), ageItem);
                        populateSheltersOnMap();
                        break;
                    case "Female":
                        shelterNames = FilterShelters.filterGenderAge(Gender.FEMALE.getGender(), ageItem);
                        populateSheltersOnMap();
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
     *
     */
    private void addAgeSpinnerListener() {
        //Spinner ageSpinner = findViewById(R.id.age_spinner);

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ageItem = parent.getSelectedItem().toString();
                String genderItem = genderSpinner.getSelectedItem().toString();

                switch (ageItem) {
                    case "not-specified":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, ageItem);
                        populateSheltersOnMap();
                        break;
                    case "Families":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, AgeGroup.FAMILIES.getAgeGroup());
                        populateSheltersOnMap();
                        break;
                    case "Children":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, AgeGroup.CHILDREN.getAgeGroup());
                        populateSheltersOnMap();
                        break;
                    case "Young adults":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, AgeGroup.YOUNG_ADULTS.getAgeGroup());
                        populateSheltersOnMap();
                        break;
                    case "Anyone":
                        shelterNames = FilterShelters.filterGenderAge(genderItem, AgeGroup.ANYONE.getAgeGroup());
                        populateSheltersOnMap();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
