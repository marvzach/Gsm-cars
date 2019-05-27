//package com.marvin.cararenaa.models;
//
//import android.content.Context;
//import android.content.Intent;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import android.view.View;
//import android.widget.TextView;
//
//import com.marvin.cararenaa.Authsave;
//import com.marvin.cararenaa.R;
//import com.marvin.cararenaa.ui.CararenaDetailActivity;
//import com.marvin.cararenaa.Constants;
//import com.marvin.cararenaa.models.Carzarena;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import org.parceler.Parcels;
//
//import java.util.ArrayList;
//
//public class FirebaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//    View mView;
//    Context mContext;
//    public FirebaseViewHolder(View itemView) {
//        super(itemView);
//        mView = itemView;
//        mContext = itemView.getContext();
//        itemView.setOnClickListener(this);
//    }
//public void bindCompanies(Carzarena carzarena){
//    TextView nameTextView = mView.findViewById(R.id.carNameTextView);
//    nameTextView.setText(mCarzarena.getMake());
//    TextView publication = mView.findViewById(R.id.websiteTextView);
//    publication.setText("published :"+" "+mCarzarena.getBody_type());
//
//}    @Override
//    public void onClick(View v) {
//        final ArrayList<CompanyModel> restaurants = new ArrayList<>();
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Authsave.FIREBASE_FOUND_CARS).child(uid);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
//                    restaurants.add(snapshot.getValue(CompanyModel.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//                Intent intent = new Intent(mContext, companyDetailActivity.class);
//                intent.putExtra("position", itemPosition + "");
//                intent.putExtra("company", Parcels.wrap(restaurants));
//
//                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//}
