package com.example.khans.phone2action;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        Log.i("test", "test");
        try {
            APIHelper helper = new APIHelper("Alexandria VA", getApplicationContext());
            Log.i("tag", helper.getRepresentativesByAddress());
        }catch(Exception e){
            Log.i("Error", e.toString());
        }
        setContentView(R.layout.activity_main);
    }
}
