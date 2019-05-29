package com.marvin.cararenaa.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marvin.cararenaa.Constants;
import com.marvin.cararenaa.R;
import com.marvin.cararenaa.models.Carzarena;
import com.marvin.cararenaa.ui.CararenaDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }
    public void bindRestaurant(Carzarena mCarzarena) {
//        ImageView restaurantImageView = (ImageView) mView.findViewById(R.id.restaurantImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.carNameTextView);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.categoryTextView);
        TextView ratingTextView = (TextView) mView.findViewById(R.id.priceTextView);

//        Picasso.get().load(mCarzarena.getPhoto_links()).into(mImageLabel);

        nameTextView.setText(mCarzarena.getMake());
//        categoryTextView.setText(mCarzarena.getCategories().get(0));
        ratingTextView.setText("Year made: " + mCarzarena.getPrice());
    }
    @Override
    public void onClick(View view) {
        final ArrayList<Carzarena> mCarzarena = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_FOUND_CARS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    mCarzarena.add(snapshot.getValue(Carzarena.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, CararenaDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(mCarzarena));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}