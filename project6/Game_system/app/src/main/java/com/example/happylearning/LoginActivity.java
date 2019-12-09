package com.example.happylearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

public class LoginActivity extends AppCompatActivity {

    /*
     * Description:
     * For user to log in with their username and password.
     * If the username does not meet the record, user will not allowed to log in.
     * If user don't have an account, they can click on "sign up" button to register.
     */

    private EditText loginUsername;
    private EditText loginPwd;

    private String key;

    private DataManager dm;

    private DatabaseReference userReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set background
        getWindow().setBackgroundDrawableResource(R.drawable.background);

        dm = new DataManager();

        // match username and password, then login
        Button buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsername = findViewById(R.id.editTextLogInPageName);
                loginPwd = findViewById(R.id.editTextLoginPagePwd);

                final String username = loginUsername.getText().toString().toLowerCase();
                String pwd = loginPwd.getText().toString();
                if (!username.trim().isEmpty() && !pwd.trim().isEmpty()){
                    userReference = FirebaseDatabase.getInstance().getReference("users");
                    Query query1 = userReference.orderByChild("username").equalTo(username);
                    query1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                Toast.makeText(LoginActivity.this,"Log in succeed. Congrats!", Toast.LENGTH_SHORT).show();
                                Intent newIntent = new Intent(LoginActivity.this, LearningAndPageSelectionActivity.class);
                                startActivity(newIntent);
                            }
                            else {
                                Toast.makeText(LoginActivity.this,"Username or password does not match our record. Please try again!", Toast.LENGTH_SHORT).show();
                                Intent newIntent = new Intent(LoginActivity.this, LoginActivity.class);
                                startActivity(newIntent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else {
                    Toast.makeText(LoginActivity.this, "Username and Password mush be entered!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, LoginActivity.class));
                }
                Button buttonLoginToSignup = findViewById(R.id.buttonLoginPageSignUp);
                buttonLoginToSignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        Button guestButton = findViewById(R.id.loginAsGuest);
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, LearningAndPageSelectionActivity.class));
            }
        });
    }
}
