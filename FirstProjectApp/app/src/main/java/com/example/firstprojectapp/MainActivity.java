package com.example.firstprojectapp;

/*
    Student name: Jose O Hidalgo Palacios.
    Email: Jose.Hidalgo.Palacios@student.lut.fi
    First project for Android Mobile Development Modle at LUT University
    the project should meet the three requirements are listed in the project task:
    1- Functionality with components
    2- multiple views
    3- A component to display information.
 */

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView menuListView;
    String[] menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        menuListView = (ListView) findViewById(R.id.menuListView);
        menu = res.getStringArray(R.array.menu);

        MyMenuAdapter menuAdapter = new MyMenuAdapter(this, menu); //there is already a menuAdapter within android.
        menuListView.setAdapter(menuAdapter);

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showMenuSelectionActivity;
                /*switch statement created to properly move to the correct activity depending
                on which one was selected. */
                switch (position){
                    case 0:
                        showMenuSelectionActivity = new Intent(getApplicationContext(), HeroesMenuActivity.class);
                    case 1:
                        //showMenuSelectionActivity = new Intent(getApplicationContext(), MapsMenuActivity.class);
                    default:
                        showMenuSelectionActivity = new Intent(getApplicationContext(), HeroesMenuActivity.class);

                }
                showMenuSelectionActivity.putExtra("com.example.firstprojectapp.MENU_SELECTION", position);
                startActivity(showMenuSelectionActivity);
            }
        });

    }
}