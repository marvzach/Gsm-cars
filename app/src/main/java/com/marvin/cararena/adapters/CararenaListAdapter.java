package com.marvin.cararena.adapters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marvin.cararena.R;
import com.marvin.cararena.models.Carzarena;
import com.marvin.cararena.ui.CararenaDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CararenaListAdapter extends RecyclerView.Adapter<CararenaListAdapter.CararenaViewHolder> {
    private ArrayList<Carzarena> mCarzarenas = new ArrayList<>();
    private Context mContext;

    public CararenaListAdapter(Context context, ArrayList<Carzarena> carzarenas) {
        mContext = context;
        mCarzarenas = carzarenas;
    }

    @Override
    public CararenaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, parent, false);
        CararenaViewHolder viewHolder = new CararenaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CararenaViewHolder holder, int position) {
        holder.bindRestaurant(mCarzarenas.get(position));
    }

    @Override
    public int getItemCount() {
        return mCarzarenas.size();
    }

    public class CararenaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.buildImageView) ImageView mCararenaImageView;
        @BindView(R.id.carNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.priceTextView) TextView mRatingTextView;
        private Context mContext;

        public CararenaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindRestaurant(Carzarena carzarena) {
            Picasso.get().load(carzarena.getPhoto_links()).into(mCararenaImageView);
            mNameTextView.setText(carzarena.getMake());
            mCategoryTextView.setText(carzarena.getPhone());
            mRatingTextView.setText("Year Made: " + carzarena.getPrice() );
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, CararenaDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("carzarenas", Parcels.wrap(mCarzarenas));
            mContext.startActivity(intent);
        }
    }
}