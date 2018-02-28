package com.example.android.homerun.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle("Shelters");

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

                ArrayAdapter<Shelter> shelterAdapter = new ShelterAdapter(DashboardActivity.this, shelterList);

                ListView listView = (ListView) findViewById(R.id.shelter_list);
                assert listView != null;
                listView.setAdapter(shelterAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View v, int position,
                                            long arg3)
                    {
                        Shelter shelter = (Shelter) adapter.getItemAtPosition(position);
                        Intent intent = new Intent(DashboardActivity.this, ShelterDetailActivity.class);
                        intent.putExtra("ShelterData", shelter);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Firebase", "loadPost:onCancelled", databaseError.toException());
            }
        };
        shelterRef.addListenerForSingleValueEvent(eventListener);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        dlgAlert.setMessage("Are you sure you want to logout?");
        dlgAlert.setTitle("Logout Confirmation");
        dlgAlert.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        finish();
                    }
                });
        dlgAlert.create().show();
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout_action) {
            FirebaseAuth.getInstance().signOut();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}