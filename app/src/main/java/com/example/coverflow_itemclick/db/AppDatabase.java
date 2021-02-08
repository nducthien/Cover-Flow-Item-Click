package com.example.coverflow_itemclick.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.coverflow_itemclick.dao.ProductDao;
import com.example.coverflow_itemclick.entity.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
