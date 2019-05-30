package com.marvin.cararenaa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.marvin.cararenaa.adapters.FirebaseViewHolder;
import com.marvin.cararenaa.models.Carzarena;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedCarDetailsActivity extends AppCompatActivity {
    private DatabaseReference mCarsReference;
    private FirebaseRecyclerAdapter<Carzarena, FirebaseViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savedcars);
        ButterKnife.bind(this);

        mCarsReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_FOUND_CARS);
        setUpFirebaseAdapter();
}
    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Carzarena> options =
                new FirebaseRecyclerOptions.Builder<Carzarena>()
                        .setQuery(mCarsReference, Carzarena.class)
                        .build();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Carzarena, FirebaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder firebaseCarzViewHolder, int position, @NonNull Carzarena cars) {
                firebaseCarzViewHolder.bindRestaurant(cars);
            }
            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, parent, false);
                return new FirebaseViewHolder(view);
            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}

