package m4.cs2340.shelterme;

import android.app.Application;
import android.arch.persistence.room.Room;

import m4.cs2340.models.ShelterRoomDatabase;


/**
 * Created by danielholliday on 2/28/18.
 */

public class App extends Application{
    public static App INSTANCE;
    private static final String DATABASE_NAME = "shelter_database";

    private ShelterRoomDatabase database;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // create database
        database = Room.databaseBuilder(getApplicationContext(), ShelterRoomDatabase.class, DATABASE_NAME)
                .build();

        INSTANCE = this;
    }

    public ShelterRoomDatabase getDB() {
        return database;
    }
}
