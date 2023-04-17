package ch.wiss.einkaufsliste.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EinkaufsItem {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private double menge;
    @NonNull
    private String einheit;
    @NonNull
    private boolean erledigt;
    @NonNull
    private String ort;

    public EinkaufsItem(){
    }
    public EinkaufsItem(long id,
                        @NonNull String name,
                        @NonNull double menge,
                        @NonNull String einheit,
                        @NonNull boolean erledigt,
                        @NonNull String ort) {
        this.id = id;
        this.name = name;
        this.menge = menge;
        this.einheit = einheit;
        this.erledigt = erledigt;
        this.ort = ort;
    }

    public EinkaufsItem(@NonNull String name,
                        @NonNull double menge,
                        @NonNull String einheit,
                        @NonNull boolean erledigt,
                        @NonNull String ort) {
        this.name = name;
        this.menge = menge;
        this.einheit = einheit;
        this.erledigt = erledigt;
        this.ort = ort;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public double getMenge() {
        return menge;
    }

    public void setMenge(double menge) {
        this.menge = menge;
    }

    @NonNull
    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(@NonNull String einheit) {
        this.einheit = einheit;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }

    @NonNull
    public String getOrt() {
        return ort;
    }

    public void setOrt(@NonNull String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return name + ", " + menge + " " + einheit + ", " + ort;
    }
}
