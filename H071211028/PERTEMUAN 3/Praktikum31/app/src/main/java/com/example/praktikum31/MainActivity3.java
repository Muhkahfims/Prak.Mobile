package com.example.praktikum31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    String namaLengkap, username, caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageView profil = findViewById(R.id.profil);
        ImageView photo = findViewById(R.id.photo);
        TextView tv_fullname = findViewById(R.id.nama);
        TextView tv_username = findViewById(R.id.user);
        TextView tv_caption = findViewById(R.id.caption);

        namaLengkap = getIntent().getStringExtra("namaLengkap");
        username = getIntent().getStringExtra("username");
        Photo pp = getIntent().getParcelableExtra("profil");
        Photo post = getIntent().getParcelableExtra("photo");
        caption = getIntent().getStringExtra("caption");

       profil.setImageURI(pp.getFotoUri());
       photo.setImageURI(post.getFotoUri());
       tv_caption.setText(caption);
       tv_fullname.setText(namaLengkap);
       tv_username.setText(username);
    }
}