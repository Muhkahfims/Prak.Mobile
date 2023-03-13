package com.example.praktikum12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int shapedSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner shapes = findViewById(R.id.listItem);
        Button Submit = findViewById(R.id.btnhitung);

        final EditText jari = findViewById(R.id.jari);
        final EditText panjang = findViewById(R.id.panjang);
        final EditText lebar = findViewById(R.id.lebar);
        final EditText tinggi = findViewById(R.id.tinggi);

        final TextView hasil = findViewById(R.id.txthasil);

        shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    panjang.setVisibility(View.GONE);
                    lebar.setVisibility(View.GONE);
                    tinggi.setVisibility(View.GONE);
                    jari.setVisibility(View.VISIBLE);
                    shapedSelected = 0;
                }
                if (i == 1) {
                    panjang.setVisibility(View.GONE);
                    lebar.setVisibility(View.GONE);
                    tinggi.setVisibility(View.VISIBLE);
                    jari.setVisibility(View.VISIBLE);
                    shapedSelected = 1;
                }
                if (i == 2) {
                    jari.setVisibility(View.GONE);
                    panjang.setVisibility(View.VISIBLE);
                    lebar.setVisibility(View.VISIBLE);
                    tinggi.setVisibility(View.VISIBLE);
                    shapedSelected = 2;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (shapedSelected == 0) {
                    try {
                        if (jari == null){
                            jari.setError("masukkan nilai");
                        }else {
                            double radius = Double.parseDouble(jari.getText().toString());
                            double result = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
                            hasil.setText(String.format("%.2f", result));;
                        }
                    }catch (NumberFormatException exception){
                        Toast.makeText(MainActivity.this, "tidak dapat menghitung hasil", Toast.LENGTH_SHORT).show();
                    }

                }
                else if (shapedSelected == 1) {
                    try {
                        if (jari == null || tinggi == null){
                            jari.setError("masukkan nilai");
                            tinggi.setError("masukkan nilai");
                        }else {
                            double radius = Double.parseDouble(jari.getText().toString());
                            double high = Double.parseDouble(tinggi.getText().toString());
                            double result = (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * high;
                            hasil.setText(String.format("%.2f", result));
                        }
                    }catch (NumberFormatException exception){
                        Toast.makeText(MainActivity.this, "tidak dapat menghitung nilai", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (shapedSelected == 2) {
                    try {
                        if (panjang == null || lebar == null || tinggi == null){
                            panjang.setError("masukkan nilai");
                            lebar.setError("masukkan nilai");
                            tinggi.setError("masukkan nilai");
                        }else {
                            double length = Double.parseDouble(panjang.getText().toString());
                            double width = Double.parseDouble(lebar.getText().toString());
                            double high = Double.parseDouble(tinggi.getText().toString());
                            double result = length * width * high;
                            hasil.setText(String.valueOf(result));
                        }
                    }catch (NumberFormatException exception){
                        Toast.makeText(MainActivity.this, "tidak dapat menghitung nilai", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}