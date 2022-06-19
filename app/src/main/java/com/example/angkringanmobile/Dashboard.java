package com.example.angkringanmobile;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Dashboard extends AppCompatActivity {
    //IMAGE DASHBOARD+DESKRIPSI//
    ImageView img1, img2, img3, img4, img5, img6, img7, img8;
    Button btnMainAct2, btnHome, btnKeranjang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        img1 = findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SateUsus.class);
                startActivity(i);
            }
        });
        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NasiKucing.class);
                startActivity(i);
            }
        });
        img3 = findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SateTelur.class);
                startActivity(i);
            }
        });
        img4 = findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TahuBacem.class);
                startActivity(i);
            }
        });
        img5 = findViewById(R.id.img5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SusuJahe.class);
                startActivity(i);
            }
        });
        img6 = findViewById(R.id.img6);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Ceker.class);
                startActivity(i);
            }
        });
        img7 = findViewById(R.id.img7);
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Teh.class);
                startActivity(i);
            }
        });
        img8 = findViewById(R.id.img8);
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Piscok.class);
                startActivity(i);
            }
        });
        //Button move ke list menu
        btnMainAct2 = (Button) findViewById(R.id.btnMainAct2);
        btnMainAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnMainAct = new Intent(getApplicationContext(), MainActivityCart.class);
                startActivity(btnMainAct);
            }
        });
        //Button move ke Login
        btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeBtn = new Intent(getApplicationContext(), Login.class);
                startActivity(homeBtn);
            }
        });
        //Button move ke Summary/Keranjang
        btnKeranjang = (Button) findViewById(R.id.btnKeranjang);
        btnKeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Keranjangbtn = new Intent(getApplicationContext(), SummaryActivity.class);
                startActivity(Keranjangbtn);
            }
        });

    }
}