package com.marvin.cararenaa.ui;

import android.content.Intent;
import android.graphics.Typeface;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.marvin.cararenaa.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Findcars extends AppCompatActivity implements View.OnClickListener {
  @BindView(R.id.findbutton) Button mFindRestaurantsButton;
  @BindView(R.id.appNameTextView) TextView mAppNameTextView;
  @BindView(R.id.editText) EditText mlocation;
//    @BindView(R.id.search) EditText msearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findcars);
        ButterKnife.bind(this);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");

//        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String location = mlocation.getText().toString();
//                Toast.makeText(Findcars.this , "searching .." ,Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(Findcars.this , CararenaListActivity.class);
//                intent.putExtra("location", location);
//                startActivity(intent);
//            }
//        });
        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindRestaurantsButton) {
            String build = mlocation.getText().toString();
            Toast.makeText(Findcars.this, "searching ..", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Findcars.this, CararenaListActivity.class);
            intent.putExtra("build", build);
            startActivity(intent);
        }
    }
}

