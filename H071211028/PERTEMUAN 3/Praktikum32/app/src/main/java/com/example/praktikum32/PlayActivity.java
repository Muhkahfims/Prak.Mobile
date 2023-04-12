package com.example.praktikum32;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    private ImageView profil;
    private TextView name, bestScore;
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        profil = findViewById(R.id.iv_profil);
        name = findViewById(R.id.tv_name);
        bestScore = findViewById(R.id.tv_bestScore);
        play = findViewById(R.id.btn_play);
    }
}