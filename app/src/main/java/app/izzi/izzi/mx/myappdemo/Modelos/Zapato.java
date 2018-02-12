package app.izzi.izzi.mx.myappdemo.Modelos;

import java.io.Serializable;

/**
 * Created by qualtop on 11/02/18.
 */

public class Zapato implements Serializable{

    private String mZapato;

    public Zapato(String zapato) {
        mZapato = zapato;
    }

    public String getNombreZapato() {
        return mZapato;
    }

    public void setNombreZapato(String zapato) {
        mZapato = zapato;
    }
}
