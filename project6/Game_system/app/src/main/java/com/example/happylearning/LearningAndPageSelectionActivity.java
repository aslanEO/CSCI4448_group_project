package com.example.happylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.happylearning.view.CharListActivity;
import com.example.happylearning.view.CharListTwoActivity;

public class LearningAndPageSelectionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /*
     * Description:
     * In this page, people can choose to go to learning page or quiz page.
     * Two learning pages are provides, which are Lesson One and Lesson Two.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_quiz_select);

        getWindow().setBackgroundDrawableResource(R.drawable.background);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.learning_page, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button buttonQuiz = findViewById(R.id.goToQuiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearningAndPageSelectionActivity.this, QuizActivity.class));
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 1) {
            Intent intent0 = new Intent(LearningAndPageSelectionActivity.this, CharListActivity.class);
            startActivity(intent0);
        }
        else if (position == 2) {
            Intent intent1 = new Intent(LearningAndPageSelectionActivity.this, CharListTwoActivity.class);
            startActivity(intent1);
        }
        else {
            Toast.makeText(this,"Choose lesson to learn or take quiz.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
