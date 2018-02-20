package com.example.android.homerun.model;

import java.util.ArrayList;

/**
 * Created by PC on 2/19/18.
 */

public class DataHolder {
    private static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<User> getUsers() {return DataHolder.users;}
    public static void setUsers(ArrayList<User> users) {DataHolder.users = users;}
    public static void addUser(User user) {users.add(user);}
}
