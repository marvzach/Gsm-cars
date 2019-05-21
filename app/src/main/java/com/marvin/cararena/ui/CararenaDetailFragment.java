package com.marvin.cararena.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marvin.cararena.R;
import com.marvin.cararena.models.Carzarena;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CararenaDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CararenaDetailFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.buildImageView) ImageView mImageLabel;
    @BindView(R.id.carNameTextView) TextView mNameLabel;
    @BindView(R.id.cuisineTextView) TextView mCategoriesLabel;
    @BindView(R.id.priceTextView) TextView mPriceLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.savecarButton) TextView mSaveCarButton;

//    private Carzarena mCarzarena;
//
//    public static CararenaDetailFragment newInstance(Carzarena carzarena) {
//        CararenaDetailFragment cararenaDetailFragment = new CararenaDetailFragment();
//        Bundle args = new Bundle();
//        args.putParcelable("carzarena", Parcels.wrap(carzarena));
//        cararenaDetailFragment.setArguments(args);
//        return cararenaDetailFragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mCarzarena = Parcels.unwrap(getArguments().getParcelable("carzarena"));
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_cararena_detail, container, false);
//        ButterKnife.bind(this, view);
//        mWebsiteLabel.setOnClickListener(this);
//        mPhoneLabel.setOnClickListener(this);
//        mAddressLabel.setOnClickListener(this);
//        Picasso.get().load(mCarzarena.getPhoto_links()).into(mImageLabel);
//
//        mNameLabel.setText(mCarzarena.getMake());
////        mCategoriesLabel.setText(android.text.TextUtils.join(", ", mCarzarena.getDealer()));
//        mPriceLabel.setText(mCarzarena.getPrice() + " "+"is the year made");
//        mPhoneLabel.setText(mCarzarena.getPhone());
////        mAddressLabel.setText(android.text.TextUtils.join(", ", mCarzarena.getBuild()));
//
//        return view;
//    }
////implicit intents//
//    @Override
//    public void onClick(View v) {
//        if (v == mWebsiteLabel) {
//            Intent webIntent = new Intent(Intent.ACTION_VIEW,
//                    Uri.parse(mCarzarena.getWebsite()));
//            startActivity(webIntent);
//        }
//
//        if (v == mAddressLabel) {
//            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("geo:" + mCarzarena.getLatitude()
//                            + "," + mCarzarena.getLongitude()
//                            + "?q=(" + mCarzarena.getMake() + ")"));
//            startActivity(mapIntent);
//        }
//        if (v == mPhoneLabel) {
//            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("tel:" + mCarzarena.getPhone()));
//            startActivity(mapIntent);
//        }
//    }
//}