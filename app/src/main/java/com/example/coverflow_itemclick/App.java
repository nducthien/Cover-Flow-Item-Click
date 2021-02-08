package com.example.coverflow_itemclick;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class App extends Application {

    public static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        Stetho.initializeWithDefaults(this);
    }
}
