package com.example.praktikum31;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private ImageView photo;
    private EditText caption;
    private Button btnUpload;
    Photo foto,profil;
    boolean isEmpty = false;

    private ActivityResultLauncher<Intent> launcherIntentImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result){
                    if (result.getResultCode() == RESULT_OK && result.getData() != null){
                        Uri selectedPhoto = result.getData().getData();
                        photo.setImageURI(selectedPhoto);
                        foto.setFotoUri(selectedPhoto);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        photo = findViewById(R.id.photo);
        caption = findViewById(R.id.caption);
        btnUpload = findViewById(R.id.upload);

        foto = new Photo();

        Intent intent = getIntent();
        String namaLengkap = intent.getStringExtra("namaLengkap");
        String username = intent.getStringExtra("username");
        profil = intent.getParcelableExtra("photo");


        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
                intentPicker.setType("image/*");
                launcherIntentImage.launch(Intent.createChooser(intentPicker, "pilih foto"));
            }
        });


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(foto.getFotoUri() == null) {
                    Toast.makeText(MainActivity2.this, "isi foto", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isEmpty){

                    Intent upload = new Intent(getApplicationContext(), MainActivity3.class);
                    upload.putExtra("photo", foto);
                    upload.putExtra("caption", caption.getText().toString());
                    upload.putExtra("namaLengkap", namaLengkap);
                    upload.putExtra("username", username);
                    upload.putExtra("profil", profil);
                    startActivity(upload);

                }
            }
        });
    }
}
