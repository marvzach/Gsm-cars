//package com.marv.cararena;
//
//import android.content.Context;
//import android.widget.ArrayAdapter;
//
//public class cararenaAdapter extends ArrayAdapter {
//    private Context mContext;
//    private String[] mcars;
//    private String[] mprice;
//
//    public cararenaAdapter(Context mContext, int resource, String[] mcars, String[] mprice) {
//        super(mContext, resource);
//        this.mContext = mContext;
//        this.mcars = mcars;
//        this.mprice = mprice;
//    }
//    @Override
//    public Object getItem(int position) {
//        String car = mcars[position];
//        String price = mprice[position];
//        return String.format("%s \nThe price is: %s", car, price);
//    }
//
//    @Override
//    public int getCount() {
//        return mcars.length;
//    }
//}
