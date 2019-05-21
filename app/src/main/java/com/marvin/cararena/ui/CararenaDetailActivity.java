package com.marvin.cararena.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;

import com.marvin.cararena.R;
import com.marvin.cararena.adapters.CararenaPagerAdapter;
import com.marvin.cararena.models.Carzarena;

import org.parceler.Parcels;

import java.util.ArrayList;


public class CararenaDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private CararenaPagerAdapter adapterViewPager;
    ArrayList<Carzarena> mCarzarenas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cararena_detail);

        ButterKnife.bind(this);

        mCarzarenas = Parcels.unwrap(getIntent().getParcelableExtra("carzarenas"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new CararenaPagerAdapter(getSupportFragmentManager(), mCarzarenas);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}