package m4.cs2340.models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by danielholliday on 2/28/18.
 */
@Database(entities = {Shelter.class}, version = 1)
public abstract class ShelterRoomDatabase extends RoomDatabase {

    public abstract ShelterDao shelterDao();

    private static ShelterRoomDatabase INSTANCE;
    public static ShelterRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ShelterRoomDatabase.class) {
                if (INSTANCE == null) {
                    // create db here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        ShelterRoomDatabase.class, "shelter_database")
                        .build();
                }
            }
        }
        return INSTANCE;
    }
}
