//package com.marvin.cararena.adapters;
//
//import android.content.Context;
//import android.widget.ArrayAdapter;
//
//public class CararenaAdapter extends ArrayAdapter {
//    private Context mContext;
//    private String[] mcars;
//    private String[] mCuisines;
//
//    public CararenaAdapter(Context mContext, int resource, String[] mcars, String[] mCuisines) {
//        super(mContext, resource);
//        this.mContext = mContext;
//        this.mcars = mcars;
//        this.mCuisines = mCuisines;
//    }
//    @Override
//    public Object getItem(int position) {
//        String restaurant = mcars[position];
//        String cuisine = mCuisines[position];
//        return String.format("%s \nServes great: %s", restaurant, cuisine);
//    }
//
//    @Override
//    public int getCount() {
//        return mcars.length;
//    }
//}
