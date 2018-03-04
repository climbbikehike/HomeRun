package com.example.android.homerun.model;

/**
 * Created by PC on 3/4/18.
 */

public enum AgeCategories {
    FAMILIES_WITH_NEWBORNS ("Families w/ newborns"), CHILDREN ("Children"),
    YOUNG_ADULTS ("Young adults"), ANYONE ("Anyone");

    private String type;

    AgeCategories(String s) {
        type = s;
    }

    public String toString() {
        return this.type;
    }
}
