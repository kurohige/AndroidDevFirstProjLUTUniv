package com.example.firstprojectapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HeroSelectedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_selected);
        Resources res = getResources(); // get resources for heroes and hero array.
        Intent in = getIntent(); // get positioning from the previous activity
        int index = in.getIntExtra("com.example.firstprojectapp.HERO_SELECTION", -1);
        String[] heroInfo;
        int pic;
        ImageView img = (ImageView) findViewById(R.id.heroImgView);

        //Declare TextViews and strings to be populated:
        String heroName, heroRole, heroDifficulty, heroUniverse,heroDescription;
        TextView heroNameTxtView = (TextView) findViewById(R.id.heroNameTxtView);
        TextView heroRoleTxtView = (TextView) findViewById(R.id.heroRoleTxtView);
        TextView heroDifficultyTxtView = (TextView) findViewById(R.id.heroDifficultieTxtView);
        TextView heroUniverseTxtView = (TextView) findViewById(R.id.heroUniTxtView);
        //TextView heroDescriptionTxtView = (TextView) findViewById(R.id.heroDescriptionTxtView);

        /*switch was created to retrieve the proper heroes selection information, in the future
        I'm planning to create a class of its own that will retrieve the hero information and return it
        in the manner of a string[], for the moment I'll submit the project with this. */
        switch (index){
            case 0:
                heroInfo = res.getStringArray(R.array.alarak);
                pic = R.drawable.hero_alarak;
                scaleImg(img,pic);
                break;
            case 1:
                heroInfo = res.getStringArray(R.array.ana);
                pic = R.drawable.hero_ana;
                scaleImg(img,pic);
                break;
            case 2:
                heroInfo = res.getStringArray(R.array.artanis);
                pic = R.drawable.hero_artanis;
                scaleImg(img,pic);
                break;
            default:
                heroInfo = res.getStringArray(R.array.alarak);
                pic = R.drawable.hero_alarak;
                scaleImg(img,pic);
        }
        //set variables values
        heroName = heroInfo[0];
        heroRole = heroInfo[1];
        heroDifficulty = heroInfo[2];
        heroUniverse = heroInfo[3];
        //heroDescription = heroInfo[4];

        //set txtview values
        heroNameTxtView.setText(heroName);
        heroRoleTxtView.setText(heroRole);
        heroUniverseTxtView.setText(heroUniverse);
        heroDifficultyTxtView.setText(heroDifficulty);
        //heroDescriptionTxtView.setText(heroDescription);


    }

    private  void scaleImg(ImageView img, int pic)
    {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth){
            int ratio = Math.round( (float) imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaleImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaleImg);
    }
}