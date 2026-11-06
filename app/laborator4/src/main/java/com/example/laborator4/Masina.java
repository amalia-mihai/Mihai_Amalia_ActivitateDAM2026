package com.example.laborator4;

import android.os.Parcel;
import android.os.Parcelable;

public class Masina implements Parcelable {
    private String marca;
    private String model;
    private String tipCombustibil;
    private Float recenzieClienti;
    private Boolean esteDisponibila;
    private Boolean esteNoua;

    public Masina(String marca, String model, String tipCombustibil, Float recenzieClienti, Boolean esteDisponibila, Boolean esteNoua) {
        this.marca = marca;
        this.model = model;
        this.tipCombustibil = tipCombustibil;
        this.recenzieClienti = recenzieClienti;
        this.esteDisponibila = esteDisponibila;
        this.esteNoua = esteNoua;
    }

    public Masina() {
    }

    protected Masina(Parcel in) {
        marca = in.readString();
        model = in.readString();
        tipCombustibil = in.readString();
        if (in.readByte() == 0) {
            recenzieClienti = null;
        } else {
            recenzieClienti = in.readFloat();
        }
        byte tmpEsteDisponibila = in.readByte();
        esteDisponibila = tmpEsteDisponibila == 0 ? null : tmpEsteDisponibila == 1;
        byte tmpEsteNoua = in.readByte();
        esteNoua = tmpEsteNoua == 0 ? null : tmpEsteNoua == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(marca);
        dest.writeString(model);
        dest.writeString(tipCombustibil);
        if (recenzieClienti == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(recenzieClienti);
        }
        dest.writeByte((byte) (esteDisponibila == null ? 0 : esteDisponibila ? 1 : 2));
        dest.writeByte((byte) (esteNoua == null ? 0 : esteNoua ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Masina> CREATOR = new Creator<Masina>() {
        @Override
        public Masina createFromParcel(Parcel in) {
            return new Masina(in);
        }

        @Override
        public Masina[] newArray(int size) {
            return new Masina[size];
        }
    };

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTipCombustibil() {
        return tipCombustibil;
    }

    public void setTipCombustibil(String tipCombustibil) {
        this.tipCombustibil = tipCombustibil;
    }

    public Float getRecenzieClienti() {
        return recenzieClienti;
    }

    public void setRecenzieClienti(Float recenzieClienti) {
        this.recenzieClienti = recenzieClienti;
    }

    public Boolean getEsteDisponibila() {
        return esteDisponibila;
    }

    public void setEsteDisponibila(Boolean esteDisponibila) {
        this.esteDisponibila = esteDisponibila;
    }

    public Boolean getEsteNoua() {
        return esteNoua;
    }

    public void setEsteNoua(Boolean esteNoua) {
        this.esteNoua = esteNoua;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", tipCombustibil='" + tipCombustibil + '\'' +
                ", recenzieClienti=" + recenzieClienti +
                ", esteDisponibila=" + esteDisponibila +
                ", esteNoua=" + esteNoua +
                '}';
    }
}
