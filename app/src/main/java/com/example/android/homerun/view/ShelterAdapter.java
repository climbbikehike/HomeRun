package com.example.android.homerun.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.android.homerun.R;
import com.example.android.homerun.model.Shelter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by PC on 2/27/18.
 */

public class ShelterAdapter extends ArrayAdapter<Shelter> implements Filterable {

    private ArrayList<Shelter> arrayList;
    private ArrayList<Shelter> originalList; // Original Values

    public ShelterAdapter(Context context, ArrayList<Shelter> list) {
        super(context, 0, list);
        this.arrayList = list;
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
        TextView capacity = (TextView) listItemView.findViewById(R.id.shelter_capacity);

        assert shelter != null;
        name.setText(shelter.getName());
        capacity.setText("Capacity: " + shelter.getCapacity());

        return listItemView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                arrayList.clear();
                arrayList.addAll((ArrayList<Shelter>) results.values);
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<Shelter> filteredArrList = new ArrayList();

                if (originalList == null) {
                    originalList = new ArrayList(arrayList); // saves the original data in mOriginalValues
                }

                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = originalList.size();
                    results.values = originalList;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < originalList.size(); i++) {
                        String data = originalList.get(i).getName();
                        if (data.toLowerCase().startsWith(constraint.toString())) {
                            filteredArrList.add(originalList.get(i));
                        }
                    }
                    // set the Filtered result to return
                    results.count = filteredArrList.size();
                    results.values = filteredArrList;
                }
                return results;
            }
        };
        return filter;
    }
}
