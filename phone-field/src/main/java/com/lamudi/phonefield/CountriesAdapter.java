package com.lamudi.phonefield;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter for the countries list spinner
 * Created by Ismail on 5/6/16.
 */
public class CountriesAdapter extends ArrayAdapter<Country> implements SpinnerAdapter {

    private final LayoutInflater mInflater;

    public CountriesAdapter(Context context, List<Country> countries) {
        super(context, R.layout.item_country, R.id.name, countries);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Country country = getItem(position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.spinner_value, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.name);
        textView.setCompoundDrawablesWithIntrinsicBounds(country.getResId(getContext()), 0, 0, 0);
        textView.setText("+" + country.getDialCode());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_country, parent, false);
        }
        Country country = getItem(position);
        ((TextView) convertView).setText(country.getDisplayName() + " (+" + country.getDialCode() + ")");
        ((TextView) convertView).setCompoundDrawablesWithIntrinsicBounds(country.getResId(getContext()), 0, 0, 0);
        return convertView;
    }
}
