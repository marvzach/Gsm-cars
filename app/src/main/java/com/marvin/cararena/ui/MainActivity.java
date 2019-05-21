package com.marvin.cararena.ui;

import android.content.Intent;
import android.graphics.Typeface;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.marvin.cararena.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  @BindView(R.id.findbutton) Button mFindRestaurantsButton;
  @BindView(R.id.appNameTextView) TextView mAppNameTextView;
  @BindView(R.id.editText) EditText mlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/black_ops_one.ttf");


        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindRestaurantsButton) {
            String build = mlocation.getText().toString();
            Toast.makeText(MainActivity.this, "searching ..", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, CararenaListActivity.class);
            intent.putExtra("build", build);
            startActivity(intent);
        }
    }
}

