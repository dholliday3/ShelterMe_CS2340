package gatech.cs2340.shelterme.shelterme_new.controller;

import gatech.cs2340.shelterme.shelterme_new.models.Shelter;

/**
 * Created by danielholliday on 3/8/18.
 */

public class PopulateShelters {

    static Shelter[] shelters;

    static String[][] shelterData = {
            {"0",   "My Sister's House",                            "264",	"Women/Children",	"-84.410142",	"33.780174",	"921 Howell Mill Road, Atlanta, Georgia 30318",	"Temporary, Emergency, Residential Recovery", "(404) 367-2465"},
            {"1",	"The Atlanta Day Center for Women & Children",	"140",	"Women/Children",	"-84.408771",	"33.784889",	"655 Ethel Street, Atlanta, Georgia 30318",	"Career Facilitation",	"(404) 588-4007"},
            {"2",	"The Shepherd's Inn",	                        "450",	"Men",	"-84.39265",	"33.765162",	"156 Mills Street, Atlanta, Georgia 30313",	"Temporary, Residential Recovery",	"(404) 367-2493"},
            {"3",	"Fuqua Hall",	                                 "92",	"Men",	"-84.392273",	"33.76515",	"144 Mills Street, Atlanta, Georgia 30313",	"Transitional housing",	"(404) 367-2492"},
            {"4",	"Atlanta's Children Center",	                 "40",	"Families w/ Children under 5",	"-84.384433",	"33.770949",	"607 Peachtree Street NE Atlanta, GA 30308",	"Children's programs, early childhood education",	"(404) 892-3713"},
            {"5",	"Eden Village", 	    "32 for families, 80 singles",	"Women/Children",	"-84.43023",	"33.762316",	"1300 Joseph E. Boone Blvd NW, Atlanta, GA 30314",	"General recovery services",	"(404)-874-2241"},
            {"6",	"Our House", 	                    "76 family rooms", 	"Families w/ newborns", 	"-84.371706",	"33.759138",	"173 Boulevard Northeast, Atlanta, GA 30312",	"Families w/ Newborns, Pre-K education","(404) 522-6056"},
            {"7",	"Covenant House Georgia", 	                     "80",	"Childrens/Young adults", 	"-84.437988",	"33.78823",	"1559 Johnson Road NW, Atlanta, GA 30318",	"Crisis services/Career Preparation",	"(404)-937-6957"},
            {"8",	"Nicholas House",                                  "",		"Families", 	"-84.367953",	"33.731823",	"830 Boulevard SE, Atlanta, GA 30312",	"Family services", 	"(404)-622-0793"},
            {"9",	"Hope Atlanta", 	                  "22 apartments",	"Anyone", 	"-84.390429",	"33.753594",	"34 Peachtree Street NW, Suite 700, Atlanta, GA 30303",	"Emergency shelter", 	"(404)-817-7070"},
            {"10",	"Gateway Center",	                    "330",	"Men", "-84.394529",	"33.747618",	"275 Pryor St. SW, Atlanta, GA 30303",	"Shelter and recovery services", 	"(404) 215-6600"},
            {"11",	"Young Adult Guidance Center", 	                 "12",	"Young adults", "-84.470567",	"33.789157",	"1230 Hightower Road NW Atlanta, GA 30318",	"Emergency, Independent living, Restoration", 	"(404) 792-7616"},
            {"12",	"Homes of Light",                                  "",		"Veterans", 	"-84.328691",	"33.747641",	"1800 Memorial Dr SE G3, Atlanta, GA 30317",	"Veterans", 	"(844) 289-8382"}
    };

    public static Shelter[] populateShelters() {

        for (int i = 0; i < 12; i++) {
            Shelter shelter = new Shelter(shelterData[i][0], shelterData[i][1], shelterData[i][2],
                        shelterData[i][3], shelterData[i][4], shelterData[i][5], shelterData[i][6],
                        shelterData[i][7], shelterData[i][8]);
            shelters[i] = shelter;
        }
        return shelters;
    }

    public static Shelter[] getShelters() {
        return populateShelters();
    }
}
