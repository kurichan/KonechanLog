package com.example.konechanlog.util;

import android.widget.ArrayAdapter;

import com.example.konechanlog.R;

public class SpinnerCase2 extends SpinnerCase {

    public SpinnerCase2() {
        super();
    }


    public void setAdapter() {
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.whatis_arry, android.R.layout.simple_spinner_item);

        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        getSpinner().setAdapter(adapter2);
    }
}
