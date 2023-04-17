package ch.wiss.einkaufsliste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AddItemActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtMenge;
    private TextView txtEinheit;
    private TextView txtOrt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        txtName = findViewById(R.id.textName);
        txtMenge = findViewById(R.id.textMenge);
        txtEinheit = findViewById(R.id.textEinheit);
        txtOrt = findViewById(R.id.textOrt);
    }

    public void save(View v){
        Intent indy = new Intent();
        indy.putExtra("Name", txtName.getText().toString());
        indy.putExtra("Menge", txtMenge.getText().toString());
        indy.putExtra("Einheit", txtEinheit.getText().toString());
        indy.putExtra("Ort", txtOrt.getText().toString());
        setResult(RESULT_OK,indy);
        Log.d("Values", "Values saved");
        finish();
    }
}