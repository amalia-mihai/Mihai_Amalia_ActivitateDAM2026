package com.example.laborator4;

import static android.view.View.VISIBLE;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> elemente = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnAfisare = findViewById(R.id.afisare_BTN);
        btnAfisare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),ActivitateAfisare.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("lista", elemente);
                it.putExtras(bundle);
                startActivityForResult(it, 40);
            }
        });
    }

    public void deschidereActivitAdaugare(View view) {
        Intent it = new Intent(this, ActivitateAdaugare.class);
        startActivityForResult(it, 20);
    }

    public void deschidereActivitAI(View view) {
        Intent it = new Intent(this, ActivitateAI.class);
        startActivityForResult(it, 20);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        super.onActivityResult(requestCode, resultCode, data, caller);

        if (requestCode == 20) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                Masina masina = (Masina)bundle.getSerializable("masina");

                TextView tvRez = findViewById(R.id.rezultat_TV);
                tvRez.setVisibility(VISIBLE);
                tvRez.setText(masina.toString());

                //Toast.makeText(this, masina.toString(), LENGTH_LONG).show();

                elemente.add(masina.toString());
            }
        }else if(requestCode == 40) {
            if(resultCode == RESULT_OK) {
                elemente.clear();
                elemente.addAll(data.getStringArrayListExtra("listaRez"));
            }
        }
    }


}