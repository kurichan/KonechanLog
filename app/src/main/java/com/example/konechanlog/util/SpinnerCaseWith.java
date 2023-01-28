package com.example.konechanlog.util;

import android.widget.ArrayAdapter;

public class SpinnerCaseWith extends SpinnerCase {

    private String aux;

    @Override
    public void setAdapter() {

    }

    public SpinnerCaseWith() {
        super();
        aux = "";
    }

    /* getter& setter begins */
    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }
    /* getter & setter ends */
}
