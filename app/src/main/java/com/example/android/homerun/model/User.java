package com.example.android.homerun.model;

/**
 * Created by PC on 2/19/18.
 */

public class User {
    private String name;
    private String username;
    private String password;
    private AccountType accountType;

    public User(String name, String username, String password, AccountType accountType) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public String getName() {return name;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public AccountType getAccountType() {return accountType;}
}
