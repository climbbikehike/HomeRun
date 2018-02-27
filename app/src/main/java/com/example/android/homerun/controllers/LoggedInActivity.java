package com.example.android.homerun.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.homerun.R;
import com.example.android.homerun.model.FirebaseWrapper;
import com.example.android.homerun.model.Shelter;
import com.example.android.homerun.model.UtilityMethods;
import com.example.android.homerun.view.ShelterAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

public class LoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        Button logout_button = (Button) findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });

        DatabaseReference shelterRef = FirebaseDatabase.getInstance().getReference()
                .child(FirebaseWrapper.DATABASE_SHELTERS);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()) {
                    InputStream inputStream = getResources().openRawResource(R.raw.shelter);
                    UtilityMethods.createShelterDatabase(inputStream);
                }
                ArrayList<Shelter> shelterList = new ArrayList<>();
                for (DataSnapshot shelterDataSnapshot: dataSnapshot.getChildren()) {
                    shelterList.add(shelterDataSnapshot.getValue(Shelter.class));
                }

                ArrayAdapter<Shelter> shelterAdapter = new ShelterAdapter(LoggedInActivity.this, shelterList);

                /* ListView listView = (ListView) findViewById(R.id.list);
                assert listView != null;
                listView.setAdapter(shelterAdapter);
                listView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                    /*
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        // TODO Auto-generated method stub
                        // Log.d("############","Items " +  MoreItems[arg2] );
                    }

                }); */
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Firebase", "loadPost:onCancelled", databaseError.toException());
            }
        };
        shelterRef.addListenerForSingleValueEvent(eventListener);
    }

    @Override
    public void onBackPressed()
    {

    }
}