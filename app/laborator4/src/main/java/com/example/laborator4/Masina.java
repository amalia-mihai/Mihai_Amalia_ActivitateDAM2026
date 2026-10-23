package com.example.laborator4;

import java.io.Serializable;

public class Masina implements Serializable {
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
