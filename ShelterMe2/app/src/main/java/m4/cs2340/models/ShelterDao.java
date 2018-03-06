package m4.cs2340.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by danielholliday on 2/28/18.
 */

@Dao
public interface ShelterDao {

    @Insert
    void insert(Shelter shelter);

    @Insert
    void insertAll(Shelter... shelters);

    @Query("DELETE FROM shelters_table")
    void deleteAll();

    @Query("SELECT * FROM shelters_table ORDER BY Unique_Key ASC")
    List<Shelter> getAllShelters();
}
