package com.example.happylearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.happylearning.models.CharInfo;
import com.example.happylearning.models.Quiz;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    /*
     * Description:
     * Two choices for user to select.
     * Select the correct answer, the button will turn green.
     * If the answer is wrong, the button will turn red.
     */

    ImageButton b1, b2;
    ImageButton imageButton;
    int total = 1;
    int correct = 0;
    int wrong = 0;
    int qNum = 2;

    private MediaPlayer mediaPlayer;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getWindow().setBackgroundDrawableResource(R.drawable.background);


        b1 = findViewById(R.id.quizOption1);
        b2 = findViewById(R.id.quizOption2);
        imageButton = findViewById(R.id.quizSongButton);
        updateQuestion();
        Button btnResultBack = findViewById(R.id.btnQuizBack);
        btnResultBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizActivity.this, LearningAndPageSelectionActivity.class));
            }
        });
    }

    private void updateQuestion() {
        if (total > qNum) {
            //open result activity
            Toast.makeText(this, "Completed!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("total", String.valueOf(total - 1));
            intent.putExtra("correct", String.valueOf(correct));
            intent.putExtra("wrong", String.valueOf(wrong));
            startActivity(intent);
        }
        else {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("Question").child(String.valueOf(total));
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (total == 1){
                        b1.setBackgroundResource(R.drawable.one_o);
                        b2.setBackgroundResource(R.drawable.one_t);
                        int imageId = R.drawable.one_o;
                        final int audioId = R.raw.one_o;
                        final CharInfo charInfo = new CharInfo(imageId, audioId);
                        imageButton.setOnClickListener(new View.OnClickListener() {  //set playing audio for this image button
                            @Override
                            public void onClick(View view) {
                                mediaPlayer= MediaPlayer.create(QuizActivity.this, charInfo.getAudioId());
                                mediaPlayer.start();
                            }
                        });

                    }
                    else {
                        b1.setBackgroundResource(R.drawable.one_th);
                        b2.setBackgroundResource(R.drawable.one_f);
                        int imageId = R.drawable.one_th;
                        final int audioId = R.raw.one_th;
                        final CharInfo charInfo = new CharInfo(imageId, audioId);
                        imageButton.setOnClickListener(new View.OnClickListener() {  //set playing audio for this image button
                            @Override
                            public void onClick(View view) {
                                mediaPlayer= MediaPlayer.create(QuizActivity.this, charInfo.getAudioId());
                                mediaPlayer.start();
                            }
                        });
                    }

                    Quiz quiz = dataSnapshot.getValue(Quiz.class);
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            correct += 1;
                            total += 1;
                            b1.setBackgroundColor(Color.GREEN);
                            updateQuestion();
                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrong += 1;
                            total += 1;
                            b2.setBackgroundColor(Color.RED);
                            updateQuestion();
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
