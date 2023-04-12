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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private ImageView profil;
    private EditText username, namaLengkap;
    private Button btnSubmit;
    Photo myprofil;
    boolean isEmpty = false;

    private ActivityResultLauncher<Intent> launcherIntentImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result){
                    if (result.getResultCode() == RESULT_OK && result.getData() != null){
                        Uri selectedPhoto = result.getData().getData();
                        profil.setImageURI(selectedPhoto);
                        myprofil.setFotoUri(selectedPhoto);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profil = findViewById(R.id.profil);
        username = findViewById(R.id.user);
        namaLengkap = findViewById(R.id.nama);
        btnSubmit = findViewById(R.id.submit);
        myprofil = new Photo();

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
                intentPicker.setType("image/*");
                launcherIntentImage.launch(Intent.createChooser(intentPicker, "pilih foto"));
            }
        });

        btnSubmit.setOnClickListener(view -> {
            if(username.getText().length()>0 && namaLengkap.getText().length()>0 && myprofil.getFotoUri()==null){
                if (myprofil.getFotoUri() == null){
                    Toast.makeText(MainActivity.this, "Pick a Profil First", Toast.LENGTH_SHORT).show();
                }
                if (namaLengkap.getText().toString().isEmpty()){
                    namaLengkap.setError("Data tidak boleh kosong");
                    Toast.makeText(MainActivity.this, "Enter your fullname", Toast.LENGTH_SHORT).show();
                }
                if (username.getText().toString().isEmpty()){
                    username.setError("Data tidak boleh kosong");
                    Toast.makeText(MainActivity.this, "Enter yout username", Toast.LENGTH_SHORT).show();
                }
            } if (!isEmpty) {
                Intent submit = new Intent(getApplicationContext(),MainActivity2.class);
                submit.putExtra("photo", myprofil);
                submit.putExtra("namaLengkap", namaLengkap.getText().toString());
                submit.putExtra("username", username.getText().toString());
                startActivity(submit);

            } else {
                Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
