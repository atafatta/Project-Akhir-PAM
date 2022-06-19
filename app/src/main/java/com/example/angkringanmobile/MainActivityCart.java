package com.example.angkringanmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivityCart extends AppCompatActivity {
    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cart);

        //membuat arraylist
        modelList = new ArrayList<>();
        modelList.add(new Model("Nasi Kucing", getString(R.string.nasikucing), R.drawable.cartnasikucing ));
        modelList.add(new Model("Sate Ati", getString(R.string.sateati), R.drawable.cartsateati));
        modelList.add(new Model("Ceker", getString(R.string.ceker), R.drawable.cartceker));
        modelList.add(new Model("Sate Telur", getString(R.string.satetelur), R.drawable.cartsatetelur));
        modelList.add(new Model("Sate Usus", getString(R.string.sateusus), R.drawable.cartsateusus));
        modelList.add(new Model("Teh Panas/Dingin", getString(R.string.teh), R.drawable.cartteh));
        modelList.add(new Model("Susu Jahe", getString(R.string.susujahe), R.drawable.cartsusujahe));
        modelList.add(new Model("Tahu Bacem", getString(R.string.tahubacem), R.drawable.carttahubacem));
        modelList.add(new Model("Pisang Coklat", getString(R.string.piscok), R.drawable.cartpiscok));

        //recycler view
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        //adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);

    }
}