package com.example.laborator4;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ActivitateAfisare extends AppCompatActivity {

    private MasinaAdapter adapter = null;
    private ArrayList<Masina> elemente;
    private int idModificat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_afisare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        elemente = new ArrayList<>(bundle.getParcelableArrayList("lista"));

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                elemente
//        );

        adapter = new MasinaAdapter(elemente, getApplicationContext(), R.layout.item_layout);

        ListView lvObiecte = findViewById(R.id.lista_obiecte_LV);
        lvObiecte.setAdapter(adapter);

        lvObiecte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentModifica = new Intent(getApplicationContext(), ActivitateAdaugare.class);
                intentModifica.putExtra("masina", elemente.get(position));
                idModificat = position;
                startActivityForResult(intentModifica, 209);
                Toast.makeText(getApplicationContext(), elemente.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lvObiecte.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                elemente.remove(position);
                adapter.notifyDataSetChanged();

                Intent it = new Intent();
                it.putExtra("listaRez", elemente);
                setResult(RESULT_OK, it);
                //finish(); //intoarcere in MainActivity
                //fara finish(), cu butonul back se intoarce si se modif lista (pt ca result ul este ok)

                return true;
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        super.onActivityResult(requestCode, resultCode, data, caller);
        if(resultCode == RESULT_OK){
            if(requestCode == 209){
                elemente.set(idModificat, data.getParcelableExtra("masina"));
                adapter.notifyDataSetChanged();

                Intent it = new Intent();
                it.putExtra("listaRez", elemente);
                setResult(RESULT_OK, it);
                //pt modificat lista init dupa modificare obiect
                //mai multe setResult() => pastrat ultimul
            }
        }
    }
}