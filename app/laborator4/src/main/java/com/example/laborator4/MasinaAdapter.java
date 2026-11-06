package com.example.laborator4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class MasinaAdapter extends BaseAdapter {
    private List<Masina> masini;
    private Context ctx;
    private int resursaLayout;

    public MasinaAdapter(List<Masina> masini, Context ctx, int resursaLayout) {
        this.masini = masini;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return masini.size();
    }

    @Override
    public Object getItem(int position) {
        return masini.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        TextView marcaTV = v.findViewById(R.id.marcaTV);
        TextView modelTV = v.findViewById(R.id.modelTV);
        TextView combustibilTV = v.findViewById(R.id.combustibilTV);
        TextView notaTV = v.findViewById(R.id.notaTV);
        CheckBox dispCB = v.findViewById(R.id.disponibilitateCB);
        CheckBox nouCB = v.findViewById(R.id.maisnaNouaCB);

        Masina masina = (Masina)getItem(position);

        marcaTV.setText(masina.getMarca());
        modelTV.setText(masina.getModel());
        combustibilTV.setText(masina.getTipCombustibil());
        notaTV.setText(String.valueOf(masina.getRecenzieClienti()));
        dispCB.setChecked(masina.getEsteDisponibila());
        nouCB.setChecked(masina.getEsteNoua());

        return v;
    }
}
