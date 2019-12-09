package com.example.happylearning;

import androidx.annotation.NonNull;

import com.example.happylearning.models.UserInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    /*
     * Description:
     * Connect to cloud database - firebase.
     * Managing data, for example, create, read, update, and delete.
     */

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference userReference;
    private DatabaseReference learnReference;
    private List<UserInfo> userInfoList = new ArrayList<>();

    public DataManager() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        userReference = firebaseDatabase.getReference("users");

    }

    /* Template Pattern */
    public interface DataStatus {
        void DataIsLoaded(List<UserInfo> userInfoList, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public void readUserInfo(final DataStatus dataStatus) {
        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userInfoList.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    UserInfo userInfo = keyNode.getValue(UserInfo.class);
                    userInfoList.add(userInfo);
                }
                dataStatus.DataIsLoaded(userInfoList, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void insert(UserInfo userInfo, final DataStatus dataStatus) {
        String key = userReference.push().getKey();
        userReference.child(key).setValue(userInfo)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsInserted();
                    }
                });
        }

    public void update(String key, UserInfo userInfo, final DataStatus dataStatus) {
        userReference.child(key).setValue(userInfo)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsUpdated();
                    }
                });
    }

    public void delete(String key, final DataStatus dataStatus) {
        userReference.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsDeleted();
                    }
                });
    }
}

