package com.example.konechanlog.util;

import android.app.Activity;
import android.widget.ArrayAdapter;

import com.example.konechanlog.R;

public class SpinnerCase3 extends SpinnerCase {

    public SpinnerCase3() {
        super();
    }

    public void setAdapter() {
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.howto_array, android.R.layout.simple_spinner_item);

        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        getSpinner().setAdapter(adapter3);
    }
}
