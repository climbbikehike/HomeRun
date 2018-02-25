package com.example.android.homerun.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by PC on 2/25/18.
 */

public class FirebaseWrapper {
    public static FirebaseAuth mFirebaseAuth  = FirebaseAuth.getInstance();
    public static FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
}
