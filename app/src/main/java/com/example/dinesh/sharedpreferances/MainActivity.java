package com.example.dinesh.sharedpreferances;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.dinesh.sharedpreferances", Context.MODE_PRIVATE);
       /* sharedPreferences.edit().putString("username","Dinesh").apply();
        String username = sharedPreferences.getString("username","");
        Log.i("Username",username); */
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Monica");
        friends.add("Sachin");

        try {
            sharedPreferences.edit().putString("friends",ObjectSerialLizer.serialize(friends)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> newfriends = new ArrayList<>();
        try {
            newfriends = (ArrayList<String>) ObjectSerialLizer.deserialize(sharedPreferences.getString("friends",ObjectSerialLizer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
