package ch.wiss.einkaufsliste.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EinkaufsItem.class}, version = 7)
    
public abstract class AppDatabase extends RoomDatabase {
    public abstract EinkaufsItemDao einkaufsListeDao();
}
