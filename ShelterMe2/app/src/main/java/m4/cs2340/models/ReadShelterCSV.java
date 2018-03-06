package m4.cs2340.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielholliday on 2/28/18.
 */

public class ReadShelterCSV {

    //read in csv file --> return nested list
    private final List<List<String>> shelterRawList = new ArrayList<List<String>>();

    public List<List<String>> getShelterRawList() {return shelterRawList;}


    /*
    // read in data
    //https://stackoverflow.com/questions/43055661/reading-csv-file-in-android-app

    private void readData() {
        InputStream is = getResources().openRawResource(R.raw.shelterdatabase);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                //set splitter
                String[] tokens = line.split(",");

                //read the data
                WellData wellData = new WellData();
                wellData.setOwner(tokens[0]);
                wellData.setApi(tokens[1]);
                wellData.setLongitude(tokens[2]);
                wellData.setLatitude(tokens[3]);
                wellData.setProperty(tokens[4]);
                wellData.setWellName(tokens[5]);
                wellDataList.add(wellData);

                Log.d("MainActivity" ,"Just Created " +wellData);

            }
        } catch (IOException e1) {
            Log.e("MainActivity", "Error" + line, e1);
            e1.printStackTrace();
        }
    }
    */
}
