package com.example.happylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    /*
    * Description:
    * Display the quiz result, include total questions, correct and incorrect numbers.
    * Button 'Back to Main' will go to the main page.
    */
    private TextView totalQ, correctQ, wrongQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWindow().setBackgroundDrawableResource(R.drawable.background);

        totalQ = findViewById(R.id.resultTVTotalQuestionsNum);
        correctQ = findViewById(R.id.resultTVCorrectNum);
        wrongQ = findViewById(R.id.resultTVWrongNum);

        Intent intent = getIntent();
        String question = intent.getStringExtra("total");
        String correct = intent.getStringExtra("correct");
        String wrong = intent.getStringExtra("wrong");

        totalQ.setText(question);
        correctQ.setText(correct);
        wrongQ.setText(wrong);

        Button btnResultBack = findViewById(R.id.btnResultBack);
        btnResultBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, LearningAndPageSelectionActivity.class));
            }
        });
    }
}
