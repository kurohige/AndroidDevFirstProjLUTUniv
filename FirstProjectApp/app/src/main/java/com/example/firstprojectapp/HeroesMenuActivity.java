package com.example.firstprojectapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HeroesMenuActivity extends AppCompatActivity {


    //Heroes MenuActivity, the purpose of this activity is to populate the list view, menu_listview_detail
    // This activity will reuse the same layout that was created for the main Activity menu.
    ListView heroListView;
    String[] hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_menu);

        Resources res = getResources();
        heroListView = (ListView) findViewById(R.id.heroListView);
        hero = res.getStringArray(R.array.heroes);

        MyMenuAdapter menuAdapter = new MyMenuAdapter(this, hero); //there is already a menuAdapter within android.
        heroListView.setAdapter(menuAdapter);

        heroListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showMenuSelectionActivity;
                showMenuSelectionActivity = new Intent(getApplicationContext(), HeroSelectedActivity.class);
                showMenuSelectionActivity.putExtra("com.example.firstprojectapp.HERO_SELECTION", position);
                startActivity(showMenuSelectionActivity);
            }
        });
    }
}