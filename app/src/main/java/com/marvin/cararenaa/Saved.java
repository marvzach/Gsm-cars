//package com.marvin.cararenaa;
//
//import android.content.Intent;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.GridView;
//import android.widget.ImageView;
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//import android.R;
//import com.marvin.cararenaa.models.FirebaseViewHolder;
//import com.marvin.cararenaa.adapters.CararenaPagerAdapter;
//import com.marvin.cararenaa.adapters.CararenaListAdapter;
//import com.marvin.cararenaa.adapters.CararenaListAdapter;
//import com.marvin.cararenaa.Constants;
//import com.marvin.cararenaa.models.Carzarena;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.marvin.cararenaa.ui.Findcars;
//
//
//
//
//
//public class Saved extends AppCompatActivity implements View.OnClickListener {
//
//    GridView gridView;
//
//    String[] cars = new String[]{
//            "BMW" , "Mc Lauren","Bugatti"
//    };
//    String[] newCars = new String[]{
//            "Benz" , "Lamboghini","Chevrolet"
//    };
//
//    @BindView(R.id.home) ImageView mHome;
//    @BindView(R.id.recView) RecyclerView mRecyclerView;
//    private DatabaseReference mPrice;
//    private FirebaseRecyclerAdapter<Carzarena, FirebaseViewHolder> mFirebaseAdapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_saved);
//        ButterKnife.bind(this);
//        mHome.setOnClickListener(this);
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//        mPrice = FirebaseDatabase.getInstance().getReference(Authsave.FIREBASE_FOUND_CARS).child(uid);
//        setUpFirebaseAdapter();
//
//    }
//
//    private void setUpFirebaseAdapter(){
//        FirebaseRecyclerOptions<Carzarena> options =
//                new FirebaseRecyclerOptions.Builder<Carzarena>()
//                        .setQuery(mPrice, Carzarena.class)
//                        .build();
//
//        mFirebaseAdapter = new FirebaseRecyclerAdapter<Carzarena, FirebaseViewHolder>(options) {
//            @Override
//                        firebaseRestaurantViewHolder.bindCompanies(mCarzarena);
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
//
//    @Override
//    public void onClick(View v) {
//        if(v == mHome){
//            Intent intent = new Intent(Saved.this, Findcars.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//            startActivityForResult(intent, 0);
//        }
//
//    }
//
//}
