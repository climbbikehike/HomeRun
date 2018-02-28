package com.example.android.homerun.model;
import java.io.Serializable;

/**
 * Created by PC on 2/25/18.
 */

public class Shelter implements Serializable {
    private String id;
    private String name;
    private String capacity;
    private String restrictions;
    private double longitude;
    private double latitude;
    private String address;
    private String specialNotes;
    private String phoneNumber;


    public Shelter() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getAddress() {
        return address;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Shelter(String id, String name, String capacity, String restrictions, double longitude, double latitude, String address, String specialNotes, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.restrictions = restrictions;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.specialNotes = specialNotes;
        this.phoneNumber = phoneNumber;
    }
}
