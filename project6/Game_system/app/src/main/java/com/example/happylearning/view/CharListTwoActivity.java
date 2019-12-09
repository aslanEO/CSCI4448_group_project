package com.example.happylearning.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.happylearning.R;
import com.example.happylearning.models.CharInfo;

import java.util.ArrayList;
import java.util.List;

public class CharListTwoActivity extends AppCompatActivity {

    /*
     * Description:
     * Learning page for Lesson Two.
     * Adapter pattern was applied in the class for list view.
     */

    private List<CharInfo> CharList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_list_two);
        initChar();

        /* Adapter Pattern */
        CharAdapter arrayAdapter = new CharAdapter(CharListTwoActivity.this, R.layout.list_info, CharList);

        android.widget.ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);

    }
    private void initChar() {
        CharInfo two_zero = new CharInfo(R.drawable.two_zero,R.raw.two_zero);
        CharList.add(two_zero);
        CharInfo two_one = new CharInfo(R.drawable.two_one,R.raw.two_one);
        CharList.add(two_one);
        CharInfo two_two = new CharInfo(R.drawable.two_two,R.raw.two_two);
        CharList.add(two_two);
        CharInfo two_three = new CharInfo(R.drawable.two_three,R.raw.two_three);
        CharList.add(two_three);
        CharInfo two_four = new CharInfo(R.drawable.two_four,R.raw.two_four);
        CharList.add(two_four);
        CharInfo two_five = new CharInfo(R.drawable.two_five,R.raw.two_five);
        CharList.add(two_five);
    }
}
