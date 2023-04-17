package ch.wiss.einkaufsliste.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EinkaufsItemDao {
    @Insert
    void insertAll(EinkaufsItem... einkaufsItems);
    @Delete
    void delete(EinkaufsItem einkaufsItem);
    @Query("SELECT * FROM EinkaufsItem ORDER BY id")
    List<EinkaufsItem> getAll();
    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insertEinkaufsItem(EinkaufsItem einkaufsItem);
    @Update
    void updateEinkaufsItem(EinkaufsItem einkaufsItem);
}
