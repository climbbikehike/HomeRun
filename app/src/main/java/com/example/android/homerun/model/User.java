package com.example.android.homerun.model;

/**
 * Created by PC on 2/19/18.
 */

public class User {
    private String name;
    private String id;
    private String password;
    private AccountType accountType;

    public User(String name, String id, String password, AccountType accountType) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.accountType = accountType;
    }

    public String getName() {return name;}
    public String getId() {return id;}
    public String getPassword() {return password;}
    public AccountType getAccountType() {return accountType;}
}
