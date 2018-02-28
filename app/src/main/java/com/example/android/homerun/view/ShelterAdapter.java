package com.example.android.homerun.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.homerun.R;
import com.example.android.homerun.model.Shelter;

import java.util.ArrayList;

/**
 * Created by PC on 2/27/18.
 */

public class ShelterAdapter extends ArrayAdapter<Shelter> {

    public ShelterAdapter(Context context, ArrayList<Shelter> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.shelter_list_item, parent, false);
        }

        Shelter shelter = getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.shelter_name);
        TextView capcity = (TextView) listItemView.findViewById(R.id.shelter_capacity);

        assert shelter != null;
        name.setText(shelter.getName());
        capcity.setText("Capacity: " + shelter.getCapacity());

        return listItemView;
    }

}
