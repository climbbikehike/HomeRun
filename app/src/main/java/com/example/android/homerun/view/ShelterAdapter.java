package com.example.android.homerun.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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
        // Note that the parent here is ListView in our activity_numbers.xml file
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            // listItemView = LayoutInflater.from(getContext()).inflate(R.layout.shelter_layout, parent, false);
            // listItemView is the LinearLayout with the two TextView children in word_pair_layout.xmlxml
            /**
             * Inflate a new view hierarchy from the specified xml resource.
             * resource	int: ID for an XML layout resource to load (e.g., R.layout.main_page)
             * root	ViewGroup: Optional view to be the parent of the generated hierarchy
             (if attachToRoot is true), or else simply an object that provides
             a set of LayoutParams values for root of the returned hierarchy (if attachToRoot is false.)
             attachToRoot boolean: Whether the inflated hierarchy should be attached to the root parameter?
             If false, root is only used to create the correct subclass of LayoutParams
             for the root view in the XML. We don't want to attach it to
             */
        }

        Shelter shelter = getItem(position);

        /* TextView englishWord = (TextView) listItemView.findViewById(R.id.english_word);
        TextView translatedWord = (TextView) listItemView.findViewById(R.id.translated_word);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.img);*/

        assert shelter != null;
        /* englishWord.setText(currData.getEnglishWord());
        translatedWord.setText(currData.getTranslatedWord());*/


        return listItemView;
    }

}
