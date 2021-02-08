package com.example.coverflow_itemclick.db;

import androidx.room.Room;

import com.example.coverflow_itemclick.App;

public class Db {

    private static AppDatabase db;

    public static AppDatabase getDb() {
        if (db == null) { // if null thi init and set values . after return , again after it is not null
            db = Room.databaseBuilder(App.INSTANCE, AppDatabase.class, "my_product")
                    .allowMainThreadQueries()
                    .build();
        }

        return db;
    }
}
