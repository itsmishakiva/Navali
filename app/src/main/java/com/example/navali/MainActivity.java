package com.example.navali;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

class Day {
    public static boolean day = true;
}

class SetEndPosition {
    public static boolean firstCreate = true;
}

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Day.day)
            setTheme(R.style.Theme_Navali);
        else
            setTheme(R.style.Theme_NavaliNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MotionLayout motionLayout = (MotionLayout) findViewById(R.id.motionLayout);
        if (!SetEndPosition.firstCreate) motionLayout.transitionToEnd();
        SetEndPosition.firstCreate = false;
        View view = findViewById(R.id.view);
        view.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
            }

            public void onSwipeRight() {
                motionLayout.transitionToEnd();
            }

            public void onSwipeLeft() {
                motionLayout.transitionToStart();
            }
            public void onSwipeBottom() {

            }

        });
    }

    public void changeTheme(View view) {
        /*int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentNightMode == Configuration.UI_MODE_NIGHT_NO){
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_YES);

        }
        else{
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO);

        }*/
        ImageView button = (ImageView) findViewById(R.id.backIcon4);
        button.setEnabled(false);
        ImageView buttonBack = (ImageView) findViewById(R.id.menuIcon);
        buttonBack.setEnabled(false);
        Day.day = !Day.day;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}