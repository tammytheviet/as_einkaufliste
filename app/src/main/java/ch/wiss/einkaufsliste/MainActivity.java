package ch.wiss.einkaufsliste;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.room.Room;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.List;

        import ch.wiss.einkaufsliste.model.AppDatabase;
        import ch.wiss.einkaufsliste.model.EinkaufsItem;
        import ch.wiss.einkaufsliste.model.EinkaufsItemDao;

public class MainActivity extends AppCompatActivity {

    List<EinkaufsItem> einkaufsListe = new ArrayList<>();
    AppDatabase db;
    EinkaufsItemDao dao;
    private static final int SINGLE_CHOICE =
            android.R.layout.simple_list_item_single_choice;
    ArrayAdapter<EinkaufsItem> einkaufsListeArrayAdapter;
    ListView listView;

    String name;
    Double menge;
    String stringMenge;
    String einheit;
    String ort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(
                        this, AppDatabase.class, "amigos")
                .fallbackToDestructiveMigration()
                .build();
        dao = db.einkaufsListeDao();
        einkaufsListe = new ArrayList<>();
        listView = findViewById(R.id.ListeEinkaufsItems);

        // Item hinzufügen
        /*(new Thread(() -> {
            EinkaufsItem item = new EinkaufsItem(2, "popcat", 3.0, "t", false, "popcat");
            dao.insertEinkaufsItem(item);
        })).start();*/

        einkaufsListeArrayAdapter = new ArrayAdapter<>(this,
                SINGLE_CHOICE, einkaufsListe);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(einkaufsListeArrayAdapter);
        updateListView();

        listView.setOnItemClickListener(radio_listener);
    }

    ListView.OnItemClickListener radio_listener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
            EinkaufsItem selectedItem = einkaufsListeArrayAdapter.getItem(index);
            Intent indy = new Intent();
        }
    };
    private void updateListView(){
        (new Thread(() -> {
            einkaufsListe.clear();
            for (EinkaufsItem m : dao.getAll()) {
                Log.d("DAO", m.getName());
                einkaufsListe.add(m);
            }
            runOnUiThread(() -> {
                einkaufsListeArrayAdapter.notifyDataSetChanged();
            });
        })).start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    public void onClickButton(View v){
        Intent indy = new Intent(this, AddItemActivity.class);
        startActivityForResult(indy, 20);
    }

    protected void onActivityResult(int requestId, int result, Intent i) {
        super.onActivityResult(requestId, result, i);
        Log.d("Intent", i.toString());
        name = i.getStringExtra("Name");
        stringMenge = i.getStringExtra("Menge");
        einheit = i.getStringExtra("Einheit");
        ort = i.getStringExtra("Ort");

        menge = Double.parseDouble(stringMenge);

        (new Thread(() -> {
            EinkaufsItem item = new EinkaufsItem(name, menge, einheit, false, ort);
            dao.insertEinkaufsItem(item);
            Log.d("Test", "Test");
            updateListView();
        })).start();
    }
}