package com.example.praktikum2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import com.example.praktikum2.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    String process;
    String operator;
    int lenghtsecondNumber;

    private ActivityMainBinding binding;
    private boolean firstOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.button.btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstOperator = false;
                binding.layout.nilai.setText("");
                binding.layout.hasil.setText("");
                operator = null;
                binding.button.btnbagi.setEnabled(true);
                binding.button.btnkurang.setEnabled(true);
                binding.button.btnkali.setEnabled(true);
                binding.button.btntambah.setEnabled(true);
                lenghtsecondNumber=0;
            }
        });


        binding.button.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }

                process = binding.layout.nilai.getText().toString();
                if (process.length() == 1 && process.equals("0"))
                {
                    binding.layout.nilai.setText(process.replace("0","0"));
                }else {

                    binding.layout.nilai.setText(process + "0");
                }
                if (operator != null) {
                    lenghtsecondNumber++;
                }
            }

        });

        binding.button.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }
                process = binding.layout.nilai.getText().toString();
                if (process.length() == 1 && process.equals("0"))
                {
                    binding.layout.nilai.setText(process.replace("0","1"));
                }else {

                    binding.layout.nilai.setText(process + "1");
                }
                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }
                process = binding.layout.nilai.getText().toString();
                if (process.length() == 1 && process.equals("0"))
                {
                    binding.layout.nilai.setText(process.replace("0","2"));
                }else {

                    binding.layout.nilai.setText(process + "2");
                }
                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }
                process = binding.layout.nilai.getText().toString();
                if (process.length() == 1 && process.equals("0"))
                {
                    binding.layout.nilai.setText(process.replace("0","3"));
                }else {

                    binding.layout.nilai.setText(process + "3");
                }
                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }
                process = binding.layout.nilai.getText().toString();
                if (process.length() == 1 && process.equals("0"))
                {
                    binding.layout.nilai.setText(process.replace("0","3"));
                }else {

                    binding.layout.nilai.setText(process + "3");
                }
                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }
                process = binding.layout.nilai.getText().toString();
                if (process.length() == 1 && process.equals("0"))
                {
                    binding.layout.nilai.setText(process.replace("0","5"));
                }else {

                    binding.layout.nilai.setText(process + "5");
                }
                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }
                process = binding.layout.nilai.getText().toString();
                if (process.length() == 1 && process.equals("0"))
                {
                    binding.layout.nilai.setText(process.replace("0","6"));
                }else {

                    binding.layout.nilai.setText(process + "6");
                }
                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }
                process = binding.layout.nilai.getText().toString();
                binding.layout.nilai.setText(process + "7");
                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }
                process = binding.layout.nilai.getText().toString();
                if (process.length() == 1 && process.equals("0"))
                {
                    binding.layout.nilai.setText(process.replace("0","8"));
                }else {

                    binding.layout.nilai.setText(process + "8");
                }
                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }





                process = binding.layout.nilai.getText().toString();
                if (process.length() == 1 && process.equals("0"))
                {
                    binding.layout.nilai.setText(process.replace("0","9"));
                }else {

                    binding.layout.nilai.setText(process + "9");
                }
                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOperator==true){
                    if (lenghtsecondNumber == 0){
                        process = binding.layout.nilai.getText().toString();
                        if(operator == null){
                            binding.layout.nilai.setText(process + "+");
                        }else {
                            binding.layout.nilai.setText(process.substring(0,process.length()-1)+ "+");
                        }
                        operator = "+";

                    } else {
                        binding.button.btnbagi.setEnabled(false);
                        binding.button.btnkurang.setEnabled(false);
                        binding.button.btnkali.setEnabled(false);
                    }
                }
            }
        });

        binding.button.btnkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOperator==true) {
                    if (lenghtsecondNumber == 0) {
                        process = binding.layout.nilai.getText().toString();
                        if (operator == null) {
                            binding.layout.nilai.setText(process + "-");
                        } else {
                            binding.layout.nilai.setText(process.substring(0, process.length() - 1) + "-");
                        }
                        operator = "-";

                    } else {
                        binding.button.btntambah.setEnabled(false);
                        binding.button.btnbagi.setEnabled(false);
                        binding.button.btnkali.setEnabled(false);
                    }
                }
            }
        });

        binding.button.btnkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOperator==true) {
                    if (lenghtsecondNumber == 0) {
                        process = binding.layout.nilai.getText().toString();
                        if (operator == null) {
                            binding.layout.nilai.setText(process + "X");
                        } else {
                            binding.layout.nilai.setText(process.substring(0, process.length() - 1) + "X");
                        }
                        operator = "X";


                    } else {
                        binding.button.btntambah.setEnabled(false);
                        binding.button.btnkurang.setEnabled(false);
                        binding.button.btnbagi.setEnabled(false);
                    }
                }
            }
        });

        binding.button.btnbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOperator==true) {
                    if (lenghtsecondNumber == 0) {
                        process = binding.layout.nilai.getText().toString();
                        if (operator == null) {
                            binding.layout.nilai.setText(process + ":");
                        } else {
                            binding.layout.nilai.setText(process.substring(0, process.length() - 1) + ":");
                        }
                        operator = ":";

                    } else {
                        binding.button.btntambah.setEnabled(false);
                        binding.button.btnkurang.setEnabled(false);
                        binding.button.btnkali.setEnabled(false);
                    }
                }
            }
        });

        binding.button.btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = binding.layout.nilai.getText().toString();
                int input = word.length();
                if (input > 0) {
                    binding.layout.nilai.setText(word.substring(0, input -1));

                    if (lenghtsecondNumber==0){
                        operator=null;
                        lenghtsecondNumber=0;
                        binding.button.btnbagi.setEnabled(true);
                        binding.button.btnkurang.setEnabled(true);
                        binding.button.btnkali.setEnabled(true);
                        binding.button.btntambah.setEnabled(true);
                    } else {
                        lenghtsecondNumber--;
                    }
                }
            }
        });

        binding.button.btnhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double finalResult=0;
                int finalResult2=0;
                process = binding.layout.nilai.getText().toString();
                String hasil[] = process.split("[:X+-]");

                try {
                    System.out.println(process);
                    double satu = Double.parseDouble(hasil[0]);
                    double dua = Double.parseDouble(hasil[1]);

                    System.out.println((int)dua);
                    if ((int)dua == 0){
                        throw new Exception();
                    }


                    if (operator == "X") {
                        finalResult2 = (int) satu * (int) dua;
                        binding.layout.hasil.setText(String.valueOf(finalResult2));
                    } else if (operator == "-") {
                        finalResult2 = (int) satu - (int) dua;
                        binding.layout.hasil.setText(String.valueOf(finalResult2));
                    } else if (operator == "+") {
                        finalResult2 = (int) satu + (int) dua;
                        binding.layout.hasil.setText(String.valueOf(finalResult2));
                    } else if (operator == ":"){
                        finalResult = satu / dua;
                        DecimalFormat format = new DecimalFormat("0.#");
                        String Tiga = (format.format(finalResult));
                        binding.layout.hasil.setText(Tiga);

                    }


                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Input Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}