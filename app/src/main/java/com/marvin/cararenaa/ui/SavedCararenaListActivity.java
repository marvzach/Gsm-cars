//package com.marvin.cararenaa.ui;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import com.marvin.cararenaa.Authsave;
//import com.marvin.cararenaa.R;
//import com.marvin.cararenaa.models.FirebaseViewHolder;
//import com.marvin.cararenaa.models.Carzarena;
//
//
//
//public class SavedCararenaListActivity extends AppCompatActivity{
//
//    private DatabaseReference mCarzarenaReference;
//    private FirebaseRecyclerAdapter<Carzarena, FirebaseViewHolder> mFirebaseAdapter;
//
//    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_restaurants);
//        ButterKnife.bind(this);
//
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//        mCarzarenaReference = FirebaseDatabase.getInstance().getReference(Authsave.FIREBASE_FOUND_CARS).child(uid);
//        setUpFirebaseAdapter();
//    }
//
//    private void setUpFirebaseAdapter(){
//        FirebaseRecyclerOptions<Carzarena> options =
//                new FirebaseRecyclerOptions.Builder<Carzarena>()
//                        .setQuery(mCarzarenaReference, Carzarena.class)
//                        .build();
//
//        mFirebaseAdapter = new FirebaseRecyclerAdapter<Carzarena, FirebaseViewHolder>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull FirebaseViewHolder firebaseRestaurantViewHolder, int position, @NonNull Restaurant restaurant) {
//                firebaseRestaurantViewHolder.bindRestaurant(restaurant);
//            }
//
//            @NonNull
//            @Override
//            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, parent, false);
//                return new FirebaseViewHolder(view);
//            }
//        };
//
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(mFirebaseAdapter);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mFirebaseAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if(mFirebaseAdapter!= null) {
//            mFirebaseAdapter.stopListening();
//        }
//    }
//}
