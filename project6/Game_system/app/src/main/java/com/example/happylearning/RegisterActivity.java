package com.example.happylearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.happylearning.models.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    /*
     * Description:
     * User register with username, email, and password.
     * If username already existed, user need to choose a new one.
     */

    private EditText inputName;
    private EditText inputEmail;
    private EditText inputPwd;
    private Button buttonRegister;

    private DataManager dm;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getWindow().setBackgroundDrawableResource(R.drawable.background);

        dm = new DataManager();

        buttonRegister = findViewById(R.id.buttonRegisterPageSignUp);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputName = findViewById(R.id.editTextRegisterName);
                inputEmail = findViewById(R.id.editTextRegisterEmail);
                inputPwd = findViewById(R.id.editTextRegisterPwd);

                final String username = inputName.getText().toString().toLowerCase();
                databaseReference = firebaseDatabase.getInstance().getReference("users");
                Query query = databaseReference.orderByChild("username").equalTo(username);
                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            Toast.makeText(RegisterActivity.this,"Username or Email Already Exist! Please choose another one!", Toast.LENGTH_SHORT).show();
                            Intent newIntent = new Intent(RegisterActivity.this, RegisterActivity.class);
                            startActivity(newIntent);
                        }
                        else {
                            UserInfo userInfo = new UserInfo();
                            String username = inputName.getText().toString().toLowerCase();
                            String email = inputEmail.getText().toString();
                            String pwd = inputPwd.getText().toString();

                            if (!username.trim().isEmpty() &&!email.trim().isEmpty() && !pwd.trim().isEmpty()) {
                                userInfo.setUsername(username);
                                userInfo.setEmail(email);
                                userInfo.setPassword(pwd);
                                new DataManager().insert(userInfo, new DataManager.DataStatus() {
                                    @Override
                                    public void DataIsLoaded(List<UserInfo> userInfoList, List<String> keys) {

                                    }

                                    @Override
                                    public void DataIsInserted() {
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        Toast.makeText(RegisterActivity.this, "Register succeed! Please log in.", Toast.LENGTH_SHORT).show();
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void DataIsUpdated() {

                                    }

                                    @Override
                                    public void DataIsDeleted() {

                                    }
                                });
                            }
                            else {
                                Toast.makeText(RegisterActivity.this,"Username, Email, and Password are required!!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, RegisterActivity.class));
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
