package com.marv.cararena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CarsActivity extends AppCompatActivity {
    private String[] cars = new String[] {"Audi", "Dodge",
            "Bmw", "Jeep", "Mercedes", "Ferari",
            "Nissan GTR", "Buggati", "Royce ", "Porche",
            "HENNESSEY VENOM", "BUGATTI CHIRON", "KOENIGSEGG CCR",
            "SALEEN S7 TWIN TURBO", "MCLAREN F1"};
    private String[] price = new String[] {"2.1 million", "9.6 million dolars", "9.6 million dolars", "9.6 million dolars", "9.6 million dolars", "9.1 million dolars", "9.2 million dolars", "8.2 million dolars", "7.2 million dolars", "6.2 million dolars", "5.2 million dolars", "5.8 million dolars", "1.8 million dolars", "4.8 million dolars", "6.8 million dolars", "7.8 million dolars" };

    @BindView(R.id.modelDisplay) TextView mmodel;
    @BindView(R.id.yearDisplay) TextView myear;
    @BindView(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carsarena);
        ButterKnife.bind(this);
        cararenaAdapter adapter = new cararenaAdapter(this, android.R.layout.simple_list_item_1, cars, price);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String car = ((TextView)view).getText().toString();
                Toast.makeText(CarsActivity.this, car, Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        String model = intent.getStringExtra("model");
        String year = intent.getStringExtra("year");
        String type = intent.getStringExtra("type");
        mmodel.setText("List of cars found: " +  " Made in:" + year +" Model:" +  model + " Car Type:" + type );
    }
}
