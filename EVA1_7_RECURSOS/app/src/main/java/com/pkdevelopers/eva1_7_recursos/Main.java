package com.pkdevelopers.eva1_7_recursos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main extends AppCompatActivity {

    ImageView imgMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMostrar = findViewById(R.id.imgMostrar);
        imgMostrar.setImageResource(R.drawable.gg);
    }
}
