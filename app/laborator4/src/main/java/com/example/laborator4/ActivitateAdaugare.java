package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateAdaugare extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_adaugare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it = getIntent();
        if(it.hasExtra("masina")){
            Masina masina = it.getParcelableExtra("masina");
            EditText etMarca = findViewById(R.id.marca_ET);
            EditText etModel = findViewById(R.id.model_ET);
            Spinner spCombustibil = findViewById(R.id.combustibil_spinner);
            RatingBar rbRecenzii = findViewById(R.id.recenzii_RB);
            CheckBox cbNoua = findViewById(R.id.noua_CB);
            Switch swDisponibila = findViewById(R.id.disponibila_switch);

            etMarca.setText(masina.getMarca());
            etModel.setText(masina.getModel());

            String combustibil = masina.getTipCombustibil();
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) spCombustibil.getAdapter();
            int pozitie = adapter.getPosition(combustibil);
            if (pozitie >= 0) {
                spCombustibil.setSelection(pozitie);
            }
            rbRecenzii.setRating(masina.getRecenzieClienti());
            cbNoua.setChecked(masina.getEsteNoua());
            swDisponibila.setChecked(masina.getEsteDisponibila());
        }
    }

    public void trimitereInstanta(View view) {
        EditText etMarca = findViewById(R.id.marca_ET);
        EditText etModel = findViewById(R.id.model_ET);
        Spinner spCombustibil = findViewById(R.id.combustibil_spinner);
        RatingBar rbRecenzii = findViewById(R.id.recenzii_RB);
        CheckBox cbNoua = findViewById(R.id.noua_CB);
        Switch swDisponibila = findViewById(R.id.disponibila_switch);

        String marca = etMarca.getText().toString();
        String model = etModel.getText().toString();
        String tipCombustibil = spCombustibil.getSelectedItem().toString();
        Float recenzii = rbRecenzii.getRating();
        Boolean esteNoua = cbNoua.isChecked();
        Boolean esteDisponibila = swDisponibila.isChecked();

        Masina masina = new Masina(marca, model, tipCombustibil, recenzii, esteDisponibila, esteNoua);
        //Log.i("Test", masina.toString());

        Intent it = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("masina", masina);

        it.putExtras(bundle); //putExtras pt bundle, putExtra pt int, string etc.
        setResult(RESULT_OK, it);
        finish();
    }
}