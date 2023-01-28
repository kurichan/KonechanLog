package com.example.konechanlog.util;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

/**
 * SpinnerCase
 */
public abstract class SpinnerCase {

    private boolean signals;

    public boolean isSignals() {
        return signals;
    }

    public void setSignals(boolean signals) {
        this.signals = signals;
    }

    private String sel; /* */

    private List<String> selectItems;

    private Spinner spinner;

    private ArrayAdapter<CharSequence> adapter;

    private Activity activity;


    // constractor
    public SpinnerCase() {
        super();
    }

    public abstract void setAdapter();


    public void setAdapter(ArrayAdapter<CharSequence> adapter) {
        this.adapter = adapter;
    }

    public ArrayAdapter<CharSequence> getAdapter() {
        return adapter;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }


    public void setFocusable(boolean x) {

        spinner.setFocusable(x);

    }

    public boolean isFocusable() {

        boolean r = spinner.isFocusable();

        return r;
    }

    public void setEnabled(boolean y) {
        spinner.setEnabled(y);
    }

    public boolean getEnable() {
        if (spinner.isEnabled()) return true;
        else return false;
    }


    /* getter & setter begins */
    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public List<String> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<String> selectItems) {
        this.selectItems = selectItems;
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public void setSpinner(Spinner spinner) {
        this.spinner = spinner;
    }


    /* getter & setter ends */
}
