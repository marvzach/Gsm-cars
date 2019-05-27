package com.marvin.cararenaa.adapters;

import com.marvin.cararenaa.models.Carzarena;
import com.marvin.cararenaa.ui.CararenaDetailFragment;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CararenaPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Carzarena> mCarzarenas;

    public CararenaPagerAdapter(FragmentManager fm, ArrayList<Carzarena> carzarenas) {
        super(fm);
        mCarzarenas = carzarenas;
    }

    @Override
    public Fragment getItem(int position) {
        return CararenaDetailFragment.newInstance(mCarzarenas.get(position));
    }

    @Override
    public int getCount() {
        return mCarzarenas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCarzarenas.get(position).getMake();
    }
}